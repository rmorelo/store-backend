package br.com.store.backend.application.person;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.store.backend.domain.service.person.CompanyService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.person.Company;

@Service
public class CompanyApplicationImpl implements CompanyApplication {

    @Autowired
    private CompanyService companyService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Company findCompanyByPartner(Integer idPartner) {    	
    	 return companyService.findCompanyByPartner(idPartner);
    }

	@Override
    @Profiled(level = Profiling.APPLICATION)
	public Company saveCompanyOfPartner(Integer idPartner, Company company) {
		return companyService.saveCompanyOfPartner(idPartner, company);
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
