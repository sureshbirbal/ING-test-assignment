package com.open.assignment.mapper;

import com.open.assignment.data.AggregatedData;
import com.open.assignment.domain.accounts.Accounts;
import org.springframework.stereotype.Component;

@Component
public class AggregatedMapper {

    public void map(AggregatedData data, Accounts accounts) {
        data.setMBalance(accounts.getMBalance());
        data.setMAccount(accounts.getMAccount());
        data.setMCreated(accounts.getMCreated());
        data.setMUser(accounts.getMUser());
    }
}
