package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dtos.CardDTO;
import com.mindhub.homebanking.models.Card;

import java.util.List;

public interface CardService {

    void saveCard(Card card);

    CardDTO getCardDTOByNumber(String number);

    List<CardDTO> getCardsDTO();

    Card findByNumber(String number);
}
