package driver.com.services.Impl;

import driver.com.domain.Engine;
import driver.com.repositories.EngineRepository;
import driver.com.services.EngineService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Edmund.Simons on 2016/08/10.
 */
public class EngineServiceImpl implements EngineService
{
    @Autowired
    private EngineRepository repository;

    public Engine findById(Long aLong) {
        return null;
    }

    public Engine save(Engine entity) {
        return null;
    }

    public Engine update(Engine entity) {
        return null;
    }

    public void delete(Engine entity) {

    }

    public List<Engine> findAll() {
        return null;
    }
}
