package com.open.assignment.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AggregatedData {

    @JsonProperty("account")
    private String mAccount;
    @JsonProperty("agreements")
    private List<AgreementData> mAgreementData;
    @JsonProperty("balance")
    private Long mBalance;
    @JsonProperty("created")
    private String mCreated;
    @JsonProperty("creditCards")
    private List<CreditCardData> mCreditCardData;
    @JsonProperty("debitCards")
    private List<DebitCardData> mDebitCardData;
    @JsonProperty("user")
    private String mUser;
}
