package br.com.store.backend.application.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.store.backend.view.resource.customer.Customer;

public interface CustomerApplication {
    
    Customer findCustomer(Integer idCustomer, String[] selectors);
    
    Page<Customer> findCustomersByIdPartner(Integer idPartner, Pageable pageable);
    
    Customer save(Customer customer);
    
    Customer update(Customer customer);
    
    void delete(Integer idCustomer);
    
}
