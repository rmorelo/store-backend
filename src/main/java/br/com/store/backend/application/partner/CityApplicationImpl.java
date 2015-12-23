package br.com.store.backend.application.partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.CityService;
import br.com.store.backend.domain.service.location.DistrictService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.City;
import br.com.store.backend.view.resource.partner.FederationUnit;

@Service
public class CityApplicationImpl implements CityApplication {

	@Autowired
	private DistrictService districtService;
    
	@Autowired
	private CityService cityService;
	
    @Override
    @Profiled(level = Profiling.APPLICATION)
	public City findCity(Integer idDistrict, String selector){
    	City city = districtService.findCity(idDistrict);
	    addFederationUnit(city, selector);
		return city;
	}
    
    private void addFederationUnit(City city, String selector) {
    	if (selector != null && selector.equals(City.FEDERATION_UNITS)){
    		FederationUnit federationUnit = cityService.findFederationUnit(city.getIdCity());
    		city.setFederationUnit(federationUnit);
    	}
    }

}
