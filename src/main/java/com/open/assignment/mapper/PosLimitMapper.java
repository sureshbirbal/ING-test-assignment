package com.open.assignment.mapper;

import com.open.assignment.data.PosLimitData;
import com.open.assignment.domain.debitcard.PosLimit;
import org.springframework.stereotype.Component;

@Component
public class PosLimitMapper {

    public PosLimitData map(PosLimit posLimit) {
        PosLimitData data = new PosLimitData();
        data.setMLimit(posLimit.getMLimit());
        data.setMPeriodUnit(posLimit.getMPeriodUnit());
        return data;
    }
}
