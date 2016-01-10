package br.com.store.backend.application.customer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.person.PersonTypeEnum;
import br.com.store.backend.domain.service.contact.EmailService;
import br.com.store.backend.domain.service.contact.TelephoneService;
import br.com.store.backend.domain.service.customer.CustomerService;
import br.com.store.backend.domain.service.location.AddressService;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.domain.service.person.CompanyService;
import br.com.store.backend.domain.service.person.IndividualService;
import br.com.store.backend.domain.service.pet.AnimalService;
import br.com.store.backend.infrastructure.exception.BadRequestException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.contact.Email;
import br.com.store.backend.view.resource.contact.Telephone;
import br.com.store.backend.view.resource.customer.Customer;
import br.com.store.backend.view.resource.location.Address;
import br.com.store.backend.view.resource.person.Individual;
import br.com.store.backend.view.resource.pet.Animal;

@Service
@Transactional(readOnly = true)
public class CustomerApplicationImpl implements CustomerApplication {

    @Autowired
    private CustomerService customerService;
        
    @Autowired
    private IndividualService individualService;
    
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private PartnerService partnerService;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private TelephoneService telephoneService;
    
    @Autowired
    private AnimalService animalService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Customer findCustomer(Integer idCustomer, String[] selectors) {
    	Customer customer = customerService.findCustomer(idCustomer);
    	addSelector(customer, selectors);
    	
    	return customer;
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Page<Customer> findCustomersByIdPartner(Integer idPartner, Pageable pageable) {
    	Page<Customer> customers = customerService.findCustomersByPartner(idPartner, pageable);
        
        return customers;
    }
    
    private void addSelector(Customer customer, String[] selectors) {
        if (selectors != null){
            List<String> selectorList = Arrays.asList(selectors);
            
            if(customer.getCustomerType().equals(PersonTypeEnum.PESSOA_FISICA.getType())){
                if(selectorList.contains(Customer.INDIVIDUALS)){
                    addIndividual(customer);
                }
            }else{
                throw new BadRequestException(BadRequestException.INVALID_PERSON_TYPE);
            }
            
            if(selectorList.contains(Customer.ADDRESSES)){
                addAddress(customer);
            }
            
            if(selectorList.contains(Customer.EMAILS)){
                addEmail(customer);
            }
            
            if(selectorList.contains(Customer.TELEPHONES)){
                addTelephone(customer);
            }
            
            if(selectorList.contains(Customer.ANIMALS)){
                addAnimal(customer);
            }
        }        
    }

    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Customer save(Customer customer) {
        return customerService.save(customer);
    }
    
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Customer update(Customer customer) {
        return customerService.update(customer);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public void delete(Integer idCustomer) {
        customerService.delete(idCustomer);
    }
	
	private void addIndividual(Customer customer) {
		Individual individual = individualService.findIndividualByCustomer(customer.getIdCustomer());
		customer.setIndividual(individual);
    }
	
	private void addAddress(Customer customer) {
		Address address = addressService.findAddressByCustomer(customer.getIdCustomer());
		customer.setAddress(address);
    }
	
	private void addEmail(Customer customer) {
		Email email = emailService.findEmailByCustomer(customer.getIdCustomer());
		customer.setEmail(email);
	}
	
	private void addTelephone(Customer customer) {
		Telephone telephone = telephoneService.findTelephoneByCustomer(customer.getIdCustomer());
		customer.setTelephone(telephone);
	}
	
	private void addAnimal(Customer customer){
		Collection<Animal> animals = animalService.findAnimalsByCustomer(customer.getIdCustomer());
		customer.setAnimals(animals);
	}	
	
}
