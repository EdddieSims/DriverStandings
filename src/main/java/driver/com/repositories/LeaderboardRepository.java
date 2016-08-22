package driver.com.repositories;

import driver.com.domain.Leaderboard;
import driver.com.repositories.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Edmund.Simons on 2016/04/21.
 */
public interface LeaderboardRepository extends CrudRepository<Leaderboard, Long> {
}
