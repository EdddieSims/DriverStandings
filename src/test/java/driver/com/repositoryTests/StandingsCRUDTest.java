package driver.com.repositoryTests;

import driver.com.App;
import driver.com.conf.factory.StandingsFactory;
import driver.com.domain.Standings;
import driver.com.repositories.StandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Edmund.Simons on 2016/08/10.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StandingsCRUDTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private StandingsRepository repository;

    Standings standings;
    Standings readStandings;
    Standings updateStandings;

    HashMap<String, String> values;

    @Test
    public void create() throws Exception
    {
        values = new HashMap<String, String>();
        values.put("name","Nico");
        values.put("surname","Rosburg");
        values.put("team","Mercedes AMG");

        standings = StandingsFactory.createStandings(values, 25, 0, 1);
        repository.save(standings);
        System.out.println(standings.getName());
    }

    @Test
    public void read() throws Exception
    {
        readStandings = this.repository.findOne(1L);

        System.out.println(readStandings.getSurname());
    }

    @Test
    public void update() throws Exception
    {
        standings = this.repository.findOne(1L);
        updateStandings = new Standings.Builder(standings.getName()).copy(standings).points(43).behind(0).numOfWins(1).build();
        this.repository.save(updateStandings);

        System.out.println(updateStandings.getPoints());
    }

    @Test
    public void delete() throws Exception
    {
        standings = this.repository.findOne(1L);
        this.repository.delete(standings);
    }
}
