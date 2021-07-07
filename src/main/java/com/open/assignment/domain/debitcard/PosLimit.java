package com.open.assignment.domain.debitcard;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PosLimit {

    @JsonProperty("limit")
    private Long mLimit;
    @JsonProperty("periodUnit")
    private String mPeriodUnit;
}
