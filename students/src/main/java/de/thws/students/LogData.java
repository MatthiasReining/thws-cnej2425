package de.thws.students;

import java.time.ZonedDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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

    @ManyToOne(cascade = CascadeType.ALL)
    public Student student;

    public String message;

    public ZonedDateTime ts;
}
