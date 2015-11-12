package br.com.store.backend.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.google.common.base.Objects;

@Entity
@Table(name = "COMPANY")
public class CompanyEntity {
    
    @Id
    @GeneratedValue(generator = "partner-primarykey")
    @GenericGenerator(name = "partner-primarykey", strategy = "foreign",
            parameters = {
                    @Parameter(name = "property", value = "partnerEntity")
            })
    @Column(name = "ID_PARTNER", nullable = false)
    private Integer idPartner;
    
    @Column(name = "CNPJ")
    private String cnpj;
    
    @Column(name = "COMPANY_NAME")
    private String company_name;
    
    @Column(name = "STATE_REGISTRATION")
    private String state_registration;
    
    @Column(name = "COMMERCIAL_NAME")
    private String commercial_name;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private PartnerEntity partnerEntity;
    
    public Integer getIdPartner() {
        return idPartner;
    }
    
    public void setIdPartner(Integer idPartner) {
        this.idPartner = idPartner;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getState_registration() {
        return state_registration;
    }

    public void setState_registration(String state_registration) {
        this.state_registration = state_registration;
    }

    public String getCommercial_name() {
        return commercial_name;
    }

    public void setCommercial_name(String commercial_name) {
        this.commercial_name = commercial_name;
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
                .add("company_name", company_name)
                .add("state_registration", state_registration)
                .add("commercial_name", commercial_name)
                .toString();
    }
}