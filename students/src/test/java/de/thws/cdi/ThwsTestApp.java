package de.thws.cdi;

public class ThwsTestApp {

    public static void main(String[] args) {
        System.out.println("Hello World");

        ThwsContainerManager containerManager = new ThwsContainerManager();

        CalculatorService cs = (CalculatorService) containerManager.manage(CalculatorService.class);

        // Dynamic class loading
        // ThwsTestApp.class.getClassLoader().loadClass("de.thws.cdi.FactorService");

        int result = cs.calculate(2);

        System.out.println("result: " + result);

    }
}
