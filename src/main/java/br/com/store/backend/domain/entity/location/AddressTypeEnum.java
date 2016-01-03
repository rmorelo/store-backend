package br.com.store.backend.domain.entity.location;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum AddressTypeEnum {

    RESIDENTIAL("Residencial", "R"), BUSINESS("Comercial", "B");
    
    private String type;
    
    private String description;
    
    AddressTypeEnum(String description, String type){
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
