package br.com.store.backend.domain.service.location;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpMethod;
import br.com.store.backend.domain.entity.DistrictEntity;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.partner.District;
import br.com.store.backend.view.resource.partner.DistrictLinks;

public class DistrictConverter {

    private static final String URI_PATTERN = "api/districts/";

    private DistrictConverter() {
    }

    public static District convert(DistrictEntity districtEntity) {
        if (districtEntity == null) {
        	return null;
        }
        District district = new District();
        BeanUtils.copyProperties(districtEntity, district);
        createURI(district);
        createLinks(district);        

        return district;
    }
    
    public static DistrictEntity convert(District district) {
        if (district == null) {
        	return null;
        }
        DistrictEntity districtEntity = new DistrictEntity();
        BeanUtils.copyProperties(district, districtEntity);
        
        return districtEntity;
    }

    private static void createLinks(District district) {

        List<Link> linkList = new ArrayList<Link>();
        for (DistrictLinks districtLink : DistrictLinks.values()) {
            Link link = new Link(districtLink.getDescription(), district.getUri() + "/" + districtLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        district.setLinks(linkList);
    }
    
    private static void createURI(District district) {
    	district.setUri(URI_PATTERN + district.getIdDistrict());
    }
    
}
