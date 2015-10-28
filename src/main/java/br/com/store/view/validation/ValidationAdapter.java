package br.com.store.view.validation;

import org.springframework.stereotype.Component;

import br.com.store.infrastructure.tracking.Tracker;


@Component
public class ValidationAdapter {

    public br.com.store.validation.Error check(Field field, String version) {
        return Validation.check(field, version);
    }
    
    public br.com.store.validation.Error check(Field field) {
        return Validation.check(field, getVersion());
    }
    
    private String getVersion() {
        return Tracker.getString(Tracker.VALIDATION_VERSION);
    }
}
