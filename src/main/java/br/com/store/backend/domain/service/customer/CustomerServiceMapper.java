package br.com.store.backend.domain.service.customer;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.view.resource.customer.Customer;

@Component
public class CustomerServiceMapper extends AbstractServiceMapper {

	private ModelMapper modelMapper;
	
	public CustomerServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	public Customer mapCustomerEntityToCustomer(CustomerEntity customerEntity) {
		if(customerEntity == null) {
			return null;
		}

		Customer customer = map(customerEntity, Customer.class);
		return customer;
	}
	
	public void mapCustomerToCustomerEntity(Customer customer, CustomerEntity customerEntity) {
		if(customer == null) {
			return;
		}

		map(customer, customerEntity);
	}
	
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}
