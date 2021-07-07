package com.open.assignment.domain.agreements;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    @JsonProperty("agreements")
    private List<Agreement> mAgreements;
}
