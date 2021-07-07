package com.open.assignment.mapper;

import com.open.assignment.data.CreditCardData;
import com.open.assignment.domain.creditcard.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {

    public CreditCardData map(CreditCard creditCard) {
        CreditCardData data = new CreditCardData();
        data.setMCardHolder(creditCard.getMCardHolder());
        data.setMCardNumber(creditCard.getMCardNumber());
        data.setMId(creditCard.getMId());
        data.setMStatus(creditCard.getMStatus());
        data.setMMonthlyLimit(creditCard.getMMonthlyLimit());
        return data;
    }
}
