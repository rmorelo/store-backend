package br.com.store.backend.domain.entity.person;

public enum PersonTypeEnum {

    PESSOA_FISICA("PF"), PESSOA_JURIDICA("PJ");
    
    private String type;
    
    PersonTypeEnum(String type){
    	this.type = type;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}
