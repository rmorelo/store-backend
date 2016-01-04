package br.com.store.backend.domain.service.customer;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import br.com.store.backend.view.resource.customer.Customer;

public interface CustomerService {
  
    Customer findCustomer(Integer idCustomer);
    
    Collection<Customer> findCustomersByPartner(Integer idPartner, Pageable pageable);
    
    Customer save(Customer customer);
    
    Customer update(Customer customer);
    
    void delete(Integer idCustomer);
}
