package br.com.store.backend.domain.service.customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.repository.customer.CustomerRepository;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.customer.Customer;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private PartnerRepository partnerRepository;
    
    @Resource
	private CustomerServiceMapper customerServiceMapper;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Customer findCustomer(Integer idCustomer) {
        CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
    	
    	if(customerEntity == null){
    		throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
    	}
    	
    	return CustomerConverter.convert(customerEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Collection<Customer> findCustomersByPartner(Integer idPartner, Pageable pageable) {
        PartnerEntity partnerEntity = partnerRepository.findOne(idPartner);
        
        if(partnerEntity == null){
            throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
        }
        
        Collection<Customer> customers = new ArrayList<Customer>();
        Collection<CustomerEntity> customerEntities = customerRepository.findAllByPartner(partnerEntity, pageable);
        
        for (CustomerEntity customerEntity : customerEntities){
            Customer customer = CustomerConverter.convert(customerEntity);
            customers.add(customer);
        }
        
        return customers;
    }
    
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Customer save(Customer customer) {
        customer.setSignupDate(new Date());
    	CustomerEntity customerEntity = CustomerConverter.convert(customer);
    	customerEntity = customerRepository.save(customerEntity);
    	return CustomerConverter.convert(customerEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Customer update(Customer customer) {
        customer.setSignupDate(new Date());
    	
    	CustomerEntity customerEntity = customerRepository.findOne(customer.getIdCustomer());
    	
    	if(customerEntity == null){
    		throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
    	}
    	
    	customerServiceMapper.mapCustomerToCustomerEntity(customer, customerEntity);
    	CustomerEntity customerEntitySaved = customerRepository.save(customerEntity);
        return CustomerConverter.convert(customerEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public void delete(Integer idCustomer) {
    	CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
    	
    	if(customerEntity == null){
    		throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
    	}
    	
        customerRepository.delete(customerEntity.getIdCustomer());        
    }
    
}