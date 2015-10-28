package br.com.store.view.validation.validator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.store.view.validation.CustomContextBuilder;
import br.com.store.view.validation.ValidationAdapter;
import br.com.store.view.validation.contraints.Name;

public class NameValidator implements ConstraintValidator<Name, String> {

    @Inject
    private ValidationAdapter validationAdapter;

    @Override
    public void initialize(Name constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        if (name != null) {
            Error error = validate(name);

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

    private void buildContext(ConstraintValidatorContext context, Error error) {
        CustomContextBuilder.build(context, error);
    }
}
