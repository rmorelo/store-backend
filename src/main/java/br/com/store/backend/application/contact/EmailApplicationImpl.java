package br.com.store.backend.application.contact;

import javax.transaction.Transactional;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.contact.EmailService;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.contact.Email;
import br.com.store.backend.view.resource.partner.Partner;

@Service
public class EmailApplicationImpl implements EmailApplication {

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private PartnerService partnerService;
   
    @Override
    @Profiled(level = Profiling.APPLICATION)
    @Transactional
	public Email save(Integer idPartner, Email email){
    	Email newEmail = emailService.save(email);
    	Partner partner = partnerService.findPartner(idPartner);
    	partner.setEmail(newEmail);
    	partnerService.update(partner);
		return newEmail;
	}

	
}
