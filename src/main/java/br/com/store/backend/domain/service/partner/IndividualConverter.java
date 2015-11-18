package br.com.store.backend.domain.service.partner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpMethod;

import br.com.store.backend.domain.entity.IndividualEntity;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.partner.Email;
import br.com.store.backend.view.resource.partner.Individual;
import br.com.store.backend.view.resource.partner.Partner;
import br.com.store.backend.view.resource.partner.PartnerLinks;
import br.com.store.backend.view.resource.partner.Telephone;

public class IndividualConverter {

    private static final String URI_PATTERN = "api/partners/individual";

    private IndividualConverter() {
    }

    public static Individual convert(IndividualEntity entity) {
        if (entity == null) {
        	return null;
        }
        
        Individual individual = new Individual();
        BeanUtils.copyProperties(entity, individual);
        addObjectFields(entity, individual);
        createURI(individual);
        createLinks(individual);
        
        return individual;
    }
    
    public static IndividualEntity convert(Individual individual) {
        if (individual == null) {
        	return null;
        }
        IndividualEntity entity = new IndividualEntity();
        BeanUtils.copyProperties(individual, entity);
        
        return entity;
    }

    private static void createLinks(Individual individual) {

        List<Link> linkList = new ArrayList<Link>();
        for (PartnerLinks userLink : PartnerLinks.values()) {
            Link link = new Link(userLink.getDescription(), individual.getUri() + userLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        individual.setLinks(linkList);
    }

    private static void createURI(Partner partner) {
        partner.setUri(URI_PATTERN);
    }

    private static void addObjectFields(IndividualEntity entity, Individual individual) {
        if(entity.getEmail() != null){
           	Email email = new Email();
           	BeanUtils.copyProperties(entity.getEmail(), email);
            individual.setEmail(email);
        }
        if(entity.getTelephone() != null){
        	Telephone telephone = new Telephone();
           	BeanUtils.copyProperties(entity.getEmail(), telephone);
            individual.setTelephone(telephone);
        }
    }
    
}
