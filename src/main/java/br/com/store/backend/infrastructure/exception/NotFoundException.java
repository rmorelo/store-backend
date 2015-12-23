package br.com.store.backend.infrastructure.exception;

public class NotFoundException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;

    public static final int PARTNER_NOT_FOUND = 404001;
    
    public static final int EMAIL_NOT_FOUND = 404002;
    
    public static final int COMPANY_NOT_FOUND = 404003;
    
    public static final int POSTAL_AREA_NOT_FOUND = 404004;
    
    public static final int DISTRICT_NOT_FOUND = 404005;
    
    public static final int CITY_NOT_FOUND = 404006;
    
    public static final int FEDERATION_UNIT_NOT_FOUND = 404007;
    
    public static final int COUNTRY_NOT_FOUND = 404008;

    public NotFoundException(int code) {
        super(code);
    }

    public NotFoundException(String field, int code) {
        super(field, code);
    }

}
