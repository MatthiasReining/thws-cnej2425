package de.thws.students.cdi;

import jakarta.enterprise.inject.Produces;

public class BusinesLogicFactory {

    @Produces
    @ThwsBusinesLogic1
    public BusinessLogic1 createBusinessLogic1() {
        System.out.println("Factory called");
        BusinessLogic1 bl1 = new BusinessLogic1();
        bl1.setState("Hallo hallo");
        return bl1;
    }

}
