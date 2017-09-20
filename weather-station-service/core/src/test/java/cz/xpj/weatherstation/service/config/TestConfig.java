package cz.xpj.weatherstation.service.config;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@TestConfiguration
public class TestConfig {

    @Bean
    public Clock clock() {
        return Mockito.mock(Clock.class);
    }

}
