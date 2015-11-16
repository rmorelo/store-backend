package br.com.store.backend.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "EMAIL")
public class EmailEntity {

    @Id    
    @Column(name = "ID_EMAIL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmail;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "CONFIRMATION")
    private String confirmation;

    public Integer getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return this.getIdEmail() == null ? super.hashCode() : this.getIdEmail().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idEmail", idEmail)
                .add("email", email)
                .add("confirmation", confirmation)
                .toString();
    }
    
}
