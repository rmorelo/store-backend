package br.com.store.backend.view.validation.contraints;

public class ValidationConstants {

    private ValidationConstants() {

    }

    public static final String VALIDATION_VERSION = "v0.0.13";

    public static final String EMAIL_CHECK = "STORE.fields.email.check";
    public static final String CELLPHONE_CHECK = "STORE.fields.cellphone.check";
    public static final String PASSWD_PASSWD_CONFIRMATION_CHECK = "STORE.fields.password.checkPasswordAndPasswordConfirmationWithoutLogin";
    public static final String ALTERNATIVE_EMAIL_CHECK = "STORE.fields.email.checkAlternativeEmail";

    public static final String CREDIT_CARD_VALIDATOR_EXECUTE = "STORE.creditCard.validator.execute";
    public static final String INDIVIDUAL_FULL_NAME_CHECK = "STORE.fields.individualFullName.check";
    public static final String COMPANY_CORPORATE_CHECK = "STORE.fields.companyCorporateName.check";
    public static final String COMPANY_TRADING_CHECK = "STORE.fields.companyTradingName.check";
    public static final String CPF_CHECK = "STORE.fields.cpf.check";
    public static final String CNPJ_CHECK = "STORE.fields.cnpj.check";
    public static final String GENDER_CHECK = "STORE.fields.gender.check";
    public static final String BIRTH_DATE_CHECK = "STORE.fields.birthDate.check";
    public static final String FOUNDATION_DATE_CHECK = "STORE.fields.foundationDate.check";
    public static final String STATE_TAX_CHECK = "STORE.fields.stateTax.check";

    public static final Integer DEFAULT_MAX_AGE = 120;

}
