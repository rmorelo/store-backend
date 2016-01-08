package br.com.store.backend.view.resource.pet;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weight implements Serializable{

	private static final long serialVersionUID = -5471227374939865228L;

	private Integer idWeight;
    
    private String weightRange;
    
    private String uri;
    
    public Integer getIdWeight() {
        return idWeight;
    }

    public void setIdWeight(Integer idWeight) {
        this.idWeight = idWeight;
    }

    public String getWeightRange() {
        return weightRange;
    }

    public void setWeightRange(String weightRange) {
        this.weightRange = weightRange;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri, String queryParam) {
        this.uri = uri + (queryParam != null ? "?" + queryParam : "");
    }
    
}
