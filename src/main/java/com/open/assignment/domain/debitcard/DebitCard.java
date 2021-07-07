package com.open.assignment.domain.debitcard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebitCard {

    @JsonProperty("atmLimit")
    private AtmLimit mAtmLimit;
    @JsonProperty("cardHolder")
    private String mCardHolder;
    @JsonProperty("cardNumber")
    private Long mCardNumber;
    @JsonProperty("contactless")
    private Boolean mContactless;
    @JsonProperty("id")
    private String mId;
    @JsonProperty("posLimit")
    private PosLimit mPosLimit;
    @JsonProperty("sequenceNumber")
    private Long mSequenceNumber;
    @JsonProperty("status")
    private String mStatus;
}
