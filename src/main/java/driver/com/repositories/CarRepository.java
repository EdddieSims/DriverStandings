package driver.com.repositories;

import driver.com.domain.Car;
import driver.com.repositories.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Edmund.Simons on 2016/04/21.
 */
public interface CarRepository extends CrudRepository<Car, Long>
{
}
