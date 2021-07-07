package com.open.assignment.service;

import com.open.assignment.domain.creditcard.CreditCard;

public interface CreditService {
    CreditCard getCreditCardDetails(String cardId);
}
