package com.open.assignment.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.assignment.domain.accounts.Accounts;
import com.open.assignment.domain.agreements.User;
import com.open.assignment.domain.creditcard.CreditCard;
import com.open.assignment.service.CreditService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    RestUtils restUtils;

    @SneakyThrows
    @Override
    public CreditCard getCreditCardDetails(final String cardId) {
        return (CreditCard) restUtils.getData("credit-cards", cardId, CreditCard.class);
    }
}
