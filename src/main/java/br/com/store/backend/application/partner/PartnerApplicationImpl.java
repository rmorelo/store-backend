package br.com.store.backend.application.partner;

import java.util.Arrays;
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
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private TelephoneService telephoneService;
    
    @Autowired
    private AnimalService animalService;
    
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
	        
	        if(selectorList.contains(Partner.EMAILS)){
                addEmail(partner);
            }
            
            if(selectorList.contains(Partner.TELEPHONES)){
                addTelephone(partner);
            }
            
	    }
	    
	}
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    @Transactional
    public Partner updateCustomerOfPartner(Integer idPartner, Integer idCustomer){
        return partnerService.updateCustomerOfPartner(idPartner, idCustomer);
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
	
	private void addEmail(Partner partner) {
		Email email = emailService.findEmailByPartner(partner.getIdPartner());
		partner.setEmail(email);
	}
	
	private void addTelephone(Partner partner) {
		Telephone telephone = telephoneService.findTelephoneByPartner(partner.getIdPartner());
		partner.setTelephone(telephone);
	}
		
}
