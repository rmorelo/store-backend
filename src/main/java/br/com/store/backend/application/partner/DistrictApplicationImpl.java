package br.com.store.backend.application.partner;

import java.util.Collection;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.CityService;
import br.com.store.backend.domain.service.location.DistrictService;
import br.com.store.backend.domain.service.location.PostalAreaService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.City;
import br.com.store.backend.view.resource.partner.District;
import br.com.store.backend.view.resource.partner.PostalArea;

@Service
public class DistrictApplicationImpl implements DistrictApplication {

	@Autowired
	private CityService cityService;
    
	@Autowired
	private DistrictService districtService;
	
	@Autowired
    private PostalAreaService postalAreaService;
	
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public District findCityByIdDistrict(Integer idDistrict){
    	District district = districtService.find(idDistrict);
    	return district;
	}
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
	public Collection<District> findDistricts(Integer idPostalArea, String selector){
		Collection<District> districts = postalAreaService.findDistricts(idPostalArea);
		return districts;
	}
    
    private void addCity(District district, String selector) {
    	if (selector != null && selector.equals(District.CITIES)){
    		//Collection<District> districts = postalAreaService.findDistricts(postalArea.getIdPostalArea());
	    	//postalArea.setDistricts(districts);
    	}
    	
    	if(district != null){
    		City city = cityService.find(district.getCity().getIdCity());
    		district.setCity(city);
    	}
    }

}
