package cz.xpj.weatherstation.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "quantity_log")
public class QuantityLog {

    private @Id @GeneratedValue Long id;

    private Float temperature1;
    private Float temperature2;
    private Float humidity1;
    private Float pressure1;
    private Float pressure2;
    private Float light;
    private Float rainTicks;
    private Float rainHeight;

    private Instant timestamp;
}
