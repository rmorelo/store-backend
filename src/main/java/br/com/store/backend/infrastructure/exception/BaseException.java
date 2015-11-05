package br.com.store.backend.infrastructure.exception;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import br.com.store.backend.infrastructure.rest.model.ErrorMessage;


public abstract class BaseException extends RuntimeException {

   private static final long serialVersionUID = 5257577835500050725L;
   public static final int HASH_CODE = 31;
   private Object entity;
   private Long reasonCode;
   private String id;
   private String details;
   private String field;
   private String[] params;
   private final List<ErrorMessage> errors = new LinkedList<ErrorMessage>();

   public BaseException(br.com.store.validation.Error error) {
       super(error.getMessage());
       field = error.getField();
       reasonCode = error.getCode();
   }

   public BaseException(br.com.store.validation.Error error, Object... params) {
       super(error.getMessage());
       field = error.getField();
       reasonCode = error.getCode();
       this.params = new String[params.length];
       for (int i = 0; i < params.length; i++) {
           this.params[i] = String.valueOf(params[i]);
       }
   }

   public BaseException(br.com.store.validation.Error error, Exception e) {
       super(error.getMessage(), e);
       field = error.getField();
       reasonCode = error.getCode();
   }

   public BaseException(final String message, final Throwable e) {
       super(message, e);
   }
   
   public BaseException(List<ErrorMessage> errors) {
       this.errors.addAll(errors);
   }

   public Object getEntity() {
       return entity;
   }

   public BaseException setEntity(Object entityArg) {
       entity = entityArg;
       return this;
   }

   public Long getReasonCode() {
       return reasonCode;
   }

   public BaseException setReasonCode(Long reasonCodeArg) {
       reasonCode = reasonCodeArg;
       return this;
   }

   @Override
   public boolean equals(Object obj) {
       if (obj instanceof BaseException) {
           final BaseException ex = (BaseException) obj;
           if (this.getCause() != null) {
               return this.getCause().equals(ex.getCause());
           } else {
               return reasonCode.equals(ex.getReasonCode()) && this.getClass().equals(ex.getClass());
           }
       } else {
           return false;
       }
   }

   public String getId() {
       return id;
   }

   public void setId(String idArg) {
       id = idArg;
   }

   public BaseException withId(final String idArg) {
       id = idArg;
       return this;
   }

   public BaseException withDetails(final String detailsArg) {
       details = detailsArg;
       return this;
   }

   public String getDetails() {
       return details;
   }

   public void setDetails(String detailsArg) {
       details = detailsArg;
   }

   public String getField() {
       return field;
   }

   public void setField(String field) {
       this.field = field;
   }

   public String[] getParams() {
       return params;
   }
   
   public List<ErrorMessage> getErrors() {
       return errors;
   }

   @Override
   public int hashCode() {
       int result = entity != null ? entity.hashCode() : 0;
       result = HASH_CODE * result + (reasonCode != null ? reasonCode.hashCode() : 0);
       result = HASH_CODE * result + (id != null ? id.hashCode() : 0);
       result = HASH_CODE * result + (details != null ? details.hashCode() : 0);
       result = HASH_CODE * result + (field != null ? field.hashCode() : 0);
       result = HASH_CODE * result + (params != null ? Arrays.hashCode(params) : 0);
       return result;
   }
}
