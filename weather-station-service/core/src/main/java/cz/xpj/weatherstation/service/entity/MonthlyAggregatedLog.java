package cz.xpj.weatherstation.service.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monthly_aggregated_log")
@Data
public class MonthlyAggregatedLog extends AggregatedLog {
}
