package br.com.store.backend.application.partner;

import javax.transaction.Transactional;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.domain.service.telephone.TelephoneService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Partner;
import br.com.store.backend.view.resource.partner.Telephone;

@Service
public class TelephoneApplicationImpl implements TelephoneApplication {

	@Autowired
    private TelephoneService telephoneService;
    
    @Autowired
    private PartnerService partnerService;
   
    @Override
    @Profiled(level = Profiling.APPLICATION)
    @Transactional
	public Telephone save(Integer idPartner, Telephone telephone){
    	Telephone newTelephone = telephoneService.save(telephone);
    	Partner partner = partnerService.findByIdPartner(idPartner);
    	partner.setTelephone(newTelephone);
    	partnerService.update(partner);
		return newTelephone;
	}

}
