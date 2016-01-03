package br.com.store.backend.domain.service.person;

import br.com.store.backend.view.resource.person.Company;

public interface CompanyService {
  
	Company findCompanyByPartner(Integer idPartner);
    
    Company saveCompanyOfPartner(Integer idPartner, Company company);
    
    Company update(Company company);
                
    void delete(Integer idCompany);
}
