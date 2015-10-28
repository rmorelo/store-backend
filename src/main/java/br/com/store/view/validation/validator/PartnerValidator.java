package br.com.store.view.validation.validator;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.store.view.resource.partner.Partner;
import br.com.store.view.validation.contraints.PartnerResource;

public class PartnerValidator implements ConstraintValidator<PartnerResource, Partner> {

    private static final Logger LOGGER = Logger.getLogger(PartnerValidator.class);

    @Autowired
    private Validator validator;

    @Override
    public void initialize(PartnerResource constraintAnnotation) {
    }

    @Override
    public boolean isValid(Partner value, ConstraintValidatorContext context) {

      
        return true;
    }

    
}
