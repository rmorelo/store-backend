package br.com.store.backend.application.contact;

import javax.transaction.Transactional;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.contact.TelephoneService;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.contact.Telephone;
import br.com.store.backend.view.resource.partner.Partner;

@Service
public class TelephoneApplicationImpl implements TelephoneApplication {

	@Autowired
    private TelephoneService telephoneService;
    
    @Autowired
    private PartnerService partnerService;
   
    @Override
    @Profiled(level = Profiling.APPLICATION)
    @Transactional
	public Telephone saveTelephoneOfPartner(Integer idPartner, Telephone telephone){
    	Telephone newTelephone = telephoneService.save(telephone);
    	Partner partner = partnerService.findPartner(idPartner);
    	partner.setTelephone(newTelephone);
    	partnerService.update(partner);
		return newTelephone;
	}

}
