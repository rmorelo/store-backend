package br.com.store.infrastructure.rest.converter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import br.com.store.infrastructure.exception.BadRequestRepositoryException;
import br.com.store.infrastructure.exception.ForbiddenRepositoryException;
import br.com.store.infrastructure.exception.NotModifiedRepositoryException;
import br.com.store.infrastructure.formatter.DateFormatter;
import br.com.store.infrastructure.rest.RestClientException;
import br.com.store.infrastructure.rest.model.ErrorMessage;
import br.com.store.infrastructure.rest.model.Resource;
import br.com.store.infrastructure.serializer.JsonDateDeserializer;
import br.com.store.infrastructure.serializer.JsonDateSerializer;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class PlataformResponseConverter {

    private static Logger logger = Logger.getLogger(PlataformResponseConverter.class);

    private PlataformResponseConverter() {
    }

    public static <T> Resource<T> parseResponse(HttpResponse httpResponse, Class<T> clazz) throws RestClientException {

        Resource<T> resource = null;

        try {
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                return null;
            }

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_MODIFIED) {
                throw new NotModifiedRepositoryException();
            }

            if (httpResponse.getStatusLine().getStatusCode() >= HttpStatus.SC_OK
                    && httpResponse.getStatusLine().getStatusCode() < HttpStatus.SC_INTERNAL_SERVER_ERROR) {

                resource = createResponseObject(httpResponse, clazz);

            } else {
                String message = "Resource<" + clazz + " > nao populado, devido a falha no retorno de consulta. status="
                        + httpResponse.getStatusLine().getStatusCode();
                logger.error(message);
                throw new RestClientException(message);
            }

        } catch (IOException e) {
            logger.error("Erro ao converter objeto response para resource do sac. status="
                    + httpResponse.getStatusLine().getStatusCode(), e);
            throw new RestClientException("Erro ao converter objeto response do cubus para objeto resource do sac.", e);
        }

        List<ErrorMessage> errorMessages = getErrorMessages(resource);
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_REQUEST) {
            if (CollectionUtils.isEmpty(errorMessages)) {
                throw new BadRequestRepositoryException();
            }
            throw new BadRequestRepositoryException(errorMessages);
        }

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_FORBIDDEN) {
            if (CollectionUtils.isEmpty(errorMessages)) {
                throw new ForbiddenRepositoryException();
            }
            throw new ForbiddenRepositoryException(errorMessages);
        }

        return resource;
    }

    private static <T> Resource<T> createResponseObject(HttpResponse httpResponse, Class<T> clazz) throws IOException {

        String stringResponse = createStringResponse(httpResponse);
        logger.debug("status=" + httpResponse.getStatusLine().getStatusCode() + ",result=" + stringResponse);
        if (StringUtils.isBlank(stringResponse)) {
            return null;
        } else {
            return parseJsonResponse(stringResponse, clazz);
        }
    }

    private static <T> Resource<T> parseJsonResponse(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(DateFormatter.CUBUS_SUPPORT_DATE_FORMAT));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        SimpleModule dateModule = new SimpleModule("DateModule", new Version(1, 0, 0, null, null, null));
        dateModule.addDeserializer(Date.class, new JsonDateDeserializer());
        dateModule.addSerializer(Date.class, new JsonDateSerializer());
        mapper.registerModule(dateModule);

        JavaType type = mapper.getTypeFactory().constructParametricType(Resource.class, clazz);

        return mapper.readValue(json, type);
    }

    private static String createStringResponse(HttpResponse response) throws IOException {

        try {
            HttpEntity entity = response.getEntity();
            String stringResponse = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            return stringResponse;

        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    private static List<ErrorMessage> getErrorMessages(Resource<?> resource) {
        if (resource != null && resource.getErrors() != null && CollectionUtils.isNotEmpty(resource.getErrors().getMessages())) {
            return resource.getErrors().getMessages();
        }
        return null;
    }
}
