package br.com.store.backend.view.resource.partner;

import java.io.Serializable;
import java.util.List;

import br.com.store.backend.infrastructure.rest.model.Link;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostalArea implements Serializable{

	private Integer id_postal_area;
	
	private Integer id_city;
    
    private String nam_postal_area;
    
    private String cod_postal_area;
    
    private String des_segment;
    
    private Integer id_parent_postal_area;
	    
	private String uri;
    
    private List<Link> links;
    
	public Integer getId_postal_area() {
        return id_postal_area;
    }

    public void setId_postal_area(Integer id_postal_area) {
        this.id_postal_area = id_postal_area;
    }

    public Integer getId_city() {
        return id_city;
    }

    public void setId_city(Integer id_city) {
        this.id_city = id_city;
    }

    public String getNam_postal_area() {
        return nam_postal_area;
    }

    public void setNam_postal_area(String nam_postal_area) {
        this.nam_postal_area = nam_postal_area;
    }

    public String getCod_postal_area() {
        return cod_postal_area;
    }

    public void setCod_postal_area(String cod_postal_area) {
        this.cod_postal_area = cod_postal_area;
    }

    public String getDes_segment() {
        return des_segment;
    }

    public void setDes_segment(String des_segment) {
        this.des_segment = des_segment;
    }

    public Integer getId_parent_postal_area() {
        return id_parent_postal_area;
    }

    public void setId_parent_postal_area(Integer id_parent_postal_area) {
        this.id_parent_postal_area = id_parent_postal_area;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
