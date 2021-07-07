package com.open.assignment.mapper;

import com.open.assignment.data.DebitCardData;
import com.open.assignment.domain.debitcard.DebitCard;
import org.springframework.stereotype.Component;

@Component
public class DebitCardMapper {

    private final AtmLimitMapper atmLimitMapper = new AtmLimitMapper();
    private final PosLimitMapper posLimitMapper = new PosLimitMapper();

    public DebitCardData map(DebitCard debitCard) {
        DebitCardData data = new DebitCardData();
        data.setMAtmLimitData(atmLimitMapper.map(debitCard.getMAtmLimit()));
        data.setMPosLimitData(posLimitMapper.map(debitCard.getMPosLimit()));
        data.setMCardHolder(debitCard.getMCardHolder());
        data.setMCardNumber(debitCard.getMCardNumber());
        data.setMContactless(debitCard.getMContactless());
        data.setMId(debitCard.getMId());
        data.setMSequenceNumber(debitCard.getMSequenceNumber());
        data.setMStatus(debitCard.getMStatus());
        return data;
    }
}
