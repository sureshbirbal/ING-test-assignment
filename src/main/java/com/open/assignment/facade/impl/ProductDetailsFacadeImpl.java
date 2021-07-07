package com.open.assignment.facade.impl;

import com.open.assignment.data.AggregatedData;
import com.open.assignment.data.CreditCardData;
import com.open.assignment.data.DebitCardData;
import com.open.assignment.domain.accounts.Accounts;
import com.open.assignment.domain.accounts.CreditCardId;
import com.open.assignment.domain.accounts.DebitCardId;
import com.open.assignment.domain.agreements.Agreement;
import com.open.assignment.domain.agreements.User;
import com.open.assignment.domain.creditcard.CreditCard;
import com.open.assignment.domain.debitcard.DebitCard;
import com.open.assignment.exception.UserNotFoundException;
import com.open.assignment.facade.ProductDetailsFacade;
import com.open.assignment.mapper.AggregatedMapper;
import com.open.assignment.mapper.AgreementMapper;
import com.open.assignment.mapper.CreditCardMapper;
import com.open.assignment.mapper.DebitCardMapper;
import com.open.assignment.service.AccountService;
import com.open.assignment.service.AgreementsService;
import com.open.assignment.service.CreditService;
import com.open.assignment.service.DebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDetailsFacadeImpl implements ProductDetailsFacade {

    @Autowired
    AgreementsService agreementsService;
    @Autowired
    AccountService accountService;
    @Autowired
    DebitCardService debitCardService;
    @Autowired
    CreditService creditService;
    @Autowired
    DebitCardMapper debitCardMapper;
    @Autowired
    CreditCardMapper creditCardMapper;
    @Autowired
    AgreementMapper agreementMapper;
    @Autowired
    AggregatedMapper aggregatedMapper;

    @Override
    public AggregatedData getProductDetails(final String user) {
        AggregatedData aggregatedData = new AggregatedData();
        User userData = agreementsService.getAccountsData(user);
        List<DebitCardData> listOfDebitCard = new ArrayList<>();
        List<CreditCardData> listOfCreditCard = new ArrayList<>();
        if (userData != null) {
            userData.getMAgreements().parallelStream().forEach(agreement -> {
                Accounts accounts = accountService.getAccountDetails(agreement.getMAccount());
                accounts.getMDebitCardIds().parallelStream().forEach(debitCardId -> {
                    DebitCard debitCard = debitCardService.getDebitCardDetails(debitCardId.getMCardId());
                    listOfDebitCard.add(debitCardMapper.map(debitCard));
                });
                aggregatedData.setMDebitCardData(listOfDebitCard.stream().filter(dc -> dc.getMStatus().equals("ACTIVE")).collect(Collectors.toList()));
                accounts.getMCreditCardIds().parallelStream().forEach(creditCardId -> {
                    CreditCard creditCard = creditService.getCreditCardDetails(creditCardId.getMCardId());
                    listOfCreditCard.add(creditCardMapper.map(creditCard));
                });
                aggregatedData.setMCreditCardData(listOfCreditCard.stream().filter(cc -> cc.getMStatus().equals("ACTIVE")).collect(Collectors.toList()));
                User users = agreementsService.getAccountsData(user);
                aggregatedData.setMAgreementData(agreementMapper.map(users));
                aggregatedMapper.map(aggregatedData, accounts);
            });
        }else{
            throw new UserNotFoundException("User not found!" + user);
        }
        return aggregatedData;
    }
}
