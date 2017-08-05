package cz.xpj.weatherstation.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
public abstract class AggregatedLog {

    private @Id @GeneratedValue Long id;

    private Float temp1_avg;
    private Float temp1_min;
    private Float temp1_max;
    private Float temp2_avg;
    private Float temp2_min;
    private Float temp2_max;
    private Float hum1_avg;
    private Float hum1_min;
    private Float hum1_max;
    private Float press1_avg;
    private Float press1_min;
    private Float press1_max;
    private Float press2_avg;
    private Float press2_min;
    private Float press2_max;
    private Float light_avg;
    private Float light_min;
    private Float light_max;
    @Column(name ="rain_ticks_count")
    private Float rainTicks_count;
    @Column(name ="rain_height_count")
    private Float rainHeight_count;

    private Instant timestamp;

    public AggregatedLog() {
    }
}
