package br.com.store.backend.domain.service.customer;

import org.springframework.beans.BeanUtils;

import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.view.resource.customer.Customer;

public class CustomerConverter {

    private CustomerConverter() {
    }

    public static Customer convert(CustomerEntity entity) {
        if (entity == null) {
        	return null;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(entity, customer, "partners");

        return customer;
    }
    
    public static CustomerEntity convert(Customer customer) {
        if (customer == null) {
        	return null;
        }
        CustomerEntity entity = new CustomerEntity();
        BeanUtils.copyProperties(customer, entity);
        
        return entity;
    }
    
}
