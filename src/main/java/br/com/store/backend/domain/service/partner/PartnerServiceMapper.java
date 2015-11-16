package br.com.store.backend.domain.service.partner;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.PartnerEntity;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.partner.Partner;
import br.com.store.backend.view.resource.partner.PartnerLinks;

@Component
public class PartnerServiceMapper extends AbstractServiceMapper {

    private static final String URI_PATTERN = "api/partners/";
	
	private ModelMapper modelMapper;
	
	public PartnerServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

	}

	public Partner mapPartnerEntityToPartner(PartnerEntity partnerEntity) {
		if(partnerEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Partner partner = map(partnerEntity, Partner.class);
		createURI(partner);
        createLinks(partner);
		return partner;
	}
	
	public void mapPartnerToPartnerEntity(Partner partner, PartnerEntity partnerEntity) {
		if(partner == null) {
			return;
		}

		//--- Generic mapping 
		map(partner, partnerEntity);

	}
	
    private static void createLinks(Partner partner) {

        List<Link> linkList = new ArrayList<Link>();
        for (PartnerLinks userLink : PartnerLinks.values()) {
            Link link = new Link(userLink.getDescription(), partner.getUri() + userLink.getDescription(), HttpMethod.GET.name());
            linkList.add(link);
        }

        partner.setLinks(linkList);
    }

    private static void createURI(Partner partner) {
        partner.setUri(URI_PATTERN);
    }
    

	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}