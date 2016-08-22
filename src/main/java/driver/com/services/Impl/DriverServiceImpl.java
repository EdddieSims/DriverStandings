package driver.com.services.Impl;

import driver.com.domain.Driver;
import driver.com.repositories.DriverRepository;
import driver.com.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Edmund.Simons on 2016/08/10.
 */
public class DriverServiceImpl implements DriverService
{
    @Autowired
    private DriverRepository repository;

    public Driver findById(Long aLong) {
        return null;
    }

    public Driver save(Driver entity) {
        return null;
    }

    public Driver update(Driver entity) {
        return null;
    }

    public void delete(Driver entity) {

    }

    public List<Driver> findAll() {
        return null;
    }
}
