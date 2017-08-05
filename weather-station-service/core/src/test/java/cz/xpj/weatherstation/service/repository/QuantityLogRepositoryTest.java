package cz.xpj.weatherstation.service.repository;

import cz.xpj.weatherstation.service.entity.QuantityLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuantityLogRepositoryTest {

    @Autowired
    private QuantityLogRepository repository;

    @Test
    public void checkRepository() {
        QuantityLog quantityLog = new QuantityLog();
        quantityLog.setHumidity1(99f);
        quantityLog.setTemperature1(23.5f);

        repository.save(quantityLog);

        QuantityLog one = repository.findOne(quantityLog.getId());

        assertEquals(quantityLog, one);
    }

}