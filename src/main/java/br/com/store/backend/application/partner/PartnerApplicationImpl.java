package br.com.store.backend.application.partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Partner;

@Service
public class PartnerApplicationImpl implements PartnerApplication {

    @Autowired
    private PartnerService partnerService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Partner findByIdPartner(Integer idPartner) {
    	return partnerService.findByIdPartner(idPartner);  
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
        return partnerService.delete(idPartner);
    }
}
