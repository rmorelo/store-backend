package br.com.store.backend.application.partner;

import javax.transaction.Transactional;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Company;
import br.com.store.backend.view.resource.partner.Individual;
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
	@Transactional
	public Individual save(Individual individual) {
		return partnerService.save(individual);
	}
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
	@Transactional
	public Company save(Company company) {
		return partnerService.save(company);
	}

	@Override
    @Profiled(level = Profiling.APPLICATION)
	@Transactional
    public Partner update(Partner partner) {
        return partnerService.update(partner);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
	@Transactional
    public void delete(Integer idPartner) {
        partnerService.delete(idPartner);
    }
}
