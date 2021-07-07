package com.open.assignment.domain.agreements;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Agreement {

    @JsonProperty("account")
    private String mAccount;
    @JsonProperty("type")
    private String mType;
}
