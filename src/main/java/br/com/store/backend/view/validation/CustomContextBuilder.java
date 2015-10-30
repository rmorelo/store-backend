package br.com.store.backend.view.validation;

import javax.validation.ConstraintValidatorContext;

import org.apache.log4j.Logger;

import br.com.store.backend.infrastructure.exception.InternalServerErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class CustomContextBuilder {

    private static final Logger LOGGER = Logger.getLogger(CustomContextBuilder.class);

    private CustomContextBuilder() {
    }

    public static void build(ConstraintValidatorContext context, br.com.store.validation.Error error) {

        try {
            ObjectWriter writer = new ObjectMapper().writer();
            String json = writer.writeValueAsString(error);
            build(context, json);
        } catch (JsonProcessingException e) {
            LOGGER.error("Falha ao converter to JSON. errorMessage=" + error, e);
            throw new InternalServerErrorException(e);
        }
    }

    public static void build(ConstraintValidatorContext context, String json) {

        context
                .buildConstraintViolationWithTemplate(json)
                .addPropertyNode("")
                .addConstraintViolation();
        context.disableDefaultConstraintViolation();

    }

}
