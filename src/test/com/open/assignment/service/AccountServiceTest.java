package com.open.assignment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.open.assignment.data.AggregatedData;
import com.open.assignment.domain.accounts.Accounts;
import com.open.assignment.domain.accounts.CreditCardId;
import com.open.assignment.domain.accounts.DebitCardId;
import com.open.assignment.facade.ProductDetailsFacade;
import com.open.assignment.service.impl.AccountServiceImpl;
import com.open.assignment.service.impl.RestUtils;

import lombok.SneakyThrows;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountServiceImpl accountService;
    @Mock
    RestUtils restUtils;

    @Before
    public void setup() {
        restUtils = new RestUtils();
        accountService = new AccountServiceImpl();
    }

    @Test
    public void testAccountServiceHappyFlow() throws Exception {
        // given
        String accountId = "123456789";
        //when
        when(restUtils.getData(any(),any(),any())).thenReturn(getAccount());

        final Accounts response = accountService.getAccountDetails(accountId);
        //then
        assertThat(response).isNotNull();
        assertThat(response.getMAccount()).isEqualTo("IBAN1234567891");
        assertThat(response.getMBalance()).isEqualTo(new Long(200));
        assertThat(response.getMCreated()).isEqualTo("12-10-2018");
        assertThat(response.getMUser()).isEqualTo("User1");
        assertThat(response.getMCreditCardIds().size()).isEqualTo(2);
        assertThat(response.getMDebitCardIds().size()).isEqualTo(2);

    }

    private Object getAccount() {
        Accounts accounts = new Accounts();
        accounts.setMAccount("IBAN1234567891");
        accounts.setMBalance(new Long(200));
        accounts.setMCreated("12-10-2018");
        List<CreditCardId> creditCardIds = new ArrayList<>();
        CreditCardId creditCardId1 = new CreditCardId();
        creditCardId1.setMCardId("3333");
        CreditCardId creditCardId2 = new CreditCardId();
        creditCardId2.setMCardId("4444");
        creditCardIds.add(creditCardId1);
        creditCardIds.add(creditCardId2);
        accounts.setMCreditCardIds(creditCardIds);

        List<DebitCardId> debitCardIdList = new ArrayList<>();
        DebitCardId debitCardId1 = new DebitCardId();
        debitCardId1.setMCardId("1111");
        DebitCardId debitCardId2 = new DebitCardId();
        debitCardId2.setMCardId("2222");
        debitCardIdList.add(debitCardId1);
        debitCardIdList.add(debitCardId2);
        accounts.setMDebitCardIds(debitCardIdList);
        accounts.setMUser("User1");
        return accounts;
    }
}
