package com.open.assignment.mapper;

import com.open.assignment.data.AgreementData;
import com.open.assignment.domain.agreements.Agreement;
import com.open.assignment.domain.agreements.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AgreementMapper {

    public List<AgreementData> map(User user) {
        List<AgreementData> agreementDataList = new ArrayList<>();
        if (user.getMAgreements() != null) {
            for (Agreement agreement : user.getMAgreements()) {
                AgreementData agreementData = new AgreementData();
                agreementData.setMAccount(agreement.getMAccount());
                agreementData.setMType(agreement.getMType());
                agreementDataList.add(agreementData);
            }
        }
        return agreementDataList;
    }
}
