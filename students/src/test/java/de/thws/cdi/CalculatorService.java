package de.thws.cdi;

public class CalculatorService {

    @ThwsInject
    private FactorService factorService;

    private Integer defaultMulti = 24;

    public int calculate(int i) {
        int multi = factorService.getMulti();
        return i * multi;
    }

}
