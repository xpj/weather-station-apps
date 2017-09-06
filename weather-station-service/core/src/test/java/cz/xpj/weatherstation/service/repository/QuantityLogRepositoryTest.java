package cz.xpj.weatherstation.service.repository;

import cz.xpj.weatherstation.service.entity.QuantityLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import sun.plugin.liveconnect.SecurityContextHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class QuantityLogRepositoryTest {

    @Autowired
    private QuantityLogRepository repository;

    @Test
    @WithMockUser(username = "wemos", password = "wemos", roles = {"PUSH"})
    public void pushRoleCanOnlyStore() {
        QuantityLog quantityLog = new QuantityLog();
        quantityLog.setHumidity1(99f);
        quantityLog.setTemperature1(23.5f);

        repository.save(quantityLog);
    }

    @Test(expected = AccessDeniedException.class)
    @WithMockUser(username = "wemos", password = "wemos", roles = {"PUSH"})
    public void pushRoleCannotReadData() {
        repository.findAll();
    }

    @Test
    @WithMockUser(username = "wemos", password = "wemos")
    public void userRoleCanReadData() {
        repository.findAll();
    }

    @Test(expected = AccessDeniedException.class)
    @WithMockUser(username = "wemos", password = "wemos")
    public void userRoleCannotDelete() {
        repository.deleteAll();
    }

    @Test(expected = AccessDeniedException.class)
    @WithAnonymousUser
    public void noReadAccessForAnonymous() {
        repository.findAll();
    }

}