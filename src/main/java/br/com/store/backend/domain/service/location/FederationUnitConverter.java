package br.com.store.backend.domain.service.location;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpMethod;

import br.com.store.backend.domain.entity.FederationUnitEntity;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.partner.FederationUnit;
import br.com.store.backend.view.resource.partner.FederationUnitLinks;

public class FederationUnitConverter {

    private static final String URI_PATTERN = "api/federation-units/";

    private FederationUnitConverter() {
    }

    public static FederationUnit convert(FederationUnitEntity federationUnitEntity) {
        if (federationUnitEntity == null) {
        	return null;
        }
        
        FederationUnit federationUnit = new FederationUnit();
        BeanUtils.copyProperties(federationUnitEntity, federationUnit);
        createURI(federationUnit);
        createLinks(federationUnit);        

        return federationUnit;
    }
    
    public static FederationUnitEntity convert(FederationUnit federationUnit) {
        if (federationUnit == null) {
        	return null;
        }
        FederationUnitEntity federationUnitEntity = new FederationUnitEntity();
        BeanUtils.copyProperties(federationUnit, federationUnitEntity);
        
        return federationUnitEntity;
    }

    private static void createLinks(FederationUnit federationUnit) {

        List<Link> linkList = new ArrayList<Link>();
        for (FederationUnitLinks federationUnitLink : FederationUnitLinks.values()) {
            Link link = new Link(federationUnitLink.getDescription(), federationUnit.getUri() + "/" + federationUnitLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        federationUnit.setLinks(linkList);
    }

    private static void createURI(FederationUnit federationUnit) {
    	federationUnit.setUri(URI_PATTERN + federationUnit.getIdFederationUnit());
    }
    
}
