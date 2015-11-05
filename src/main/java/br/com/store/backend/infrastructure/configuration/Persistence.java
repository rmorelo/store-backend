package br.com.store.backend.infrastructure.configuration;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableJpaRepositories("br.com.store.backend.domain")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class Persistence {

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    @Resource
    private Environment environment;

    @Bean
    public BoneCPDataSource dataSource() {

        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setJdbcUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        // https://github.com/wwadge/bonecp/blob/master/bonecp/src/main/resources/bonecp-default-config.xml
        dataSource.setConnectionTestStatement("SELECT 1 FROM DUAL");
        dataSource.setMinConnectionsPerPartition(0);
        dataSource.setMaxConnectionsPerPartition(10);
        dataSource.setMaxConnectionAge(0, TimeUnit.SECONDS);
        dataSource.setConnectionTimeout(5, TimeUnit.SECONDS);
        dataSource.setIdleMaxAge(60, TimeUnit.MINUTES);
        dataSource.setAcquireIncrement(1);
        dataSource.setPartitionCount(1);
        dataSource.setIdleConnectionTestPeriod(240, TimeUnit.MINUTES);
        dataSource.setStatementsCacheSize(500);
        dataSource.setCloseConnectionWatch(false);
        dataSource.setAcquireRetryDelay(7000, TimeUnit.MILLISECONDS);
        dataSource.setAcquireRetryAttempts(5);
        dataSource.setQueryExecuteTimeLimit(1, TimeUnit.MILLISECONDS);
        dataSource.setLazyInit(false);
        dataSource.setLogStatementsEnabled(true);

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws ClassNotFoundException {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        transactionManager.setDataSource(dataSource());

        return transactionManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        Properties jpaProterties = new Properties();
        jpaProterties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        jpaProterties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        jpaProterties
            .put("hibernate.ejb.naming_strategy", environment.getRequiredProperty("hibernate.ejb.naming_strategy"));
        jpaProterties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        jpaProterties
            .put("hibernate.generate_statistics", environment.getRequiredProperty("hibernate.generate_statistics"));

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("br.com.store.backend.domain");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(jpaProterties);
        factory.afterPropertiesSet();

        return factory.getObject();
    }

}
