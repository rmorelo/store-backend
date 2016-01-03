package br.com.store.backend.application.location;

import java.util.Collection;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.DistrictService;
import br.com.store.backend.domain.service.location.PostalAreaService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.City;
import br.com.store.backend.view.resource.location.District;

@Service
public class DistrictApplicationImpl implements DistrictApplication {

	@Autowired
	private DistrictService districtService;
	
	@Autowired
    private PostalAreaService postalAreaService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
	public Collection<District> findDistrictsByPostalArea(Integer idPostalArea, String selector){
		Collection<District> districts = postalAreaService.findDistrictsByPostalArea(idPostalArea);
	    addCity(districts, selector);
		return districts;
	}
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
	public Collection<District> findDistrictsByPostalArea(String codPostalArea, String selector){
		Collection<District> districts = postalAreaService.findDistrictsByPostalArea(codPostalArea);
	    addCity(districts, selector);
		return districts;
	}
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public District findDistrict(Integer idDistrict, String selector){
        District district = districtService.findDistrict(idDistrict);
        addCity(district, selector);
        return district;
    }
    
    private void addCity(Collection<District> districts, String selector) {
    	if (selector != null && selector.equals(District.CITIES)){
    		for(District district : districts){
    			City city = districtService.findCityByDistrict(district.getIdDistrict());
    			district.setCity(city);
    		}
    	}
    }
    
    private void addCity(District district, String selector) {
        if (selector != null && selector.equals(District.CITIES)){
            City city = districtService.findCityByDistrict(district.getIdDistrict());
            district.setCity(city);
        }
    }

}
