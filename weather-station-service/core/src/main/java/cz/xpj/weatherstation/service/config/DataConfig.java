package cz.xpj.weatherstation.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = "cz.xpj.weatherstation.service.repository", queryLookupStrategy = QueryLookupStrategy.Key.CREATE)

public class DataConfig {

}
