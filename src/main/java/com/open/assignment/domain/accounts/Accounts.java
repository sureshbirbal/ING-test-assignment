package com.open.assignment.domain.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Accounts {

    @JsonProperty("account")
    private String mAccount;
    @JsonProperty("balance")
    private Long mBalance;
    @JsonProperty("created")
    private String mCreated;
    @JsonProperty("creditCards")
    private List<CreditCardId> mCreditCardIds;
    @JsonProperty("debitCards")
    private List<DebitCardId> mDebitCardIds;
    @JsonProperty("user")
    private String mUser;
}
