package br.com.store.backend.application.partner;

import br.com.store.backend.view.resource.partner.District;

public interface DistrictApplication {
 
	District findCityByIdDistrict(Integer idDistrict);
	
}
