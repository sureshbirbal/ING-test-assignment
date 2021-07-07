package com.open.assignment.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.open.assignment.data.AggregatedData;
import com.open.assignment.facade.ProductDetailsFacade;

/**
 * Unit test for {@link ProductDetailsController}.
 */
@ExtendWith(MockitoExtension.class)
public class ProductDetailsControllerTest {

    @InjectMocks
    private ProductDetailsController resource;
    @Mock
    private ProductDetailsFacade productDetailsFacade;

    @Test
    public void testProductDetailsControllerHappyFlow() {
        // given
        String user = "user1";
        //when
        when(productDetailsFacade.getProductDetails(any())).thenReturn(new AggregatedData());

        final ResponseEntity<AggregatedData> responseEntity = resource.getAgreementOverview(user);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
