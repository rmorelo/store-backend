package br.com.store.backend.view.validation;

import org.springframework.stereotype.Component;

import br.com.store.backend.infrastructure.tracking.Tracker;
import br.com.store.validation.Field;
import br.com.store.validation.Validation;
import br.com.store.validation.Error;


@Component
public class ValidationAdapter {

    public Error check(Field field, String version) {
        return Validation.check(field, version);
    }
    
    public Error check(Field field) {
        return Validation.check(field, getVersion());
    }
    
    private String getVersion() {
        return Tracker.getString(Tracker.VALIDATION_VERSION);
    }
}
