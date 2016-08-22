package driver.com.repositories;

import driver.com.domain.Track;
import driver.com.repositories.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Edmund.Simons on 2016/04/22.
 */
public interface TrackRepository extends CrudRepository<Track, Long>
{
}
