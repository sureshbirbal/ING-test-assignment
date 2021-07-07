package com.open.assignment.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebitCardData {

    @JsonProperty("atmLimit")
    private AtmLimitData mAtmLimitData;
    @JsonProperty("cardHolder")
    private String mCardHolder;
    @JsonProperty("cardNumber")
    private Long mCardNumber;
    @JsonProperty("contactless")
    private Boolean mContactless;
    @JsonProperty("id")
    private String mId;
    @JsonProperty("posLimit")
    private PosLimitData mPosLimitData;
    @JsonProperty("sequenceNumber")
    private Long mSequenceNumber;
    @JsonProperty("status")
    private String mStatus;
}
