package br.com.store.backend.infrastructure.rest.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResource {

    private List<ErrorMessage> messages;
    private String stack;

    public ErrorResource() {

    }

    public List<ErrorMessage> getMessages() {
        return messages;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public void addMessages(ErrorMessage errorMessage) {
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(errorMessage);
    }

    public void addMessages(List<ErrorMessage> errorMessage) {
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.addAll(errorMessage);
    }
}
