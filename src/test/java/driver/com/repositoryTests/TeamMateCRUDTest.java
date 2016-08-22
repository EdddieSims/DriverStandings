package driver.com.repositoryTests;

import driver.com.App;
import driver.com.conf.factory.TeamMateFactory;
import driver.com.domain.TeamMate;
import driver.com.repositories.TeamMateRepository;
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
public class TeamMateCRUDTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private TeamMateRepository repository;

    TeamMate teamMate;
    TeamMate readTeamMate;
    TeamMate updateTeamMate;

    HashMap<String, String> raceDriver;

    @Test
    public void create() throws Exception
    {
        raceDriver = new HashMap<String, String>();
        raceDriver.put("name","Lewis");
        raceDriver.put("surname","Hamillton");
        raceDriver.put("country","England");
        raceDriver.put("team","Mercedes AMG");

        teamMate = TeamMateFactory.createTeamMate(raceDriver, 18, 7, 0);
        this.repository.save(teamMate);
        this.id = teamMate.getId();

        System.out.println(teamMate.getName());
    }

    @Test
    public void read() throws Exception
    {
        readTeamMate = this.repository.findOne(1L);
        System.out.println(readTeamMate.getSurname());
    }

    @Test
    public void update() throws Exception
    {
        teamMate = this.repository.findOne(1L);
        updateTeamMate = new TeamMate.Builder(teamMate.getSurname()).copy(teamMate).surname("Hamilton").build();
        this.repository.save(updateTeamMate);

        System.out.println(updateTeamMate.getSurname());
    }

    @Test
    public void delete() throws Exception
    {
        teamMate = this.repository.findOne(1L);
        this.repository.delete(teamMate);
    }
}
