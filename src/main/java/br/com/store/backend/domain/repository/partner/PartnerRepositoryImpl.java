package br.com.store.backend.domain.repository.partner;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpResponse;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.store.backend.domain.entity.PartnerEntity;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.RestClient;
import br.com.store.backend.infrastructure.rest.RestClientException;
import br.com.store.backend.infrastructure.rest.converter.PlataformResponseConverter;
import br.com.store.backend.infrastructure.rest.model.Resource;


@Repository
public class PartnerRepositoryImpl implements PartnerRepository {

    private static final String PARTNERS_URI = "/api/partners/";

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

        HttpResponse httpResponse = restClient.get(getUri(PARTNERS_URI + idtPartner));

        Resource<PartnerEntity> response = PlataformResponseConverter.parseResponse(httpResponse,
        		PartnerEntity.class);

        return getEntity(response);
    }
    
    private URI getUri(String path) {

        return UriBuilder.fromPath(path).scheme(PartnerRepository.SCHEME).host(PartnerRepository.HOST).port(PartnerRepository.PORT)
                .build();
    }
}
