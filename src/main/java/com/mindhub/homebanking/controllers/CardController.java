package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.services.CardService;
import com.mindhub.homebanking.services.ClientService;
import com.mindhub.homebanking.services.implement.CardServiceImplement;
import com.mindhub.homebanking.services.implement.ClientServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class CardController {

    private Random random = new Random();

    @Autowired
    private CardService cardService;

    @Autowired
    private ClientService clientService;

    private CardController() {
    }

    @RequestMapping(path = "/clients/current/cards", method = RequestMethod.POST)
    private ResponseEntity<Object> createCard(@RequestParam CardColor cardColor,
                                             @RequestParam CardType cardType,
                                             Authentication authentication) {

        if(cardColor == null || cardType == null){
            return new ResponseEntity<>("Card color and type are mandatory",HttpStatus.UNAUTHORIZED);
        }


        Client client = clientService.findByEmail(authentication.getName());

        long countCardsByType = client.getCards().stream().filter( card -> card.getType().equals(cardType)).count();

        if (countCardsByType < 3){
            String number;
            Optional<Card> cardRetrieved;

            do{
                number =   random.nextInt(9999) + "-" +
                            random.nextInt(9999) + "-" +
                            random.nextInt(9999) + "-" +
                            random.nextInt(9999);

                cardRetrieved = Optional.ofNullable(cardService.findByNumber(number));
            }while(cardRetrieved.isPresent());

            Card card = new Card( number, random.nextInt(9999), LocalDateTime.now(), LocalDateTime.now().plusYears(5), cardType, cardColor );
            client.addCard(card);
            cardService.saveCard(card);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
