package com.open.assignment.mapper;

import com.open.assignment.data.AtmLimitData;
import com.open.assignment.domain.debitcard.AtmLimit;
import org.springframework.stereotype.Component;

@Component
public class AtmLimitMapper {

    public AtmLimitData map(AtmLimit atmLimit) {
        AtmLimitData atmLimitData = new AtmLimitData();
        atmLimitData.setMLimit(atmLimit.getMLimit());
        atmLimitData.setMPeriodUnit(atmLimit.getMPeriodUnit());
        return atmLimitData;
    }
}
