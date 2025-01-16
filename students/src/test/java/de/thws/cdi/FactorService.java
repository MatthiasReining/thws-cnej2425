package de.thws.cdi;

public class FactorService {

    // will be called by naming convetion
    public void init() {
        System.out.println("init Factor Service");
    }

    public int getMulti() {
        return 42;
    }
}
