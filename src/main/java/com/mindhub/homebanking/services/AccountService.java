package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.models.Account;

import java.util.List;

public interface AccountService {

    void saveAccount(Account account);

    AccountDTO getAccountDTO(Long id);

    AccountDTO getAccountDTOByNumber(String number);

    List<AccountDTO> getAccountsDTO();

    Account findByNumber(String number);
}
