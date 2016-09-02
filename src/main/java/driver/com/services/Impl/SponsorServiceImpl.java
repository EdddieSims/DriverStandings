package driver.com.services.Impl;

import driver.com.domain.Sponsor;
import driver.com.repositories.SponsorRepository;
import driver.com.services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edmund.Simons on 2016/08/10.
 */
@Service
public class SponsorServiceImpl implements SponsorService
{
    @Autowired
    private SponsorRepository repository;

    public Sponsor findById(Long aLong) {
        return null;
    }

    public Sponsor save(Sponsor entity) {
        return null;
    }

    public Sponsor update(Sponsor entity) {
        return null;
    }

    public void delete(Sponsor entity) {

    }

    public List<Sponsor> findAll() {
        return null;
    }
}
