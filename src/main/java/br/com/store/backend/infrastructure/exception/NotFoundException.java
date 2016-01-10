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
    
    public static final int ADDRESS_NOT_FOUND = 404009;

    public static final int INDIVIDUAL_NOT_FOUND = 404010;
    
    public static final int CUSTOMER_NOT_FOUND = 404011;
    
    public static final int ANIMAL_NOT_FOUND = 404012;
    
    public static final int WEIGHT_NOT_FOUND = 404013;
    
    public static final int BREED_NOT_FOUND = 404014;
    
    public static final int SPECIES_NOT_FOUND = 404015;
    
    public static final int GROUP_NOT_FOUND = 404016;
    
    public static final int TELEPHONE_NOT_FOUND = 404017;
    
    public NotFoundException(int code) {
        super(code);
    }

    public NotFoundException(String field, int code) {
        super(field, code);
    }

}
