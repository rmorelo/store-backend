package br.com.store.backend.domain.service.location;

import br.com.store.backend.view.resource.location.Country;

public interface CountryService {
	
    Country findCountry(Integer idCountry);
    
}
