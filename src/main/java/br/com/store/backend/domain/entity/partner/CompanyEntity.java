package br.com.store.backend.domain.entity.partner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "COMPANY")
@PrimaryKeyJoinColumn(name = "ID_PARTNER")
public class CompanyEntity extends PartnerEntity{
    
    @Column(name = "CNPJ")
    private String cnpj;
    
    @Column(name = "COMPANY_NAME")
    private String companyName;
    
    @Column(name = "STATE_REGISTRATION")
    private String stateRegistration;
    
    @Column(name = "COMMERCIAL_NAME")
    private String commercialName;
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdPartner() == null ? super.hashCode() : this.getIdPartner().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idPartner", idPartner)
                .add("cnpj", cnpj)
                .add("company_name", companyName)
                .add("state_registration", stateRegistration)
                .add("commercial_name", commercialName)
                .toString();
    }
}