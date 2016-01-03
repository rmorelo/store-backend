package br.com.store.backend.domain.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.store.backend.domain.entity.partner.PartnerEntity;

import com.google.common.base.Objects;

@Entity
@Table(name = "INDIVIDUAL")
public class IndividualEntity {
    
	@Id
    @Column(name = "ID_INDIVIDUAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIndividual;
	
    @Column(name = "CPF")
    private String cpf;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column(name = "NICK_NAME")
    private String nickName;
    
    @Column(name = "SEX")
    private Character sex;
    
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    
    @Column(name = "SIGNUP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	private Date signupDate;
    
    @OneToOne(mappedBy = "individual", fetch = FetchType.LAZY)
    private PartnerEntity partner;
    
    public Integer getIdIndividual() {
		return idIndividual;
	}

	public void setIdIndividual(Integer idIndividual) {
		this.idIndividual = idIndividual;
	}

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public PartnerEntity getPartner() {
		return partner;
	}

	public void setPartner(PartnerEntity partner) {
		this.partner = partner;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdIndividual() == null ? super.hashCode() : this.getIdIndividual().hashCode();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idIndividual", idIndividual)
                .add("cpf", cpf)
                .add("name", name)
                .add("last_name", lastName)
                .add("nickName", nickName)
                .add("sex", sex)
                .add("birthDate", birthDate)
                .add("partner", partner)
                .add("signupDate", signupDate)
                .toString();
    }
}