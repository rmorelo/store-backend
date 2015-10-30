package br.com.store.backend.view.validation.contraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.store.backend.view.validation.validator.PartnerValidator;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PartnerValidator.class)
@Documented
public @interface PartnerResource {
    String message() default "{br.com.store.resource.partner.resource}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
