package br.com.store.backend.application.person;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.person.PersonTypeEnum;
import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.domain.service.person.CompanyService;
import br.com.store.backend.infrastructure.exception.BadRequestException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Partner;
import br.com.store.backend.view.resource.person.Company;

@Service
@Transactional(readOnly = true)
public class CompanyApplicationImpl implements CompanyApplication {

    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private PartnerService partnerService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Company findCompanyByPartner(Integer idPartner) {    	
    	 return companyService.findCompanyByPartner(idPartner);
    }
    
	public Company findCompany(Integer idCompany){
   	 return companyService.findCompany(idCompany);
	}


	@Override
    @Profiled(level = Profiling.APPLICATION)
	@Transactional
	public Company saveCompanyOfPartner(Integer idPartner, Company company) {	    
	    Partner partner = partnerService.findPartner(idPartner);
	    
	    if(!partner.getPartnerType().equals(PersonTypeEnum.PESSOA_JURIDICA.getType())){
            throw new BadRequestException(BadRequestException.INVALID_PERSON_TYPE);
        }
	    
	    Company companyResult = companyService.save(company);
	    
        partner.setCompany(companyResult);
        partnerService.update(partner);
	    
		return companyResult;
	}
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Company update(Company company) {
        return companyService.update(company);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public void delete(Integer idCompany) {
		companyService.delete(idCompany);
    }
}
