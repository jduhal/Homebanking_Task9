package com.mindhub.homebanking.services.implement;

import com.mindhub.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImplement implements AccountService {

    @Autowired
    private AccountRepository accountRepository ;
    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public AccountDTO getAccountDTO(Long id) {
        return new AccountDTO(accountRepository.getById(id));
    }

    @Override
    public AccountDTO getAccountDTOByNumber(String number) {
        return new AccountDTO(this.findByNumber(number));
    }

    @Override
    public List<AccountDTO> getAccountsDTO() {
        return accountRepository.findAll().stream().map(AccountDTO::new).collect(Collectors.toList());
    }

    @Override
    public Account findByNumber(String number) {
        Optional<Account> account = Optional.ofNullable(accountRepository.findByNumber(number));
        return account.orElse(null);
    }
}
