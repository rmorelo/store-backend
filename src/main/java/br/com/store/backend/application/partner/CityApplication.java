package br.com.store.backend.application.partner;

import br.com.store.backend.view.resource.partner.City;

public interface CityApplication {
 	
	City findCity(Integer idDistrict, String selector);
	
}
