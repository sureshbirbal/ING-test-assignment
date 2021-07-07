package com.open.assignment.domain.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardId {

    @JsonProperty("cardId")
    private String mCardId;
}
