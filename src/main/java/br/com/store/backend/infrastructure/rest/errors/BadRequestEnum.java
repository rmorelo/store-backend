package br.com.store.backend.infrastructure.rest.errors;

import br.com.store.validation.Error;

public enum BadRequestEnum implements ErrorEnum {

    DEFAULT(4002001L, "bad_request", ""),
    CVV_NULL(4002001L, "cvv_null", "cvv"),
    DATE_PARSE_EXCEPTION(4002002L, "date_parse_exception", "date"),
    QUESTION_TYPE_INVALID(4002003L, "question_type_invalid", "type"),
    TOKEN_TYPE_INVALID(4002004L, "token_type_invalid", "type"),
    SECURITY_QUESTION_TYPE_INVALID(4002005L, "type_invalid", "type"),
    SECURITY_QUESTION_USER_ALREADY_HAS_QUESTION(4002006L, "security_question_already_registred", ""),
    IDT_PERSON_NULL(4002007L, "idt_person_null", "idtPerson"),
    SECURITY_QUESTION_ANSWER_DOES_NOT_EXIST(4002007L, "secret_answer_does_not_exist", "desSecretAnswer"), //
    SECURITY_QUESTION_NULL(4002008L, "secret_question_null", "desSecretQuestion"), //.
    SECURITY_QUESTION_IDT_NULL(4002009L, "idt_secret_question_null", "idtSecretQuestion"), //.

    CREDIT_CARD_BLACKLISTED(4002010L, "credit_card_blacklisted", "number"),
    SECURITY_QUESTION_IDT_NOT_FOUND(4002011L, "secret_question_not_found", "idtSecretQuestion"), //.
    SECURITY_QUESTION_FIXED_DOES_NOT_EXIST(4002012L, "secret_question_fixed_does_not_exist", ""),
    SECURITY_QUESTION_FIXED_ALREADY_EXIST(4002013L, "secret_question_fixed_already_exist", ""), // "."
    SECURITY_QUESTION_MUST_BE_FIXED(4002014L, "secret_question_must_be_fixed", ""), //

    EXP_MONTH_NULL(4002015L, "expMonth_null", "expMonth"),
    EXP_YEAR_NULL(4002016L, "expYear_null", "expYear"),
    NUMBER_NULL(4002017L, "number_null", "number"),
    PAYMENT_METHOD_DOES_NOT_EXIST(4002018L, "payment_method_does_not_exist", "idPaymentMethod"),
    QUITTANCE_PAYMENT_METHOD_INVALID(4002019L, "quittance_payment_method_invalid", "idPaymentMethod"),
    QUITTANCE_VALUE_GREATER_THAN_DEBIT(4002020L, "quittance_value_greater_than_debit", "value"),
    QUITTANCE_VALUE_LOWER_THAN_MIN_DEBIT(4002021L, "quittance_value_lower_than_min_debit", "value"),
    QUITTANCE_INSTALLMENT_GREATER_THAN_ALLOWED(4002022L, "quittance_installment_greater_than_allowed", "installments"),
    QUITTANCE_INSTALLMENT_INVALID(4002023L, "installment_invalid", "installments"),
    QUITTANCE_INSTALLMENT_VALUE_LOWER_THAN_ALLOWED(4002024L, "installment_value_lower_than_allowed", "installments"),
    QUITTANCE_USER_ACCOUNT_INCONSISTENCY(4002025L, "quittance_user_account_inconsistency", "user"),
    QUITTANCE_ACCOUNT_HAS_NOT_DEBIT(4002026L, "quittance_account_has_not_debit", "account"),
    CREDITCARD_INVALID(4002027L, "creditcard_invalid", "number"),

    BRAND_NULL(4002028L, "brand_null", "brand"),
    SUBSCRIBER_PAYMENT_METHOD_NOT_FROM_USER(4002029L, "subscriber_payment_method_not_from_user", "user"),
    SUBSCRIBER_PAYMENT_METHOD_DOES_NOT_EXIST(4002030L, "subscriber_payment_method_does_not_exist", "idSubscriberPaymentMethod"),
    QUITTANCE_VALUE_NULL(4002031L, "quittance_value_null", "value"),
    QUITTANCE_INSTALLMENTS_NULL(4002032L, "quittance_installments_null", "installments"),

    PAYLOAD_INVALID(4002033L, "payload_invalid", "payload"),
    HEADERS_VALIDATION_NULL(4002034L, "headers_validation_version_null", "header"),
    HEADERS_BROWSER_IP_NULL(4002035L, "headers_browser_ip_null", "header"),
    HEADERS_REQUEST_ID_NULL(4002036L, "headers_request_id_null", "header"),
    HEADERS_CONTENT_TYPE_NULL(4002037L, "headers_content_type_null", "header"),

    QUITTANCE_CREDIT_CARD_FAKE_PURCHASE(4002038L, "quittance_credit_card_fake_purchase", "number"),

    DEBIT_ACCOUNT_INVALID(4002039L, "debit_account_invalid", "accountNumber"),
    PAYMENT_METHOD_BRAND_NOT_ACCEPTED(4002040L, "brand_not_accepted", "paymentMethod.id"),
    PAYMENT_METHOD_BANK_NOT_ACCEPTED(4002041L, "bank_not_accepted", "paymentMethod.id"),
    PAYMENT_METHOD_INVALID(4002042L, "user_payment_method_invalid", "paymentMethod.id"),

    NUMBER_NOT_NULL(4002043L, "number_not_null", "number"),
    CVV_NOT_NULL(4002044L, "cvv_not_null", "cvv"),
    EXPIRATION_MONTH_NOT_NULL(4002045L, "expMonth_not_null", "expMonth"),
    EXPIRATION_YEAR_NOT_NULL(4002046L, "expYear_not_null", "expYear"),
    PAYMENT_DAY_NOT_NULL(4002047L, "paymentDay_not_null", "paymentDay"),
    ACCOUNT_NUMBER_NOT_NULL(4002048L, "accountNumber_not_null", "accountNumber"),
    ACCOUNT_DIGIT_NOT_NULL(4002049L, "accountDigit_not_null", "accountDigit"),
    BRANCH_NUMBER_NOT_NULL(4002050L, "branchNumber_not_null", "branchNumber"),
    BRANCH_DIGIT_NOT_NULL(4002051L, "branchDigit_not_null", "branchDigit"),
    DOCUMENT_DESCRIPTION_NULL(4002052L, "document.description_null", "document.description"),
    DOCUMENT_TYPE_NULL(4002053L, "document.type_null", "document.type"),
    DOCUMENT_TYPE_INVALID(4002054L, "document.type_invalid", "document.type"),
    PAYMENT_DAY_INVALID(4002055L, "paymentDay_invalid", "paymentDay"),
    INVALID_SELECTOR(4002056L, "invalid_selector", "selector"),

    INVALID_ACCOUNT_ID_BOOKLET (4002058L, "invalid_account_id_booklet", "idtAccount"),
    INVALID_NOTIFICATION_TYPE (4002059L, "invalid_notification_type", "type"),
    INVALID_DUPLICATE_BOOKLET(4002060L, "invalid_duplicate_booklet", "duplicateBooklet"),

    PAYED_USING_USER_PAYMENT_METHOD_CONFLICTED(4002061L, "payed_using_user_payment_method_conflicted", "payed-using-user-payment-method"),
    PAYED_USING_USER_PAYMENT_METHOD_INVALID(4002062L, "payed_using_user_payment_method_invalid", "payed-using-user-payment-method"),
    ACCOUNT_PATCH_INVALID(4002063L, "account_patch_invalid", "account"),
    PAYED_USING_USER_PAYMENT_METHOD_NULL(4002064L, "payed_using_user_payment_method_null", "payed-using-user-payment-method"),

    PASSWORD(4002065L, "password", "password"),
    SECURITY_QUESTIONS_MINIMUM_REQUIRED(4002066L, "security_questions_minimum_required", ""),
    IDPOS_MIN_SCORE_NOT_REACHED(4002067L, "idpos_min_score_not_reached", ""),
    ALTERNATIVE_EMAIL_NULL(4002068L, "alternative_email_null", "alternative_email"),
    RECOVERIES_TYPE_PATH_UNKNOWN(4002069L, "recoveries_type_path_unknown", "type"),
    MAIN_EMAIL_NULL(4002070L, "main_email_null", "main_email"),
    CONTACTUS_EMAIL_NULL(4002071L, "contactus_email_null", "email"),
    CONTACTUS_ALTERNATIVE_EMAIL_NULL(4002072L, "contactus_alternativeEmail_null", "emailAlternativo"),
    CONTACTUS_NAME_NULL(4002073L, "contactus_name_null", "nome"),
    CONTACTUS_MESSAGE_NULL(4002074L, "contactus_message_null", "mensagem"),
    INVALID_INTERNAL_SELECTORS(4002075L, "invalid_internal_selector", ""),
    PASSWORD_INVALID(4002076L, "password_invalid", "password"),
    TOKEN_INVALID(4002077L, "token_invalid", "token");

    private final Long code;
    private final String error;
    private final String field;

    BadRequestEnum(Long code, String error, String field) {
        this.code = code;
        this.error = error;
        this.field = field;
    }

    @Override
    public Long getCode() {
        return code;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public String getField() {
        return field;
    }

    @Override
    public Error buildError() {
        return new Error(code, error, field, error);
    }



}
