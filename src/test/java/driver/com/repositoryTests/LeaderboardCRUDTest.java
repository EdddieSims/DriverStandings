package driver.com.repositoryTests;

import driver.com.App;
import driver.com.conf.factory.LeaderboardFactory;
import driver.com.domain.Leaderboard;
import driver.com.repositories.LeaderboardRepository;
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
public class LeaderboardCRUDTest extends AbstractTestNGSpringContextTests
{
    private Long id;
    Leaderboard leaderboard;
    Leaderboard readLeaderboard;
    Leaderboard updateLeaderboard;

    @Autowired
    private LeaderboardRepository repository;

    @Test
    public void create() throws Exception
    {
        leaderboard = LeaderboardFactory.createLeaderboard("Nico", "Rosburg", 1.23, 1.11, 3.35, 10, 3, 7);
        this.repository.save(leaderboard);
        this.id = leaderboard.getId();
        System.out.println(this.id);
    }

    @Test
    public void read() throws Exception
    {
        readLeaderboard = this.repository.findOne(1L);
        System.out.println(readLeaderboard.getSurname());
    }

    @Test
    public void update() throws Exception
    {
        leaderboard = this.repository.findOne(1L);
        updateLeaderboard = new Leaderboard.Builder(leaderboard.getName()).copy(leaderboard).currLap(4).lapsRemaining(6).build();
        this.repository.save(updateLeaderboard);

        System.out.println(updateLeaderboard.getCurrLap());
    }

    @Test
    public void delete() throws Exception
    {
        leaderboard = this.repository.findOne(1L);
        this.repository.delete(leaderboard);
    }
}
