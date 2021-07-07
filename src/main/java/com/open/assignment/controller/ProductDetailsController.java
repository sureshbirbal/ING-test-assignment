package com.open.assignment.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.open.assignment.data.AggregatedData;
import com.open.assignment.facade.ProductDetailsFacade;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDetailsController {

    @Autowired
    ProductDetailsFacade productDetailsFacade;

    @GetMapping("/agreement-overview/{user}")
    public ResponseEntity<AggregatedData> getAgreementOverview(@PathVariable(value = "user") @Valid  String user) {
        if(!NumberUtils.isDigits(user)){
          return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(productDetailsFacade.getProductDetails(user));
    }
}
