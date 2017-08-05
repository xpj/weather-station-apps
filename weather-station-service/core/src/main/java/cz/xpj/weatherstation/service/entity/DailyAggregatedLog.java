package cz.xpj.weatherstation.service.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "daily_aggregated_log")
@Data
public class DailyAggregatedLog extends AggregatedLog {
}
