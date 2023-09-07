package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository,
									  AccountRepository accountRepository,
									  TransactionRepository transactionRepository,
									  LoanRepository loanRepository,
									  ClientLoanRepository clientLoanRepository,
									  CardRepository cardRepository){
		return (args) -> {
			// Create transactions
			//Transaction transaction1 = new Transaction(TransactionType.CREDIT, 30000, "Direct Deposit - Salary", LocalDateTime.now());
			//Transaction transaction2 = new Transaction(TransactionType.DEBIT, -9000, "Rent payment", LocalDateTime.now());
			//Transaction transaction3 = new Transaction(TransactionType.CREDIT, 10000, "Sale", LocalDateTime.now());
			//Transaction transaction4 = new Transaction(TransactionType.DEBIT, -1200, "Interest payment", LocalDateTime.now());
			//Transaction transaction5 = new Transaction(TransactionType.CREDIT, 1500, "Direct Deposit - Interest", LocalDateTime.now());

			// Create accounts
			//Account account1 = new Account("VIN001", LocalDate.now(), 5000);
			//Account account2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500);
			//Account account3 = new Account("VIN003", LocalDate.now().plusDays(2), 20000);
			//Account account4 = new Account("VIN004", LocalDate.now().plusDays(3), 15000);

			//Creating clients
			//Client client1 = new Client("Melba", "Morel", "mmorel@mindhub.com", passwordEncoder.encode("Mmorel!!"));
			//Client client2 = new Client("Rodrigo", "Ribeiro", "rribeiro@mindhub.com", passwordEncoder.encode("juanita"));

			//Creating admin
			//Client client3 = new Client("admin", "admin", "admin@mindhub.com", passwordEncoder.encode("admin123"));

			//Creating three types for Loan
			//Loan loan1 = new Loan("Mortgage", 500000, List.of(12, 24, 36, 48, 60));
			//Loan loan2 = new Loan("Personal", 100000, List.of(6, 12, 24));
			//Loan loan3 = new Loan("Automotive", 300000, List.of(6, 12, 24, 36));

			//ClientLoan clientLoan1 = new ClientLoan(400000, 60);
			//ClientLoan clientLoan2 = new ClientLoan(50000, 12);
			//ClientLoan clientLoan3 = new ClientLoan(100000, 24);
			//ClientLoan clientLoan4 = new ClientLoan(200000, 36);

			//client1.addClientLoan(clientLoan1);
			//client1.addClientLoan(clientLoan2);
			//client2.addClientLoan(clientLoan3);
			//client2.addClientLoan(clientLoan4);

			//loan1.addClientLoan(clientLoan1);
			//loan2.addClientLoan(clientLoan2);
			//loan2.addClientLoan(clientLoan3);
			//loan3.addClientLoan(clientLoan4);

			//Creating Cards for Client1
			//Card card1 = new Card("2500-4585-6587-5001", 291, LocalDateTime.now(), LocalDateTime.now().plusYears(5), CardType.DEBIT, CardColor.GOLD);
			//Card card2 = new Card("5894-2158-8421-4587", 587, LocalDateTime.now(), LocalDateTime.now().plusYears(5), CardType.CREDIT, CardColor.TITANIUM);
			//Creating Cards for Client2
			//Card card3 = new Card("7587 2587 1278 0479", 302, LocalDateTime.now(), LocalDateTime.now().plusYears(5), CardType.CREDIT, CardColor.TITANIUM);
			//Card card4 = new Card("6657-1587-9650-2478", 755, LocalDateTime.now(), LocalDateTime.now().plusYears(5), CardType.DEBIT, CardColor.SILVER);


			//loanRepository.save(loan1);
			//loanRepository.save(loan2);
			//loanRepository.save(loan3);


			//clientRepository.save(client1);
			//clientRepository.save(client2);
			//clientRepository.save(client3);


			//client1.addAccount(account1);
			//client1.addAccount(account2);
			//client2.addAccount(account3);
			//client2.addAccount(account4);

			//accountRepository.save(account1);
			//accountRepository.save(account2);
			//accountRepository.save(account3);
			//accountRepository.save(account4);

			//account1.addTransaction(transaction1);
			//account2.addTransaction(transaction2);
			//account2.addTransaction(transaction3);
			//account3.addTransaction(transaction4);
			//account4.addTransaction(transaction5);

			//transactionRepository.save(transaction1);
			//transactionRepository.save(transaction2);
			//transactionRepository.save(transaction3);
			//transactionRepository.save(transaction4);
			//transactionRepository.save(transaction5);

			//clientLoanRepository.save(clientLoan1);
			//clientLoanRepository.save(clientLoan2);
			//clientLoanRepository.save(clientLoan3);
			//clientLoanRepository.save(clientLoan4);

			//client1.addCard(card1);
			//client1.addCard(card2);
			//client2.addCard(card3);
			//client2.addCard(card4);

			//cardRepository.save(card1);
			//cardRepository.save(card2);
			//cardRepository.save(card3);
			//cardRepository.save(card4);



		};
	}
}
