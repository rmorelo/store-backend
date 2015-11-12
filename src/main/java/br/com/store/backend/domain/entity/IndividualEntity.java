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
@Table(name = "INDIVIDUAL")
public class IndividualEntity extends PartnerEntity {
    
    @Id
    @GeneratedValue(generator = "partner-primarykey")
    @GenericGenerator(name = "partner-primarykey", strategy = "foreign",
            parameters = {
                    @Parameter(name = "property", value = "partnerEntity")
            })
    @Column(name = "ID_PARTNER", nullable = false)
    private Integer idPartner;
    
    @Column(name = "CPF")
    private String cpf;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "LAST_NAME")
    private String last_name;
     
    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private PartnerEntity partnerEntity;
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
                .add("cpf", cpf)
                .add("name", name)
                .add("last_name", last_name)                
                .toString();
    }
}