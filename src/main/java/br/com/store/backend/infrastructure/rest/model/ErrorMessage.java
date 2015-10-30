package br.com.store.backend.infrastructure.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorMessage {

    private Integer code;
    private String field;
    private String title;
    private String message;

    @JsonCreator
    public ErrorMessage(
            @JsonProperty("code") Integer code, 
            @JsonProperty("field") String field,
            @JsonProperty("title") String title,
            @JsonProperty("message") String message) {
        this.code = code;
        this.field = field;
        this.title = title;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getField() {
        return field;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
