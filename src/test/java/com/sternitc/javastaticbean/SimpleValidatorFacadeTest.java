package com.sternitc.javastaticbean;

import com.sternitc.javastaticbean.domain.DomainTester;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SimpleValidatorFacadeTest {

    @Test
    public void should_validate_with_static_method() {
        SimpleValidatorFacade.validate("NO ERROR");
    }

    @Test
    public void should_validate_with_static_method_and_have_exception() {
        assertThrows(SimpleValidator.StringNotValidException.class,
                () -> SimpleValidatorFacade.validate("ERROR"));
    }

    @Test
    public void should_not_allow_value_on_domain_object() {
        DomainTester domainTester = new DomainTester();
        assertThrows(SimpleValidator.StringNotValidException.class,
                () -> domainTester.setValue("ERROR"));
    }

}