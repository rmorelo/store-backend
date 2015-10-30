package br.com.store.backend.infrastructure.configuration;

import br.com.store.backend.infrastructure.interceptor.CacheControlInterceptor;
import br.com.store.backend.infrastructure.interceptor.TrackerInterceptor;
import br.com.store.backend.infrastructure.interceptor.WebAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import br.com.store.backend.infrastructure.rest.selector.SelectorValidatorInterceptor;

/**
 * Classe responsável pela configuração de MVC da aplicação.
 */
@Configuration
@EnableWebMvc
@Profile("prod")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private CacheControlInterceptor cacheControlInterceptor;

    @Autowired
    private WebAuthInterceptor webAuthInterceptor;

    @Autowired
    private TrackerInterceptor trackerInterceptor;

    @Autowired
    private SelectorValidatorInterceptor selectorInterceptor;

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();

        // Habilita o uso de MatrixParams
        handlerMapping.setRemoveSemicolonContent(false);

        handlerMapping.setUrlDecode(false);

        // Injeta os interceptors
        handlerMapping.setInterceptors(new Object[] {cacheControlInterceptor, trackerInterceptor, webAuthInterceptor,
                selectorInterceptor });
        return handlerMapping;
    }

}
