package com.sternitc.javastaticbean;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Import(SimpleValidatorFacadeMockedTest.TestConfig.class)
class SimpleValidatorFacadeMockedTest {

    @Test
    public void should_use_mocked_validator() {
        SimpleValidatorFacade.validate("ERROR");
    }

    @Test
    public void should_validate_with_static_method_and_have_exception() {
        assertThrows(RuntimeException.class,
                () -> SimpleValidatorFacade.validate("WRONG"));
    }

    @TestConfiguration
    static class TestConfig {

        @Bean
        @Primary
        public Validator simpleValidator() {
            return new Validator() {
                @Override
                public void validate(String toValidate) {
                    if(toValidate.equalsIgnoreCase("WRONG")) {
                        throw new RuntimeException();
                    }
                }
            };
        }
    }
}