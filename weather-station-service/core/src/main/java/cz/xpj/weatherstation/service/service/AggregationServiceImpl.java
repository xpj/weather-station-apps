package cz.xpj.weatherstation.service.service;

import cz.xpj.weatherstation.service.entity.DailyAggregatedLog;
import cz.xpj.weatherstation.service.entity.HourlyAggregatedLog;
import cz.xpj.weatherstation.service.entity.MonthlyAggregatedLog;
import cz.xpj.weatherstation.service.entity.QuantityLog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class AggregationServiceImpl implements AggregationService {

    private Clock clock;

    @PersistenceContext
    private EntityManager em;

    public AggregationServiceImpl(Clock clock) {
        this.clock = clock;
    }

    @Override
    public HourlyAggregatedLog aggregate(List<QuantityLog> quantityLogs) {
        Instant now = Instant.now(clock);
        Instant lastHourEnd = now.truncatedTo(ChronoUnit.HOURS);
        Instant lastHourStart = lastHourEnd.minus(1, ChronoUnit.HOURS);

        Query nativeQuery = em.createNativeQuery("SELECT " +
                "1 as id, " +  // this is hack - cannot map to entity only part of result
                "max(timestamp) as timestamp, " + // this is hack
                "avg(temperature1) as temp1_avg, " +
                "min(temperature1) as temp1_min, " +
                "max(temperature1) as temp1_max," +
                "avg(temperature2) as temp2_avg, " +
                "min(temperature2) as temp2_min, " +
                "max(temperature2) as temp2_max, " +
                "avg(humidity1) as hum1_avg, " +
                "min(humidity1) as hum1_min, " +
                "max(humidity1) as hum1_max, " +
                "avg(pressure1) as press1_avg, " +
                "min(pressure1) as press1_min, " +
                "max(pressure1) as press1_max," +
                "avg(pressure2) as press2_avg, " +
                "min(pressure2) as press2_min, " +
                "max(pressure2) as press2_max, " +
                "avg(light) as light_avg, " +
                "min(light) as light_min, " +
                "max(light) as light_max, " +
                "sum(rain_ticks) as rain_ticks_count, " +
                "sum(rain_height) as rain_height_count " +
                "from quantity_log " +
                "where timestamp between :startTime and :endTime", HourlyAggregatedLog.class);
        nativeQuery.setParameter("startTime", lastHourStart);
        nativeQuery.setParameter("endTime", lastHourEnd);

        Object singleResult = nativeQuery.getSingleResult();
        HourlyAggregatedLog result = (HourlyAggregatedLog)singleResult;
        // remove hacks
        result.setId(null);
        result.setTimestamp(null);

        return result;
    }

    @Override
    public DailyAggregatedLog dailyAggregate(List<HourlyAggregatedLog> hourlyAggregatedLogs) {
        return null;
    }

    @Override
    public MonthlyAggregatedLog monthlyAggregate(List<DailyAggregatedLog> dailyAggregatedLogs) {
        return null;
    }
}
