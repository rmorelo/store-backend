package br.com.store.backend.application.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.CityService;
import br.com.store.backend.domain.service.location.DistrictService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.City;
import br.com.store.backend.view.resource.location.FederationUnit;

@Service
public class CityApplicationImpl implements CityApplication {

	@Autowired
	private DistrictService districtService;
    
	@Autowired
	private CityService cityService;
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public City findCityByDistrict(Integer idDistrict, String selector){
        City city = districtService.findCityByDistrict(idDistrict);
        addFederationUnit(city, selector);
        return city;
    }
	
    @Override
    @Profiled(level = Profiling.APPLICATION)
	public City findCity(Integer idCity, String selector){
    	City city = cityService.findCity(idCity);
	    addFederationUnit(city, selector);
		return city;
	}
    
    private void addFederationUnit(City city, String selector) {
    	if (selector != null && selector.equals(City.FEDERATION_UNITS)){
    		FederationUnit federationUnit = cityService.findFederationUnitByCity(city.getIdCity());
    		city.setFederationUnit(federationUnit);
    	}
    }

}
