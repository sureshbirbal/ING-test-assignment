package com.open.assignment.service;

import com.open.assignment.domain.accounts.Accounts;

public interface AccountService {
    Accounts getAccountDetails(String accountId);
}
