package com.open.assignment.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.assignment.domain.accounts.Accounts;
import com.open.assignment.domain.agreements.User;
import com.open.assignment.service.AgreementsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgreementsServiceImpl implements AgreementsService {

    @Autowired
    RestUtils restUtils;

    @SneakyThrows
    @Override
    public User getAccountsData(final String user) {
        return (User) restUtils.getData("agreements", user, User.class);
    }
}
