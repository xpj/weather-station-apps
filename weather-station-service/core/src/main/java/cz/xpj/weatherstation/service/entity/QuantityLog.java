package cz.xpj.weatherstation.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "quantity_log")
@Data
public class QuantityLog {

    private @Id @GeneratedValue Long id;

    private Float temperature1;
    private Float temperature2;
    private Float humidity1;
    private Float pressure1;
    private Float pressure2;
    private Float light;
    @Column(name ="rain_ticks")
    private Float rainTicks;
    @Column(name ="rain_height")
    private Float rainHeight;

    private Instant timestamp;

    public QuantityLog() {
    }
}
