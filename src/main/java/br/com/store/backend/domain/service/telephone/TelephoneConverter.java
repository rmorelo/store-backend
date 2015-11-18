package br.com.store.backend.domain.service.telephone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpMethod;

import br.com.store.backend.domain.entity.TelephoneEntity;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.partner.PartnerLinks;
import br.com.store.backend.view.resource.partner.Telephone;

public class TelephoneConverter {

    private static final String URI_PATTERN = "api/telephones/";

    private TelephoneConverter() {
    }

    public static Telephone convert(TelephoneEntity telephoneEntity) {
        if (telephoneEntity == null) {
        	return null;
        }
        Telephone telephone = new Telephone();
        BeanUtils.copyProperties(telephoneEntity, telephone);
        createURI(telephone);
        createLinks(telephone);        

        return telephone;
    }
    
    public static TelephoneEntity convert(Telephone telephone) {
        if (telephone == null) {
        	return null;
        }
        TelephoneEntity telephoneEntity = new TelephoneEntity();
        BeanUtils.copyProperties(telephone, telephoneEntity);
        
        return telephoneEntity;
    }

    private static void createLinks(Telephone telephone) {

        List<Link> linkList = new ArrayList<Link>();
        for (PartnerLinks userLink : PartnerLinks.values()) {
            Link link = new Link(userLink.getDescription(), telephone.getUri() + userLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        telephone.setLinks(linkList);
    }

    private static void createURI(Telephone telephone) {
    	telephone.setUri(URI_PATTERN);
    }
    
}
