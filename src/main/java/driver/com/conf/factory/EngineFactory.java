package driver.com.conf.factory;

import driver.com.domain.Engine;

/**
 * Created by Edmund.Simons on 2016/04/01.
 */
public class EngineFactory
{
    public static Engine createEngine(String brand, String model, int numOfPistons, double powerOutput)
    {
        Engine engine = new Engine.Builder(brand)
                .model(model)
                .numOfPistons(numOfPistons)
                .powerOutput(powerOutput)
                .build();

        return engine;
    }
}
