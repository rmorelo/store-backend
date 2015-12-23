package br.com.store.backend.application.partner;

import java.util.Collection;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.DistrictService;
import br.com.store.backend.domain.service.location.PostalAreaService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.City;
import br.com.store.backend.view.resource.partner.District;

@Service
public class DistrictApplicationImpl implements DistrictApplication {

	@Autowired
	private DistrictService districtService;
	
	@Autowired
    private PostalAreaService postalAreaService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
	public Collection<District> findDistricts(Integer idPostalArea, String selector){
		Collection<District> districts = postalAreaService.findDistricts(idPostalArea);
	    addCity(districts, selector);
		return districts;
	}
    
    private void addCity(Collection<District> districts, String selector) {
    	if (selector != null && selector.equals(District.CITIES)){
    		for(District district : districts){
    			City city = districtService.findCity(district.getIdDistrict());
    			district.setCity(city);
    		}
    	}
    }

}
