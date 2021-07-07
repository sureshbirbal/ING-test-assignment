package com.open.assignment.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Setter
@Getter
public class AtmLimitData {
    @JsonProperty("limit")
    private Long mLimit;
    @JsonProperty("periodUnit")
    private String mPeriodUnit;

}
