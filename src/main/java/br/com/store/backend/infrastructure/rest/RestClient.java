package br.com.store.backend.infrastructure.rest;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.perf4j.aop.Profiled;
import org.springframework.stereotype.Service;

import br.com.store.backend.infrastructure.tracking.Tracker;

@Service
public class RestClient {

    private Logger logger = Logger.getLogger(RestClient.class);

    /**
     * Método para chamada GET a serviços externos
     *
     * @param uri
     * @return Response do serviço REST requisitado
     * @throws br.com.store.infrastructure.rest.RestClientException
     */
    public HttpResponse get(URI uri) throws RestClientException {
        return this.get(uri, new RestClientHolder().basic());
    }

    @SuppressWarnings("unchecked")
    public HttpResponse get(URI uri, RestClientHolder holder) throws RestClientException {
        return get(uri, MapUtils.EMPTY_MAP);
    }

    @Profiled
    public HttpResponse get(URI uri, Map<String, String> headers) throws RestClientException {
        RestClientHolder holder = new RestClientHolder().basic();
        HttpUriRequest request = new HttpGet(uri);
        addTrackerHeaders(request);
        request.addHeader("content-type", holder.getMediaType());
        //new AuthorizationClient().getAuthorizedUriRequest(request);

        if (MapUtils.isNotEmpty(headers)) {
            for (Entry<String, String> entry : headers.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }

        try {
            HttpClient client = getHttpClient(holder);
            return client.execute(request);
        } catch (IOException e) {
            logger.error("Erro ao consultar serviço externo, URL=" + request.getURI().toString() + ", metodo=GET", e);
            throw new RestClientException("Erro ao consultar um serviço externo, na url:" + request.getURI().toString(), e);
        }
    }

    /**
     * Método para chamada PUT a serviços externos passando parâmetros no corpo
     * da requisicao
     *
     * @param uri
     * @return Response do serviço REST requisitado
     * @throws br.com.store.infrastructure.rest.RestClientException
     * @throws java.io.IOException
     */
    public HttpResponse put(URI uri) throws RestClientException {
        return this.put(uri, new RestClientHolder().basic());
    }

    @Profiled
    public HttpResponse put(URI uri, RestClientHolder holder) throws RestClientException {

        HttpPut request = new HttpPut(uri);
        addTrackerHeaders(request);
        request.addHeader("content-type", holder.getMediaType());

        request.setEntity(holder.getHttpEntity());

        //new AuthorizationClient().getAuthorizedUriRequest(request);

        try {
            HttpClient client = getHttpClient(holder);
            return client.execute(request);
        } catch (IOException e) {
            logger.error("Erro ao consultar serviço externo, URL=" + request.getURI().toString() + ", metodo=PUT", e);
            throw new RestClientException("Erro ao consultar um serviço externo, na url:" + request.getURI().toString(), e);
        }

    }

    /**
     * Método para chamada POST a serviços externos passando parâmetros no corpo
     * da requisicao
     *
     * @param uri
     * @return Response do serviço REST requisitado
     * @throws br.com.store.infrastructure.rest.RestClientException
     * @throws java.io.IOException
     */
    public HttpResponse post(URI uri) throws RestClientException {
        return this.post(uri, new RestClientHolder().basic());
    }

    @SuppressWarnings("unchecked")
    public HttpResponse post(URI uri, RestClientHolder holder) throws RestClientException {
        return post(uri, holder, MapUtils.EMPTY_MAP);
    }

    @Profiled
    public HttpResponse post(URI uri, RestClientHolder holder, Map<String, String> headers) throws RestClientException {

        HttpPost request = new HttpPost(uri);
        addTrackerHeaders(request);
        request.addHeader("content-type", holder.getMediaType());

        if (MapUtils.isNotEmpty(headers)) {
            for (Entry<String, String> entry : headers.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }
        request.setEntity(holder.getHttpEntity());

        //new AuthorizationClient().getAuthorizedUriRequest(request);

        try {
            HttpClient client = getHttpClient(holder);
            return client.execute(request);
        } catch (IOException e) {
            logger.error("Erro ao consultar serviço externo, URL=" + request.getURI().toString() + ", metodo=POST", e);
            throw new RestClientException("Erro ao consultar um serviço externo, na url:" + request.getURI().toString(), e);
        }
    }

    /**
     * Método para chamada DELETE a serviços externos
     *
     * @param uri
     * @return Response do serviço REST requisitado
     * @throws br.com.store.infrastructure.rest.RestClientException
     * @throws java.io.IOException
     */
    public HttpResponse delete(URI uri) throws RestClientException {
        return this.delete(uri, new RestClientHolder().basic());
    }

    @Profiled
    public HttpResponse delete(URI uri, RestClientHolder holder) throws RestClientException {

        HttpDelete request = new HttpDelete(uri);
        addTrackerHeaders(request);
        request.addHeader("content-type", holder.getMediaType());

        //new AuthorizationClient().getAuthorizedUriRequest(request);

        try {
            HttpClient client = getHttpClient(holder);
            return client.execute(request);
        } catch (IOException e) {
            throw new RestClientException("Erro ao consultar um serviço externo, na url:" + request.getURI().toString(), e);
        }

    }

    @SuppressWarnings("unchecked")
    @Profiled
    public HttpResponse patch(URI uri, RestClientHolder holder) throws RestClientException {
        return patch(uri, holder, MapUtils.EMPTY_MAP);
    }

    @Profiled
    public HttpResponse patch(URI uri, RestClientHolder holder, Map<String, String> headers) throws RestClientException {

        HttpPatch request = new HttpPatch(uri);
        addTrackerHeaders(request);
        request.addHeader("content-type", holder.getMediaType());

        if (MapUtils.isNotEmpty(headers)) {
            for (Entry<String, String> entry : headers.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }

        request.setEntity(holder.getHttpEntity());

        //new AuthorizationClient().getAuthorizedUriRequest(request);

        try {
            HttpClient client = getHttpClient(holder);
            return client.execute(request);
        } catch (IOException e) {
            logger.error("Erro ao consultar serviço externo, URL=" + request.getURI().toString() + ", metodo=PATCH", e);
            throw new RestClientException("Erro ao consultar um serviço externo, na url:" + request.getURI().toString(), e);
        }
    }

    private void addTrackerHeaders(HttpUriRequest request) {
        request.addHeader("Browser-IP", Tracker.getString(Tracker.IP));
        request.addHeader("X-Validation-Version", Tracker.getString(Tracker.VALIDATION_VERSION));
        request.addHeader("X-Request-Id", Tracker.getString(Tracker.REQUEST));
    }

    protected HttpClient getHttpClient(RestClientHolder holder) {

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(holder.getConnectionTimeout())
                .setConnectionRequestTimeout(holder.getConnectionRequestTimeout()).setSocketTimeout(holder.getSocketTimeout())
                .build();

        return HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

    }
}
