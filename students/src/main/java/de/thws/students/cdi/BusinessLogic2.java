package de.thws.students.cdi;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class BusinessLogic2 {

    @PostConstruct
    void init() {
        System.out.println("BusinessLogic2 initialized");
    }

    public void execute() {
        System.out.println("BusinessLogic2 executed");
    }

}
