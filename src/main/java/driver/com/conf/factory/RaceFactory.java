package driver.com.conf.factory;

import driver.com.domain.Race;

/**
 * Created by Edmund.Simons on 2016/06/04.
 */
public class RaceFactory
{
    public static Race createRace(String trackName, int laps, Long winnerId)
    {
        Race race = new Race.Builder(trackName)
                .laps(laps)
                .winnerId(winnerId)
                .build();
        return race;
    }
}
