package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dtos.LoanDTO;
import com.mindhub.homebanking.models.Loan;

import java.util.List;

public interface LoanService {

    void saveLoan(Loan loan);

    List<LoanDTO> getLoansDTO();

    List<Loan> getLoans();

    Loan findById(Long id);
}
