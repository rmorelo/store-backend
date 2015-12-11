package br.com.store.backend.infrastructure.rest.model;

import br.com.store.backend.infrastructure.rest.Linkable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource<T> implements Linkable {

    private T item;

    private List<T> items;

    private List<Link> links;

    private ErrorResource errors;

    public Resource() {
        links = new ArrayList<>();
    }

    public Resource(T item) {
        this.links = new ArrayList<>();
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void addUniqueItem(T resource) {
        if (items != null) {
            throw new RuntimeException("Nao pode adicionar ITEM e ITEMS no mesmo recurso.");
        }

        item = resource;
    }

    public void addItems(T resource) {
        if (item != null) {
            throw new RuntimeException("Nao pode adicionar ITEM e ITEMS no mesmo recurso.");
        }

        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(resource);
    }

    public void addListItems(List<T> resourceList) {
        if (item != null) {
            throw new RuntimeException("Nao pode adicionar ITEM e ITEMS no mesmo recurso.");
        }

        if (items == null) {
            items = new ArrayList<>();
        }

        items.addAll(resourceList);
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public String getUri() {
        return null;
    }

    @Override
    public boolean hasLink() {
        return !links.isEmpty();
    }

    public List<Link> getLinks() {
        return links;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public void addLink(int index, Link link) {
        links.add(index, link);
    }

    public ErrorResource getErrors() {
        return errors;
    }

    public boolean hasError() {
        return errors != null;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setErrors(ErrorResource errors) {
        this.errors = errors;
    }
    
    @Override public boolean hasNextPage() {
        return false;
    }

    @Override public String getNextPageHref() {
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Resource{");
        sb.append("item=").append(item);
        sb.append(", items=").append(items);
        sb.append(", links=").append(links);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }
}
