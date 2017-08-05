package cz.xpj.weatherstation.service.repository;

import cz.xpj.weatherstation.service.entity.DailyAggregatedLog;
import org.springframework.data.repository.CrudRepository;

public interface DailyAggregatedLogRepository extends CrudRepository<DailyAggregatedLog, Long> {
}
