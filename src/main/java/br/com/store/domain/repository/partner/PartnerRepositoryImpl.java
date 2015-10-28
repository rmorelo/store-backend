package br.com.store.domain.repository.partner;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.json.simple.JSONObject;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.store.domain.entity.PartnerEntity;
import br.com.store.infrastructure.exception.BadRequestException;
import br.com.store.infrastructure.profiling.Profiling;
import br.com.store.infrastructure.rest.RestClient;
import br.com.store.infrastructure.rest.RestClientException;
import br.com.store.infrastructure.rest.converter.PlataformResponseConverter;
import br.com.store.infrastructure.rest.model.Resource;


@Repository
public class PartnerRepositoryImpl implements PartnerRepository {

    private static final String USERS_URI = "/rs/users/";
    private static final String STATUS_ACTIVE = "ACTIVE";

    @Autowired
    private RestClient restClient;

    private PartnerEntity getEntity(Resource<PartnerEntity> response) {
        if (response == null) {
            return null;
        }
        return response.getItem();
    }

    @Profiled(level = Profiling.REPOSITORY)
    @Override
    public PartnerEntity getPartner(Long idtPartner) throws RestClientException {

        URI uri = UriBuilder.fromPath(USERS_URI + idtPartner).scheme(PartnerRepository.SCHEME).host(PartnerRepository.HOST)
                .port(PartnerRepository.PORT).build();

        HttpResponse httpResponse = restClient.get(uri);

        Resource<PartnerEntity> response = PlataformResponseConverter.parseResponse(httpResponse,
        		PartnerEntity.class);

        return getEntity(response);
    }

    @Profiled(level = Profiling.REPOSITORY)
    @Override
    public PartnerEntity getPartner(String name) throws RestClientException {

        URI uri = UriBuilder.fromPath(USERS_URI).scheme(PartnerRepository.SCHEME).host(PartnerRepository.HOST)
                .port(PartnerRepository.PORT).matrixParam("name", name).build();

        HttpResponse httpResponse = restClient.get(uri);

        Resource<PartnerEntity> response = PlataformResponseConverter.parseResponse(httpResponse,
        		PartnerEntity.class);
        return getEntityOnList(response, true);
    }
    
    private PartnerEntity getEntityOnList(Resource<PartnerEntity> response, boolean activeOnly) {

        if (isUserResponseHasItems(response)) {

            for (PartnerEntity partner : response.getItems()) {
                return partner;
            }
        }

        if (isUserResponseHasItem(response)) {
            return response.getItem();
        }

        return null;
    }


    private boolean isUserResponseHasItem(Resource<PartnerEntity> response) {
        return !isNullResponseItem(response);
    }

    private boolean isUserResponseHasItems(Resource<PartnerEntity> response) {
        return !isNullResponseItems(response) && !response.getItems().isEmpty();
    }

    private boolean isNullResponseItems(Resource<PartnerEntity> response) {
        return response == null || response.getItems() == null;
    }

    @Profiled(level = Profiling.REPOSITORY)
    private boolean isNullResponseItem(Resource<PartnerEntity> response) {
        return response == null || response.getItem() == null;
    }
    
    @SuppressWarnings("unchecked")
    private String getRequestBody(Map<String, String> updateParams) {

        JSONObject json = new JSONObject();
        for (Entry<String, String> entry : updateParams.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }

        return json.toString();
    }

}
