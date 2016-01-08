package br.com.store.backend.domain.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.store.backend.view.resource.customer.Customer;

public interface CustomerService {
  
    Customer findCustomer(Integer idCustomer);
    
    Page<Customer> findCustomersByPartner(Integer idPartner, Pageable pageable);
    
    Customer save(Customer customer);
    
    Customer update(Customer customer);
    
    void delete(Integer idCustomer);
}
