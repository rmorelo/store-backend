package br.com.store.backend.application.contact;

import org.springframework.transaction.annotation.Transactional;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.store.backend.domain.service.contact.TelephoneService;
import br.com.store.backend.domain.service.customer.CustomerService;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.contact.Telephone;
import br.com.store.backend.view.resource.customer.Customer;
import br.com.store.backend.view.resource.partner.Partner;

@Service
@Transactional(readOnly = true)
public class TelephoneApplicationImpl implements TelephoneApplication {

	@Autowired
    private TelephoneService telephoneService;
    
    @Autowired
    private PartnerService partnerService;
   
    @Autowired
    private CustomerService customerService;
    
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
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    @Transactional
	public Telephone saveTelephoneOfCustomer(Integer idCustomer, Telephone telephone){
    	Telephone newTelephone = telephoneService.save(telephone);
    	Customer customer = customerService.findCustomer(idCustomer);
    	customer.setTelephone(newTelephone);
    	customerService.update(customer);
		return newTelephone;
	}
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Telephone findTelephoneByCustomer(Integer idCustomer){
    	return telephoneService.findTelephoneByCustomer(idCustomer);
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Telephone findTelephoneByPartner(Integer idPartner){
    	return telephoneService.findTelephoneByCustomer(idPartner);
    }

}
