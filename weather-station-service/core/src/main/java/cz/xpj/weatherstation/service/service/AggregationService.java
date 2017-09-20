package cz.xpj.weatherstation.service.service;

import cz.xpj.weatherstation.service.entity.DailyAggregatedLog;
import cz.xpj.weatherstation.service.entity.HourlyAggregatedLog;
import cz.xpj.weatherstation.service.entity.MonthlyAggregatedLog;
import cz.xpj.weatherstation.service.entity.QuantityLog;

import java.util.List;

public interface AggregationService {

    HourlyAggregatedLog aggregate(List<QuantityLog> quantityLogs);

    DailyAggregatedLog dailyAggregate(List<HourlyAggregatedLog> hourlyAggregatedLogs);

    MonthlyAggregatedLog monthlyAggregate(List<DailyAggregatedLog> dailyAggregatedLogs);

}
