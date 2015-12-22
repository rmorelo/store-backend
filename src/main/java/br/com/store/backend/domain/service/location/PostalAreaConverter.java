package br.com.store.backend.domain.service.location;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpMethod;
import br.com.store.backend.domain.entity.PostalAreaEntity;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.partner.PostalArea;
import br.com.store.backend.view.resource.partner.PostalAreaLinks;

public class PostalAreaConverter {
	
    private static final String URI_PATTERN = "api/postalareas";
   
    private static final String MATRIX_PARAM_URI = ";codPostalArea=";

    
    private PostalAreaConverter() {
    }

    public static PostalArea convert(PostalAreaEntity postalAreaEntity) {
        if (postalAreaEntity == null) {
        	return null;
        }
        PostalArea postalArea = new PostalArea();
        BeanUtils.copyProperties(postalAreaEntity, postalArea);
        createURI(postalArea);
        createLinks(postalArea);
        
        return postalArea;
    }
    
    public static PostalAreaEntity convert(PostalArea postalArea) {
        if (postalArea == null) {
        	return null;
        }
        PostalAreaEntity postalAreaEntity = new PostalAreaEntity();
        BeanUtils.copyProperties(postalArea, postalAreaEntity);
        
        return postalAreaEntity;
    }
    
    private static void createLinks(PostalArea postalArea) {

        List<Link> linkList = new ArrayList<Link>();
        for (PostalAreaLinks postalAreaLink : PostalAreaLinks.values()) {
            Link link = new Link(postalAreaLink.getDescription(), URI_PATTERN + "/" + postalArea.getIdPostalArea() + "/" + postalAreaLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        postalArea.setLinks(linkList);
    }
    
    private static void createURI(PostalArea postalArea) {
    	postalArea.setUri(URI_PATTERN + MATRIX_PARAM_URI + postalArea.getCodPostalArea());
    }
    
}
