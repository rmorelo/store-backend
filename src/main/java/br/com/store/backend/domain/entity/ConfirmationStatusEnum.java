package br.com.store.backend.domain.entity;

public enum ConfirmationStatusEnum {

    ACTIVE("A"), INACTIVE("I");
    
    private String status;
    
    ConfirmationStatusEnum(String status){
    	this.status = status;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
