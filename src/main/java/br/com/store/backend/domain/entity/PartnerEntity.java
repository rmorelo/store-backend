package br.com.store.backend.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "partner")
public class PartnerEntity  {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTNER_SEQUENCE")
    @SequenceGenerator(name = "PARTNER_SEQUENCE", sequenceName = "SQ_PARTNER_IDT", allocationSize = 1)
    @Column(name = "ID_PARTNER")
    private Long idPartner;
    
	@Column(name = "DES_PARTNER")
    private String desPartner;

    public Long getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(Long idPartner) {
        this.idPartner = idPartner;
    }

    public String getDesPartner() {
        return desPartner;
    }

    public void setDesPartner(String desPartner) {
        this.desPartner = desPartner;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PartnerEntity{");
        sb.append("idPartner=").append(idPartner);
        sb.append(", desPartner='").append(desPartner);
        sb.append('}');
        return sb.toString();
    }


}
