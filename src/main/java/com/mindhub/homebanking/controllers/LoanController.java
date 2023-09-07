package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.LoanApplicationoDTO;
import com.mindhub.homebanking.dtos.LoanDTO;
import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private ClientLoanService clientLoanService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ClientService clientService;

    public LoanController() {
    }


    @RequestMapping("/loans")
    public List<LoanDTO> getLoans() {
        return loanService.getLoansDTO();
    }

    @Transactional
    @RequestMapping(path = "/loans", method = RequestMethod.POST)
    public ResponseEntity<Object> createLoan(@RequestBody LoanApplicationoDTO loanApplicationoDTO,
                                             Authentication auth) {

        if(loanApplicationoDTO.getPayments() == 0 || loanApplicationoDTO.getToAccountNumber().isEmpty() || loanApplicationoDTO.getAmount() == 0 ) {
            return new ResponseEntity<>("Invalid data", HttpStatus.FORBIDDEN);
        }

        List<Loan> listOfLoans = loanService.getLoans();

        if (listOfLoans.stream().noneMatch(loan -> loan.getId() == loanApplicationoDTO.getLoanId())) {
            return new ResponseEntity<>("Loan type does not exist", HttpStatus.FORBIDDEN);
        }

        Loan loanSelected = loanService.findById(loanApplicationoDTO.getLoanId());
        if ( loanApplicationoDTO.getAmount() > loanSelected.getMaxAmount()){
            return new ResponseEntity<>("Cannot exceed loan maximum amount", HttpStatus.FORBIDDEN);
        }

        if (loanSelected.getPayments().stream().noneMatch( loanPayments -> loanPayments == loanApplicationoDTO.getPayments())) {
            return new ResponseEntity<>("Must select a valid number of payments", HttpStatus.FORBIDDEN);
        }

        //Account existing and being property of user, yet to validate
        Account destinyAccount = accountService.findByNumber(loanApplicationoDTO.getToAccountNumber());
        //Apart from that...

        //double interest = 1 + 0.1 * loanApplicationoDTO.getPayments() / 6;
        double interest = 1.2;


        ClientLoan requestedLoan = new ClientLoan((int)(loanApplicationoDTO.getAmount() * interest), loanApplicationoDTO.getPayments());
        Transaction creditLoanTransaction = new Transaction(TransactionType.CREDIT, loanApplicationoDTO.getAmount(), "" + loanSelected.getName() + " - loan approved", LocalDateTime.now());
        destinyAccount.addAmount(loanApplicationoDTO.getAmount());
        destinyAccount.addTransaction(creditLoanTransaction);

        Client actualClient = clientService.findByEmail(auth.getName());
        actualClient.addClientLoan(requestedLoan);
        loanSelected.addClientLoan(requestedLoan);
        clientLoanService.saveClientLoan(requestedLoan);
        transactionService.saveTransaction(creditLoanTransaction);
        loanService.saveLoan(loanSelected);
        clientService.saveClient(actualClient);



        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
