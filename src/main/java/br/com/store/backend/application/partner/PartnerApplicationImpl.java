package br.com.store.backend.application.partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.store.backend.domain.service.location.AddressService;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.domain.service.person.CompanyService;
import br.com.store.backend.domain.service.person.IndividualService;
import br.com.store.backend.infrastructure.profiling.Profiling;
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
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Partner findPartner(Integer idPartner, String selector) {
    	Partner partner = partnerService.findPartner(idPartner);
    	addIndividual(partner, selector);
    	addCompany(partner, selector);
    	addAddress(partner, selector);
    	return partner;
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
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
	public Partner updateAddress(Integer idPartner, Integer idAddress){
		Address address = addressService.findAddress(idAddress);
		Partner partner = partnerService.findPartner(idPartner);
		partner.setAddress(address);
		return partnerService.update(partner);
	}
	
	private void addIndividual(Partner partner, String selector) {
    	if (selector != null && selector.equals(Partner.INDIVIDUALS)){
    		Individual individual = individualService.findIndividualByPartner(partner.getIdPartner());
    		partner.setIndividual(individual);
    	}
    }
	
	private void addCompany(Partner partner, String selector) {
    	if (selector != null && selector.equals(Partner.COMPANIES)){
    		Company company = companyService.findCompanyByPartner(partner.getIdPartner());
    		partner.setCompany(company);
    	}
    }
	
	private void addAddress(Partner partner, String selector) {
    	if (selector != null && selector.equals(Partner.COMPANIES)){
    		Address address = addressService.findAddressByPartner(partner.getIdPartner());
    		partner.setAddress(address);
    	}
    }
}
