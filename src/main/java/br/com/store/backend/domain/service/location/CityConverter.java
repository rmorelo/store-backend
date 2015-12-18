package br.com.store.backend.domain.service.location;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpMethod;

import br.com.store.backend.domain.entity.CityEntity;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.partner.City;
import br.com.store.backend.view.resource.partner.CityLinks;

public class CityConverter {

    private static final String URI_PATTERN = "api/cities/";

    private CityConverter() {
    }

    public static City convert(CityEntity cityEntity) {
        if (cityEntity == null) {
        	return null;
        }
        City city = new City();
        BeanUtils.copyProperties(cityEntity, city);
        createURI(city);
        createLinks(city);        

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

    private static void createLinks(City city) {

        List<Link> linkList = new ArrayList<Link>();
        for (CityLinks cityLink : CityLinks.values()) {
            Link link = new Link(cityLink.getDescription(), city.getUri() + cityLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        city.setLinks(linkList);
    }

    private static void createURI(City city) {
    	city.setUri(URI_PATTERN + city.getIdCity());
    }
    
}
