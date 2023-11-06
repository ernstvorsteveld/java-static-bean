package com.sternitc.javastaticbean.domain;

import com.sternitc.javastaticbean.SimpleValidatorFacade;

public class DomainTester {

    public void setValue(String value) {
        SimpleValidatorFacade.validate(value);
    }
}
