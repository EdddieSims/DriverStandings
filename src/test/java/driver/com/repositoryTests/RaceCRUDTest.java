package driver.com.repositoryTests;

import driver.com.App;
import driver.com.conf.factory.RaceFactory;
import driver.com.domain.Race;
import driver.com.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Edmund.Simons on 2016/08/10.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RaceCRUDTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private RaceRepository repository;

    Race race;
    Race readRace;
    Race updateRace;

    @Test
    public void create() throws Exception
    {
        race = RaceFactory.createRace("Spa", 10, 1L);
        this.repository.save(race);

        this.id = race.getId();
        System.out.println(this.id);
    }

    @Test
    public void read() throws Exception
    {
        readRace = this.repository.findOne(1L);
        System.out.println(readRace.getTrackName());
    }

    @Test
    public void update() throws Exception
    {
        race = this.repository.findOne(1L);
        updateRace = new Race.Builder(race.getTrackName()).laps(20).build();
        this.repository.save(updateRace);

        System.out.println(updateRace.getLaps());
    }

    @Test
    public void delete() throws Exception
    {
        race = this.repository.findOne(1L);
        this.repository.delete(race);
    }
}
