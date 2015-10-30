package br.com.store.backend.infrastructure.configuration;

import java.util.Locale;

import org.apache.commons.lang3.CharEncoding;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Classe especialista para message source
 */
public class StoreMessageSource extends ReloadableResourceBundleMessageSource {

    public StoreMessageSource() {
        setDefaultEncoding(CharEncoding.UTF_8);
    }

    public String getMessage(String key) {
        return super.getMessage(key, null, Locale.getDefault());
    }

    public String getMessage(String key, String[] args) {
        return super.getMessage(key, args, Locale.getDefault());
    }

}
