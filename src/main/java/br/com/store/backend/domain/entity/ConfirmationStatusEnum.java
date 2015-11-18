package br.com.store.backend.domain.entity;

public enum ConfirmationStatusEnum {

    CONFIRMED("C"), PENDING("P");
    
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
