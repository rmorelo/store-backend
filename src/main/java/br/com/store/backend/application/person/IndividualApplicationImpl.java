package br.com.store.backend.application.person;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.person.PersonTypeEnum;
import br.com.store.backend.domain.service.customer.CustomerService;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.domain.service.person.IndividualService;
import br.com.store.backend.infrastructure.exception.BadRequestException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.customer.Customer;
import br.com.store.backend.view.resource.partner.Partner;
import br.com.store.backend.view.resource.person.Individual;

@Service
@Transactional(readOnly = true)
public class IndividualApplicationImpl implements IndividualApplication {

    @Autowired
    private IndividualService individualService;
    
    @Autowired
    private PartnerService partnerService;
    
    @Autowired
    private CustomerService customerService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Individual findIndividualByPartner(Integer idPartner) {    	
    	 return individualService.findIndividualByPartner(idPartner);
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Individual findIndividual(Integer idIndividual) {    	
    	 return individualService.findIndividual(idIndividual);
    }

	@Override
    @Profiled(level = Profiling.APPLICATION)
	@Transactional
	public Individual saveIndividualOfPartner(Integer idPartner, Individual individual) {
	    Partner partner = partnerService.findPartner(idPartner);
	    
	    if(!partner.getPartnerType().equals(PersonTypeEnum.PESSOA_FISICA.getType())){
            throw new BadRequestException(BadRequestException.INVALID_PERSON_TYPE);
        }
	    
	    Individual individualResult = individualService.save(individual);
	    
	    partner.setIndividual(individualResult);
	    partnerService.update(partner);
	    
		return individualResult;
	}
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    @Transactional
    public Individual saveIndividualOfCustomer(Integer idCustomer, Individual individual) {
	    Customer customer = customerService.findCustomer(idCustomer);
        
        if(!customer.getCustomerType().equals(PersonTypeEnum.PESSOA_FISICA.getType())){
            throw new BadRequestException(BadRequestException.INVALID_PERSON_TYPE);
        }
        
        Individual individualResult = individualService.save(individual);
        
        customer.setIndividual(individualResult);
        customerService.update(customer);
        
        return individualResult;
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Individual update(Individual individual) {
        return individualService.update(individual);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public void delete(Integer idIndividual) {
		individualService.delete(idIndividual);
    }

}
