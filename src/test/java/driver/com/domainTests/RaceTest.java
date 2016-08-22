package driver.com.domainTests;

import driver.com.conf.factory.RaceFactory;
import driver.com.domain.Race;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by Edmund.Simons on 2016/08/11.
 */
public class RaceTest
{
    Race race;

    @Before
    public void setUp() throws Exception
    {
        race = RaceFactory.createRace("Spa", 10, 1L);
    }

    @Test
    public void testCreate() throws Exception
    {
        org.junit.Assert.assertEquals("Spa", race.getTrackName());
    }
}
