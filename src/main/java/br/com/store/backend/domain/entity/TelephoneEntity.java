package br.com.store.backend.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "TELEPHONE")
public class TelephoneEntity {

    @Id    
    @Column(name = "ID_TELEPHONE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelephone;
    
    @Column(name = "TYPE")
    private String type;
    
    @Column(name = "NUMBER")
    private String number;
    
    @Column(name = "DDD")
    private String ddd;
    
    @Column(name = "DDI")
    private String ddi;

    @Column(name = "CONFIRMATION")
    private String confirmation;
    
    public Integer getIdTelephone() {
		return idTelephone;
	}

	public void setIdTelephone(Integer idTelephone) {
		this.idTelephone = idTelephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdTelephone() == null ? super.hashCode() : this.getIdTelephone().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idTelephone", idTelephone)
                .add("type", type)
                .add("number", number)
                .add("ddd", ddd)
                .add("ddi", ddi)
                .add("confirmation", confirmation)
                .toString();
    }
    
}
