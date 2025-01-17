package de.thws.courses.entity;

import de.thws.courses.boundary.CourseDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Course extends PanacheEntity {

    public String name;
    public String description;

    public CourseDTO toDTO() {
        CourseDTO dto = new CourseDTO();
        dto.name = name;
        dto.description = description;
        return dto;
    }
}
