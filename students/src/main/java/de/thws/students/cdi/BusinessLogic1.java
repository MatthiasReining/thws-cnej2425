package de.thws.students.cdi;

import java.util.Date;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@RequestScoped
public class BusinessLogic1 {

    private String state;

    @Inject
    Instance<BusinessLogic2> businessLogic2Instance;

    public void setState(String state) {
        this.state = state;
    }

    @PostConstruct
    void init() {
        System.out.println("BusinessLogic1 initialized");
        state = this + " - " + new Date();
    }

    public void execute() {

        System.out.println("BusinessLogic1 started...");

        // complex condition
        if (true) { // check why this businessLogic2 is null in case of producer factory
            BusinessLogic2 businessLogic2 = businessLogic2Instance.get();
            businessLogic2.execute();
        }
        System.out.println("BusinessLogic1 executed...");

        System.out.println("Current state is: " + state);
    }
}
