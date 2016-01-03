package br.com.store.backend.domain.service.partner;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.view.resource.partner.Partner;

@Component
public class PartnerServiceMapper extends AbstractServiceMapper {

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

		Partner partner = map(partnerEntity, Partner.class);
		return partner;
	}
	
	public void mapPartnerToPartnerEntity(Partner partner, PartnerEntity partnerEntity) {
		if(partner == null) {
			return;
		}

		map(partner, partnerEntity);
	}
	
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}
