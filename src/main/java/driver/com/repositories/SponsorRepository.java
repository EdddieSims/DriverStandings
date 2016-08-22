package driver.com.repositories;

import driver.com.domain.Sponsor;
import driver.com.repositories.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Edmund.Simons on 2016/04/22.
 */
public interface SponsorRepository extends CrudRepository<Sponsor, Long>
{
}
