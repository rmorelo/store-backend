package br.com.store.backend.application.location;

import java.util.Collection;

import br.com.store.backend.view.resource.location.District;

public interface DistrictApplication {
 	
	Collection<District> findDistrictsByPostalArea(Integer idPostalArea, String selector);
	
	Collection<District> findDistrictsByPostalArea(String codPostalArea, String selector);
	
	District findDistrict(Integer idDistrict, String selector);
	
}
