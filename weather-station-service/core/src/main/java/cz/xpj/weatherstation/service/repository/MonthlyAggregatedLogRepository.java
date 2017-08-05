package cz.xpj.weatherstation.service.repository;

import cz.xpj.weatherstation.service.entity.MonthlyAggregatedLog;
import org.springframework.data.repository.CrudRepository;

public interface MonthlyAggregatedLogRepository extends CrudRepository<MonthlyAggregatedLog, Long> {
}
