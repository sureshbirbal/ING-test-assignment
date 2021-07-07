package com.open.assignment.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Setter
@Getter
public class CreditCardData {

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
