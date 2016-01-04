package br.com.store.backend.domain.service.location;

import java.util.Collection;

import br.com.store.backend.view.resource.location.City;
import br.com.store.backend.view.resource.location.District;

public interface DistrictService {
	
    City findCityByDistrict(Integer idDistrict);
    
    District findDistrict(Integer idDistrict);
    
    Collection<District> findDistrictsByPostalArea(Integer idPostalArea);
    
    Collection<District> findDistrictsByPostalArea(String codPostalArea);
    
}
