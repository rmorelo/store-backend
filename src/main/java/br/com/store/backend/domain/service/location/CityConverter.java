package br.com.store.backend.domain.service.location;

import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.location.CityEntity;
import br.com.store.backend.view.resource.location.City;

public class CityConverter {

       private CityConverter() {
    }

    public static City convert(CityEntity cityEntity) {
        if (cityEntity == null) {
        	return null;
        }
        City city = new City();
        BeanUtils.copyProperties(cityEntity, city);
   
        return city;
    }
    
    public static CityEntity convert(City city) {
        if (city == null) {
        	return null;
        }
        CityEntity cityEntity = new CityEntity();
        BeanUtils.copyProperties(city, cityEntity);
        
        return cityEntity;
    }
    
}
