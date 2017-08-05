package cz.xpj.weatherstation.service.repository;

import cz.xpj.weatherstation.service.entity.QuantityLog;
import org.springframework.data.repository.CrudRepository;

public interface QuantityLogRepository extends CrudRepository<QuantityLog, Long> {
}
