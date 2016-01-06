package br.com.store.backend.infrastructure.configuration;

import java.util.List;

import br.com.store.backend.infrastructure.interceptor.CacheControlInterceptor;
import br.com.store.backend.infrastructure.interceptor.TrackerInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
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
    private TrackerInterceptor trackerInterceptor;

    @Autowired
    private SelectorValidatorInterceptor selectorInterceptor;
    
    @Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	    PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
	    // Set the default size to 5
	    phmar.setFallbackPageable(new PageRequest(0, 5));
	    argumentResolvers.add(phmar);
	    super.addArgumentResolvers(argumentResolvers);
	}
    
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();

        // Habilita o uso de MatrixParams
        handlerMapping.setRemoveSemicolonContent(false);

        handlerMapping.setUrlDecode(false);

        // Injeta os interceptors
        handlerMapping.setInterceptors(new Object[] {cacheControlInterceptor, trackerInterceptor, selectorInterceptor });
        return handlerMapping;
    }

}
