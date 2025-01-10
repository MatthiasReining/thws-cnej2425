package de.thws.students.logdata.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class LogData {

    public LogData() {
    }

    public LogData(String message) {
        this.message = message;
    }

    @Id
    @GeneratedValue
    public Long id;

    public String message;

    public ZonedDateTime ts;
}
