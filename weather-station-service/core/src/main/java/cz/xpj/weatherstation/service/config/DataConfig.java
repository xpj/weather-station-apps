package cz.xpj.weatherstation.service.config;

import cz.xpj.weatherstation.service.service.AggregationService;
import cz.xpj.weatherstation.service.service.AggregationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Clock;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = "cz.xpj.weatherstation.service.repository", queryLookupStrategy = QueryLookupStrategy.Key.CREATE)
public class DataConfig {

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public AggregationService aggregationService() {
        return new AggregationServiceImpl(clock());
    }

}
