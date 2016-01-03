package br.com.store.backend.view.resource.person;

import java.io.Serializable;
import java.util.Date;

import br.com.store.backend.infrastructure.serializer.JsonDateSerializer;
import br.com.store.backend.view.resource.partner.Partner;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonSerialize(using = JsonDateSerializer.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Individual extends Partner implements Serializable {

	private static final long serialVersionUID = 1903053427687642328L;
	
	private Integer idIndividual;

	private String cpf;
    
    private String name;
    
    private String lastName;
    
    private String nickName;

    private Character sex;

    private Date birthDate;

	private Date signupDate;

	private Partner partner;
    
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

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	
}