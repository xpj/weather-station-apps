package cz.xpj.weatherstation.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Version;
import java.time.Instant;

@Data
@Entity
@SqlResultSetMapping(
        name = "AggregatedLogMapping",
        entities = {
                @EntityResult(
                        entityClass = AggregatedLog.class,
                        fields = {
                                @FieldResult(name = "temp1Avg", column = "temp1_avg"),
                                @FieldResult(name = "temp1Min", column = "temp1_min"),
                                @FieldResult(name = "temp1Max", column = "temp1_max"),
                                @FieldResult(name = "temp2Avg", column = "temp2_avg"),
                                @FieldResult(name = "temp2Min", column = "temp2_min"),
                                @FieldResult(name = "temp2Max", column = "temp2_max"),
                                @FieldResult(name = "hum1Avg", column = "hum1_avg"),
                                @FieldResult(name = "hum1Min", column = "hum1_min"),
                                @FieldResult(name = "hum1Max", column = "hum1_max"),
                                @FieldResult(name = "press1Avg", column = "press1_avg"),
                                @FieldResult(name = "press1Min", column = "press1_min"),
                                @FieldResult(name = "press1Max", column = "press1_max"),
                                @FieldResult(name = "press2Avg", column = "press2_avg"),
                                @FieldResult(name = "press2Min", column = "press2_min"),
                                @FieldResult(name = "press2Max", column = "press2_max"),
                                @FieldResult(name = "lightAvg", column = "light_avg"),
                                @FieldResult(name = "lightMin", column = "light_min"),
                                @FieldResult(name = "lightMax", column = "light_max"),
                                @FieldResult(name = "rainTicksCount", column = "rain_ticks_count"),
                                @FieldResult(name = "rainHeightCount", column = "rain_height_count")
                        }
                )
        }
)
public abstract class AggregatedLog {

    private @Id @GeneratedValue Long id;

    @Column(name = "temp1_avg")
    private Float temp1Avg;
    @Column(name = "temp1_min")
    private Float temp1Min;
    @Column(name = "temp1_max")
    private Float temp1Max;
    @Column(name = "temp2_avg")
    private Float temp2Avg;
    @Column(name = "temp2_min")
    private Float temp2Min;
    @Column(name = "temp2_max")
    private Float temp2Max;
    @Column(name = "hum1_avg")
    private Float hum1Avg;
    @Column(name = "hum1_min")
    private Float hum1Min;
    @Column(name = "hum1_max")
    private Float hum1Max;
    @Column(name = "press1_avg")
    private Float press1Avg;
    @Column(name = "press1_min")
    private Float press1Min;
    @Column(name = "press1_max")
    private Float press1Max;
    @Column(name = "press2_avg")
    private Float press2Avg;
    @Column(name = "press2_min")
    private Float press2Min;
    @Column(name = "press2_max")
    private Float press2Max;
    @Column(name = "light_avg")
    private Float lightAvg;
    @Column(name = "light_min")
    private Float lightMin;
    @Column(name = "light_max")
    private Float lightMax;
    @Column(name ="rain_ticks_count")
    private Float rainTicksCount;
    @Column(name ="rain_height_count")
    private Float rainHeightCount;

    private Instant timestamp;

    public AggregatedLog() {
    }

}
