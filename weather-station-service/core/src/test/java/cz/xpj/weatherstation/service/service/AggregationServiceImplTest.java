package cz.xpj.weatherstation.service.service;

import cz.xpj.weatherstation.service.config.TestConfig;
import cz.xpj.weatherstation.service.entity.HourlyAggregatedLog;
import cz.xpj.weatherstation.service.entity.QuantityLog;
import cz.xpj.weatherstation.service.repository.QuantityLogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Import(TestConfig.class)
@WithMockUser(username = "wemos", password = "wemos", roles = {"PUSH", "USER"})
public class AggregationServiceImplTest {

    @Autowired
    private QuantityLogRepository repository;

    @Autowired
    private AggregationService aggregationService;

    @MockBean
    private Clock clock;

    @Before
    public void setup() {
        when(clock.instant()).thenReturn(Instant.now());
        Instant time = clock.instant().truncatedTo(ChronoUnit.HOURS).minus(100, ChronoUnit.MINUTES);
        for (int i = 0; i < 100; i++) {
            time = time.plus(1, ChronoUnit.MINUTES);
            QuantityLog quantityLog = new QuantityLog();
            quantityLog.setTemperature1(1f * i);
            quantityLog.setTemperature2(1f * i);
            quantityLog.setHumidity1(1f * i);
            quantityLog.setPressure1(1f * i);
            quantityLog.setPressure2(1f * i);
            quantityLog.setLight(1f * i);
            quantityLog.setRainHeight(1f * i);
            quantityLog.setRainTicks(1f * i);
            quantityLog.setTimestamp(time);

            repository.save(quantityLog);
        }
    }

    @Test
    public void test() {
        assertEquals(100, repository.count());

        HourlyAggregatedLog aggregate = aggregationService.aggregate(new ArrayList<>());

        assertEquals(aggregate.getHum1Min(), Float.valueOf(39f));
        assertEquals(aggregate.getHum1Max(), Float.valueOf(99f));
        assertEquals(aggregate.getHum1Avg(), Float.valueOf(69f));
    }

}