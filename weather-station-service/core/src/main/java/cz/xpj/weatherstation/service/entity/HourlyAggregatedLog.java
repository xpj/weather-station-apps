package cz.xpj.weatherstation.service.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hourly_aggregated_log")
@Data
public class HourlyAggregatedLog extends AggregatedLog {
    public HourlyAggregatedLog() {
    }
}
