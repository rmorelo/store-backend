package br.com.store.backend.application.partner;

import java.util.ArrayList;
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
import br.com.store.backend.domain.service.customer.CustomerService;
import br.com.store.backend.domain.service.location.AddressService;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.domain.service.person.CompanyService;
import br.com.store.backend.domain.service.person.IndividualService;
import br.com.store.backend.infrastructure.exception.BadRequestException;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.customer.Customer;
import br.com.store.backend.view.resource.location.Address;
import br.com.store.backend.view.resource.partner.Partner;
import br.com.store.backend.view.resource.person.Company;
import br.com.store.backend.view.resource.person.Individual;

@Service
public class PartnerApplicationImpl implements PartnerApplication {

    @Autowired
    private PartnerService partnerService;
        
    @Autowired
    private IndividualService individualService;
    
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private CustomerService customerService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Partner findPartner(Integer idPartner, String[] selectors) {
    	Partner partner = partnerService.findPartner(idPartner);
    	addSelector(partner, selectors);
    	
    	return partner;
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Page<Partner> findPartnersByIdCustomer(Integer idCustomer, Pageable pageable) {
    	Page<Partner> partners = partnerService.findPartnersByCustomer(idCustomer, pageable);
        
        return partners;
    }

    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Partner save(Partner partner) {
        return partnerService.save(partner);
    }
    
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Partner update(Partner partner) {
        return partnerService.update(partner);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public void delete(Integer idPartner) {
        partnerService.delete(idPartner);
    }
	
	
	private void addSelector(Partner partner, String[] selectors) {
	    if (selectors != null){
	        List<String> selectorList = Arrays.asList(selectors);
	        
	        if(partner.getPartnerType().equals(PersonTypeEnum.PESSOA_JURIDICA.getType())){
	            if(selectorList.contains(Partner.COMPANIES)){
	                addCompany(partner);
	            }  
	        }if(partner.getPartnerType().equals(PersonTypeEnum.PESSOA_FISICA.getType())){
	            if(selectorList.contains(Partner.INDIVIDUALS)){
	                addIndividual(partner);
	            }
	        }else{
	            throw new BadRequestException(BadRequestException.INVALID_PERSON_TYPE);
	        }
	        
	        if(selectorList.contains(Partner.ADDRESSES)){
	            addAddress(partner);
	        }	        
	    }
	    
	}
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    @Transactional
    public Partner updateCustomerOfPartner(Integer idPartner, Integer idCustomer){
        Partner partner = partnerService.findPartner(idPartner);
        
        if(partner == null){
            throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
        }
        
        Customer customer = customerService.findCustomer(idCustomer);
        
        if(customer == null){
            throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
        }
        
        Collection<Partner> partners = new ArrayList<Partner>();
        partners.add(partner);
        customer.setPartners(partners);
        
        Collection<Customer> customers = new ArrayList<Customer>();
        customers.add(customer);
        partner.setCustomers(customers);
        
        customerService.update(customer);
        Partner partnerResult = partnerService.update(partner);
                
        return partnerResult;
    }
	
	private void addIndividual(Partner partner) {
	    Individual individual = individualService.findIndividualByPartner(partner.getIdPartner());
	    partner.setIndividual(individual);
    }
	
	private void addCompany(Partner partner) {
    	Company company = companyService.findCompanyByPartner(partner.getIdPartner());
		partner.setCompany(company);    	
    }
	
	private void addAddress(Partner partner) {
		Address address = addressService.findAddressByPartner(partner.getIdPartner());
		partner.setAddress(address);
    }
}
