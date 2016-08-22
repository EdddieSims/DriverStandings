package driver.com.repositories;

import driver.com.domain.Race;
import driver.com.repositories.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Edmund.Simons on 2016/06/04.
 */
public interface RaceRepository extends CrudRepository<Race, Long>
{
}
