package driver.com.conf.factory;

import driver.com.domain.Car;

/**
 * Created by Edmund.Simons on 2016/04/01.
 */
public class CarFactory
{
    public static Car createCar(String make, String model, int year)
    {
        Car car = new Car.Builder(make)
                .model(model)
                .year(year).build();
        return car;
    }
}
