package TestNG;

import org.testng.annotations.Test;

public class DemoTestNG {

    @Test(priority = 2)
    public void startCar() {
        System.out.println("Car Started");
    }

    @Test(priority = 1)
    public void driveCar() {
        System.out.println("Car Driving");
    }
}