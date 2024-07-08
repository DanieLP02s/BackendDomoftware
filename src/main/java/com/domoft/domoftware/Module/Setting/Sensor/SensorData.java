package com.domoft.domoftware.Module.Setting.Sensor;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "sensor_data")
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensorId", referencedColumnName = "id")
    private Sensor sensor;

    private java.sql.Timestamp timestamp;

    private Float value;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    //Contractor

    public SensorData(Long id, Sensor sensor, Timestamp timestamp, Float value) {
        this.id = id;
        this.sensor = sensor;
        this.timestamp = timestamp;
        this.value = value;
    }

    public SensorData(Sensor sensor, Timestamp timestamp, Float value) {
        this.sensor = sensor;
        this.timestamp = timestamp;
        this.value = value;
    }

    public SensorData() {
    }

}
