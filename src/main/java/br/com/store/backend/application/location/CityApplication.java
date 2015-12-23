package br.com.store.backend.application.location;

import br.com.store.backend.view.resource.location.City;

public interface CityApplication {
 	
    City findCityByDistrict(Integer idDistrict, String selector);
         
	City findCity(Integer idCity, String selector);
	
}
