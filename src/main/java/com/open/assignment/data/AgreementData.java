package com.open.assignment.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgreementData {

    @JsonProperty("account")
    private String mAccount;
    @JsonProperty("type")
    private String mType;


}
