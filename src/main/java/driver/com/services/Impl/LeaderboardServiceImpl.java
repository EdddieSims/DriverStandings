package driver.com.services.Impl;

import driver.com.domain.Leaderboard;
import driver.com.repositories.LeaderboardRepository;
import driver.com.services.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Edmund.Simons on 2016/08/10.
 */
public class LeaderboardServiceImpl implements LeaderboardService
{
    @Autowired
    private LeaderboardRepository repository;

    public Leaderboard findById(Long aLong) {
        return null;
    }

    public Leaderboard save(Leaderboard entity) {
        return null;
    }

    public Leaderboard update(Leaderboard entity) {
        return null;
    }

    public void delete(Leaderboard entity) {

    }

    public List<Leaderboard> findAll() {
        return null;
    }
}
