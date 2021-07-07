package com.open.assignment.domain.creditcard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard {

    @JsonProperty("cardHolder")
    private String mCardHolder;
    @JsonProperty("cardNumber")
    private Long mCardNumber;
    @JsonProperty("id")
    private String mId;
    @JsonProperty("monthlyLimit")
    private Long mMonthlyLimit;
    @JsonProperty("status")
    private String mStatus;

}
