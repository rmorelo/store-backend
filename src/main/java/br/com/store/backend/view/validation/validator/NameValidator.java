package br.com.store.backend.view.validation.validator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.store.validation.Field;
import br.com.store.backend.view.validation.CustomContextBuilder;
import br.com.store.backend.view.validation.ValidationAdapter;
import br.com.store.backend.view.validation.contraints.Name;
import br.com.store.backend.view.validation.contraints.ValidationConstants;
import br.com.store.validation.Error;

public class NameValidator implements ConstraintValidator<Name, String> {

    @Inject
    private ValidationAdapter validationAdapter;

    @Override
    public void initialize(Name constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        if (name != null) {
        	br.com.store.validation.Error error = validate(name);

            if (error != null) {
                buildContext(context, error);
                return false;
            }
        }
        return true;
    }

    private Error validate(String fullName) {
        return validationAdapter.check(new Field(ValidationConstants.INDIVIDUAL_FULL_NAME_CHECK, fullName));
    }

    private void buildContext(ConstraintValidatorContext context, br.com.store.validation.Error error) {
        CustomContextBuilder.build(context, error);
    }
}
