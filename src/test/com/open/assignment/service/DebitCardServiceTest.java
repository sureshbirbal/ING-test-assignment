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

import com.open.assignment.domain.debitcard.DebitCard;
import com.open.assignment.service.impl.DebitCardServiceImpl;
import com.open.assignment.service.impl.RestUtils;

@ExtendWith(MockitoExtension.class)
public class DebitCardServiceTest {

    @Mock
    RestUtils restUtils;
    @InjectMocks
    private DebitCardServiceImpl debitCardService;

    @Before
    public void setup() {
        restUtils = new RestUtils();
        debitCardService = new DebitCardServiceImpl();
    }

    @Test
    public void testDebitCardServiceHappyFlow() throws Exception {
        // given
        String cardId = "3333";
        //when
        when(restUtils.getData(any(), any(), any())).thenReturn(getDebitCard());

        final DebitCard response = debitCardService.getDebitCardDetails(cardId);
        //then
        assertThat(response).isNotNull();
        assertThat(response.getMCardHolder()).isEqualTo("User1");
        assertThat(response.getMCardNumber()).isEqualTo(new Long(3333));
        assertThat(response.getMContactless()).isEqualTo(true);
        assertThat(response.getMStatus()).isEqualTo("ACTIVE");
        assertThat(response.getMSequenceNumber()).isEqualTo(1);
    }

    private Object getDebitCard() {
        DebitCard debitCard = new DebitCard();
        debitCard.setMCardHolder("User1");
        debitCard.setMCardNumber(new Long(3333));
        debitCard.setMContactless(true);
        debitCard.setMSequenceNumber(new Long(1));
        debitCard.setMStatus("ACTIVE");
        return debitCard;
    }
}
