package com.open.assignment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.open.assignment.domain.creditcard.CreditCard;
import com.open.assignment.service.impl.CreditServiceImpl;
import com.open.assignment.service.impl.RestUtils;

@ExtendWith(MockitoExtension.class)
public class CreditServiceTest {

    @Mock
    RestUtils restUtils;
    @InjectMocks
    private CreditServiceImpl creditService;

    @Before
    public void setup() {
        restUtils = new RestUtils();
        creditService = new CreditServiceImpl();
    }

    @Test
    public void testCreditCardDetailsHappyFlow() throws Exception {
        // given
        String cardId = "3333";
        //when
        when(restUtils.getData(any(), any(), any())).thenReturn(getCreditCard());

        final CreditCard response = creditService.getCreditCardDetails(cardId);
        //then
        assertThat(response).isNotNull();
        assertThat(response.getMCardHolder()).isEqualTo("User1");
        assertThat(response.getMCardNumber()).isEqualTo(new Long(3333));
        assertThat(response.getMMonthlyLimit()).isEqualTo(new Long(3000));
        assertThat(response.getMStatus()).isEqualTo("ACTIVE");
    }

    private Object getCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setMCardHolder("User1");
        creditCard.setMCardNumber(new Long(3333));
        creditCard.setMMonthlyLimit(new Long(3000));
        creditCard.setMStatus("ACTIVE");
        return creditCard;
    }
}






