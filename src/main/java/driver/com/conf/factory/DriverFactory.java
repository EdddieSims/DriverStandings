package driver.com.conf.factory;

import driver.com.domain.Driver;

import java.util.Map;

/**
 * Created by Edmund.Simons on 2016/04/01.
 */
public class DriverFactory
{
    public static Driver createDriver(Map<String, String> value, int points, int behind, int numOfWins)
    {
        Driver driver = new Driver.Builder(value.get("name"))
                .surname(value.get("surname"))
                .country(value.get("country"))
                .team(value.get("team"))
                .points(points)
                .behind(behind)
                .numOfWins(numOfWins).build();
        return driver;
    }
}
