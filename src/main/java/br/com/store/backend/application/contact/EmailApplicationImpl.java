package br.com.store.backend.application.contact;

import org.springframework.transaction.annotation.Transactional;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.contact.EmailService;
import br.com.store.backend.domain.service.customer.CustomerService;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.contact.Email;
import br.com.store.backend.view.resource.customer.Customer;
import br.com.store.backend.view.resource.partner.Partner;

@Service
@Transactional(readOnly = true)
public class EmailApplicationImpl implements EmailApplication {

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private PartnerService partnerService;
    
    @Autowired
    private CustomerService customerService;
   
    @Override
    @Profiled(level = Profiling.APPLICATION)
    @Transactional
	public Email saveEmailOfPartner(Integer idPartner, Email email){
    	Email newEmail = emailService.save(email);
    	Partner partner = partnerService.findPartner(idPartner);
    	partner.setEmail(newEmail);
    	partnerService.update(partner);
		return newEmail;
	}
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    @Transactional
	public Email saveEmailOfCustomer(Integer idCustomer, Email email){
    	Email newEmail = emailService.save(email);
    	Customer customer = customerService.findCustomer(idCustomer);
    	customer.setEmail(newEmail);
    	customerService.update(customer);
		return newEmail;
	}
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Email findEmailByCustomer(Integer idCustomer){
    	return emailService.findEmailByCustomer(idCustomer);
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Email findEmailByPartner(Integer idPartner){
    	return emailService.findEmailByPartner(idPartner);
    }
	
}
