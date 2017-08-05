package cz.xpj.weatherstation.service.repository;

import cz.xpj.weatherstation.service.entity.HourlyAggregatedLog;
import org.springframework.data.repository.CrudRepository;

public interface HourlyAggregatedLogRepository extends CrudRepository<HourlyAggregatedLog, Long> {
}
