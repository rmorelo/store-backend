package br.com.store.infrastructure.rest;

import br.com.store.infrastructure.rest.model.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;

import java.nio.charset.Charset;

public class RestClientHolder {

    private Logger logger = Logger.getLogger(RestClientHolder.class);

    public static final int DEFAULT_CONNECTION_TIMEOUT = 3000;
    public static final int DEFAULT_CONNECTION_REQUEST_TIMEOUT = 3000;
    public static final int DEFAULT_SOCKET_TIMEOUT = 30000;

    private int connectionTimeout;
    private int connectionRequestTimeout;
    private int socketTimeout;
    private String mediaType;
    private HttpEntity httpEntity;

    public RestClientHolder(String mediaType, HttpEntity httpEntity) {
        this.mediaType = mediaType;
        this.httpEntity = httpEntity;
    }

    public RestClientHolder() {
    }

    public String getMediaType() {
        if (StringUtils.isBlank(mediaType)) {
            this.mediaType = MediaType.APPLICATION_VND_RESOURCE_JSON;
        }
        return this.mediaType;
    }


    public RestClientHolder setMediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public int getConnectionTimeout() {
        if (this.connectionTimeout == 0) {
            this.connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
        }
        return this.connectionTimeout;
    }

    public RestClientHolder setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    public int getConnectionRequestTimeout() {
        if (this.connectionRequestTimeout == 0) {
            this.connectionRequestTimeout = DEFAULT_CONNECTION_REQUEST_TIMEOUT;
        }

        return this.connectionRequestTimeout;
    }

    public int getSocketTimeout() {
        if (this.socketTimeout == 0) {
            this.socketTimeout = DEFAULT_SOCKET_TIMEOUT;
        }

        return this.socketTimeout;
    }

    public RestClientHolder setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
        return this;
    }

    public RestClientHolder setJson(Object resource) throws RestClientException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(resource);
            httpEntity = new StringEntity(json, Charset.forName("UTF-8"));
            return this;
        } catch (JsonProcessingException e) {
            logger.error("Erro ao criar JSON de resource. resource=" + resource, e);
            throw new RestClientException("Erro ao criar JSON de resource. resource=" + resource, e);
        }
    }


    public RestClientHolder setJson(Object resource, String contentType) throws RestClientException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(resource);
            httpEntity = new StringEntity(json, ContentType.create(contentType, Charset.forName("UTF-8")));
            return this;
        } catch (JsonProcessingException e) {
            logger.error("Erro ao criar JSON de resource. resource=" + resource, e);
            throw new RestClientException("Erro ao criar JSON de resource. resource=" + resource, e);
        }
    }

    public RestClientHolder setHttpEntity(HttpEntity httpEntity) throws RestClientException {
        this.httpEntity = httpEntity;
        return this;
    }

    public HttpEntity getHttpEntity() {
        return httpEntity;
    }

    public RestClientHolder basic(){
        connectionRequestTimeout = DEFAULT_CONNECTION_REQUEST_TIMEOUT;
        connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
        socketTimeout = DEFAULT_SOCKET_TIMEOUT;
        mediaType = MediaType.APPLICATION_VND_RESOURCE_JSON;

        return this;
    }

}
