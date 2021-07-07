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

import com.open.assignment.domain.agreements.Agreement;
import com.open.assignment.domain.agreements.User;
import com.open.assignment.service.impl.AgreementsServiceImpl;
import com.open.assignment.service.impl.RestUtils;

@ExtendWith(MockitoExtension.class)
public class AgreementsServiceTest {

    @Mock
    RestUtils restUtils;
    @InjectMocks
    private AgreementsServiceImpl agreementsService;

    @Before
    public void setup() {
        restUtils = new RestUtils();
        agreementsService = new AgreementsServiceImpl();
    }

    @Test
    public void testAgreementsServiceHappyFlow() throws Exception {
        // given
        String user = "123456789";
        //when
        when(restUtils.getData(any(), any(), any())).thenReturn(getUser());

        final User response = agreementsService.getAccountsData(user);
        //then
        assertThat(response).isNotNull();
        assertThat(response.getMAgreements().size()).isEqualTo(2);
        assertThat(response.getMAgreements().get(0).getMAccount()).isEqualTo("1234567890");
        assertThat(response.getMAgreements().get(0).getMType()).isEqualTo("IBAN");
        assertThat(response.getMAgreements().get(1).getMAccount()).isEqualTo("1234567891");
        assertThat(response.getMAgreements().get(1).getMType()).isEqualTo("IBAN");
    }

    private Object getUser() {
        User user = new User();
        List<Agreement> list = new ArrayList<>();
        Agreement agreement1 = new Agreement();
        agreement1.setMAccount("1234567890");
        agreement1.setMType("IBAN");
        Agreement agreement2 = new Agreement();
        agreement2.setMAccount("1234567891");
        agreement2.setMType("IBAN");
        list.add(agreement1);
        list.add(agreement2);
        user.setMAgreements(list);
        return user;
    }
}


