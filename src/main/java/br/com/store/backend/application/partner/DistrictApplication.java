package br.com.store.backend.application.partner;

import java.util.Collection;

import br.com.store.backend.view.resource.partner.District;

public interface DistrictApplication {
 	
	Collection<District> findDistricts(Integer idPostalArea, String selector);
	
}
