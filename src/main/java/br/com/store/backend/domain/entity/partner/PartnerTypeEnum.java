package br.com.store.backend.domain.entity.partner;

public enum PartnerTypeEnum {

    PESSOA_FISICA("PF"), PESSOA_JURIDICA("PJ");
    
    private String type;
    
    PartnerTypeEnum(String type){
    	this.type = type;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}
