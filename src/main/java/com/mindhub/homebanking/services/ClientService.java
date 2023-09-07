package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {

    void saveClient(Client client);

    ClientDTO getClientDTO(Long id);

    ClientDTO getClientDTOByEmail(String email);
    List<ClientDTO> getClientsDTO();

    Client findByEmail(String email);

    Client findById(Long id);


}
