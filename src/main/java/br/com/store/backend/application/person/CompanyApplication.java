package br.com.store.backend.application.person;

import br.com.store.backend.view.resource.person.Company;

public interface CompanyApplication {
    
	Company findCompanyByPartner(Integer idPartner);
    
    Company saveCompanyOfPartner(Integer idPartner, Company company);
    
    Company update(Company company);

    void delete(Integer idCompany);
    
}
