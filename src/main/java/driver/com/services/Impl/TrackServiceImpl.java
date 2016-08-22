package driver.com.services.Impl;

import driver.com.domain.Track;
import driver.com.repositories.TrackRepository;
import driver.com.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Edmund.Simons on 2016/08/10.
 */
public class TrackServiceImpl implements TrackService
{
    @Autowired
    private TrackRepository repository;

    public Track findById(Long aLong) {
        return null;
    }

    public Track save(Track entity) {
        return null;
    }

    public Track update(Track entity) {
        return null;
    }

    public void delete(Track entity) {

    }

    public List<Track> findAll() {
        return null;
    }
}
