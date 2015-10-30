package br.com.store.backend.infrastructure.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Classe responsavel pelas configurações de inicialização dos Beans.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.store.backend", excludeFilters = @ComponentScan.Filter(Configuration.class))
public class StoreContextConfiguration {

    /**
     * Bean que configura o MessageSource para definição de mensagens através de um arquivo properties
     * 
     * @return
     */
    @Bean
    public MessageSource messageSource() {

        StoreMessageSource messageSource = new StoreMessageSource();
        messageSource.setBasename("classpath:/validationMessages");

        // Retorna chave caso nao encontre no ValidationMessages.properties
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

}
