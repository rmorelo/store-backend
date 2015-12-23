package br.com.store.backend.domain.service.location;

import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.location.CountryEntity;
import br.com.store.backend.view.resource.location.Country;

public class CountryConverter {

    private static final String URI_PATTERN = "api/countries/";

    private CountryConverter() {
    }

    public static Country convert(CountryEntity countryEntity) {
        if (countryEntity == null) {
        	return null;
        }
        
        Country country = new Country();
        BeanUtils.copyProperties(countryEntity, country);
        createURI(country);
        
        return country;
    }
    
    public static CountryEntity convert(Country country) {
        if (country == null) {
        	return null;
        }
        CountryEntity countryEntity = new CountryEntity();
        BeanUtils.copyProperties(country, countryEntity);
        
        return countryEntity;
    }

    private static void createURI(Country country) {
        country.setUri(URI_PATTERN + country.getIdCountry());
    }
    
}