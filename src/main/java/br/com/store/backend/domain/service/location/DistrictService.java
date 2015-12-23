package br.com.store.backend.domain.service.location;

import br.com.store.backend.view.resource.partner.City;

public interface DistrictService {
	
    City findCity(Integer idDistrict);
    
}
