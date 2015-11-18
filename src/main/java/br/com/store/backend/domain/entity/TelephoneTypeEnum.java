package br.com.store.backend.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum TelephoneTypeEnum {

    RESIDENTIAL("Residencial", "R"), BUSINESS("Comercial", "B"), MOBILE("Celular", "M");
    
    private String type;
    
    private String description;
    
    TelephoneTypeEnum(String description, String type){
    	this.type = type;
    	this.description = description;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
	
}
