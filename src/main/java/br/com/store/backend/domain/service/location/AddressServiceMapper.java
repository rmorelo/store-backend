package br.com.store.backend.domain.service.location;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.location.AddressEntity;
import br.com.store.backend.view.resource.location.Address;

@Component
public class AddressServiceMapper extends AbstractServiceMapper {

	private ModelMapper modelMapper;
	
	public AddressServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	public Address mapAddressEntityToAddress(AddressEntity addressEntity) {
		if(addressEntity == null) {
			return null;
		}

		Address address = map(addressEntity, Address.class);
		return address;
	}
	
	public void mapAddressToAddressEntity(Address address, AddressEntity addressEntity) {
		if(address == null) {
			return;
		}

		map(address, addressEntity);
	}
	
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}
