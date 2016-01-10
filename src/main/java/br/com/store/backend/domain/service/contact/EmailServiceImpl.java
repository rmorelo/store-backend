package br.com.store.backend.domain.service.contact;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.ConfirmationStatusEnum;
import br.com.store.backend.domain.entity.contact.EmailEntity;
import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.repository.contact.EmailRepository;
import br.com.store.backend.domain.repository.customer.CustomerRepository;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.contact.Email;

@Service
@Transactional(readOnly = true)
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private PartnerRepository partnerRepository;
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Email save(Email email){
    	email.setConfirmation(ConfirmationStatusEnum.PENDING.getStatus());
        EmailEntity emailEntity = EmailConverter.convert(email);
        emailEntity = emailRepository.save(emailEntity);
        return EmailConverter.convert(emailEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Email findEmailByCustomer(Integer idCustomer){
    	CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
    	
    	if(customerEntity == null){
    		throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
    	}
    	
    	EmailEntity emailEntity = customerEntity.getEmail();
    	
    	if(emailEntity == null){
    		throw new NotFoundException(NotFoundException.EMAIL_NOT_FOUND);
    	}
    	
        return EmailConverter.convert(emailEntity);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Email findEmailByPartner(Integer idPartner){
    	PartnerEntity partnerEntity = partnerRepository.findOne(idPartner);
    	
    	if(partnerEntity == null){
    		throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
    	}
    	
    	EmailEntity emailEntity = partnerEntity.getEmail();
    	
    	if(emailEntity == null){
    		throw new NotFoundException(NotFoundException.EMAIL_NOT_FOUND);
    	}
    	
        return EmailConverter.convert(emailEntity);
    }

}
