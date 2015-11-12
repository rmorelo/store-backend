package br.com.store.backend.infrastructure.exception;

import java.util.List;

import br.com.store.backend.infrastructure.rest.model.ErrorMessage;

public class BadRequestException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;

    public static final String EXCEPTION_CODE = "badRequest";

    public static final Integer FIELD_LOGIN = 400001;
    public static final Integer RECOVERIES_TYPE_PATH = 400002;
    public static final Integer FIELD_MAIN_EMAIL = 400003;
    public static final Integer FIELD_ALTERNATIVE_EMAIL = 400004;

    public static final Integer PASSWORD_EXCEPTION = 400005;
    public static final Integer DIFFERENT_PASSWORD_EXCEPTION = 400007;
    public static final Integer SIZE_PASSWORD_EXCEPTION = 40008;

    public static final Integer INVALID_TOKEN = 400010;
    public static final Integer STILL_VALID_TOKEN = 400011;
    public static final Integer FIELD_TURING = 400012;

    public static final Integer IDPOS_MIN_SCORE_NOT_REACHED = 400013;
    public static final Integer CONFIRMATION_CONTACT_TYPE = 400014;

    public static final Integer SECURITY_QUESTION = 400015;

    public static final Integer USER_VALIDATOR = 400020;

    public static final Integer CPF_AND_NAME = 400021;
    public static final Integer CNPJ_AND_NAME = 400022;

    public static final Integer CNPJ_NULL = 400023;
    public static final Integer FOUNDATION_DATE_NULL = 400024;
    public static final Integer TRADING_NAME_NULL = 400025;
    public static final Integer STATE_TAX_NUMBER = 400026;

    public static final Integer CPF_NULL = 400027;
    public static final Integer BIRTHDATE_NULL = 400028;
    public static final Integer GENDER_NULL = 400029;
    public static final Integer STATE_TAX_UF = 400031;
    public static final Integer CORPORATE_NAME_NULL = 400032;
    public static final Integer NAME_NULL = 400033;

    public static final Integer MINIMUM_QUESTIONS_REQUIRED = 400034;
    public static final Integer BIN_INVALID = 400035;

    public static final Integer SELECTOR_NOT_FOUND = 400036;
    public static final Integer FIELD_CONTACTUS_EMAIL = 400035;
    public static final Integer FIELD_CONTACTUS_ALTERNATIVE_EMAIL = 400036;
    public static final Integer FIELD_CONTACTUS_MESAGEM = 400039;
    public static final Integer FIELD_CONTACTUS_NOME = 400040;
    public static final Integer FIELD_CONTACTUS_SKIN = 400041;

    public static final Integer TRADEMARK_NOT_SUPPORTED = 400042;

    public static final Integer QUITTANCE_NOT_FOUND = 400031;
    
    public static final Integer HEADERS_VALIDATION_NULL = 4002034;
    public static final Integer HEADERS_BROWSER_IP_NULL = 4002035;
    public static final Integer HEADERS_REQUEST_ID_NULL = 4002036;
    public static final Integer HEADERS_CONTENT_TYPE_NULL = 4002037;

    public BadRequestException(int code) {
        super(code);
    }

    public BadRequestException(List<ErrorMessage> errors) {
        super(errors);
    }

    public BadRequestException(String field, Integer code) {
        super(field, code);
    }

    public BadRequestException(String field, Integer code, String title, String message, String... args) {
        super(field, code, title, message, args);
    }

}
