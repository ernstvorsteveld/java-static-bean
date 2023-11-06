package com.sternitc.javastaticbean;

import org.springframework.stereotype.Service;

@Service
public class SimpleValidator implements Validator {
    @Override
    public void validate(String toValidate) {
        if (toValidate.equalsIgnoreCase("ERROR")) {
            throw new StringNotValidException("Equals to ERROR");
        }
    }

    public static class StringNotValidException extends RuntimeException {
        public StringNotValidException(String error) {
            super(error);
        }
    }
}
