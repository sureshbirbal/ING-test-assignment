package com.open.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.open.assignment.domain.accounts.Accounts;
import com.open.assignment.service.AccountService;

import lombok.SneakyThrows;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    RestUtils restUtils;

    @SneakyThrows
    @Override
    public Accounts getAccountDetails(final String accountId) {
        return (Accounts) restUtils.getData("accounts", accountId, Accounts.class);
    }
}
