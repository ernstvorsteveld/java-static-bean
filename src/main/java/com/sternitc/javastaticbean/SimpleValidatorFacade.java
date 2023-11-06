package com.sternitc.javastaticbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SimpleValidatorFacade {

    private static ApplicationContext context;

    @Autowired
    public SimpleValidatorFacade(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static void validate(String value) {
        context.getBean(Validator.class).validate(value);
    }
}
