package driver.com.repositoryTests;

import driver.com.App;
import driver.com.conf.factory.TrackFactory;
import driver.com.domain.Track;
import driver.com.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Edmund.Simons on 2016/08/10.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TrackCRUDTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private TrackRepository repository;

    Track track;
    Track readTrack;
    Track updateTrack;

    @Test
    public void create() throws Exception
    {
        track = TrackFactory.createTrack("Germany", "Leguna Seca", 17, 8.9);
        this.repository.save(track);
        this.id = track.getId();
        System.out.println(this.id);
    }

    @Test
    public void read() throws Exception
    {
        readTrack = this.repository.findOne(1L);
        System.out.println(readTrack.getTrackName());
    }

    @Test
    public void update() throws Exception
    {
        track = this.repository.findOne(1L);
        updateTrack = new Track.Builder(track.getCountry()).copy(track).trackName("Hockenheim").build();
        this.repository.save(updateTrack);

        System.out.println(updateTrack.getTrackName());
    }

    @Test
    public void delete() throws Exception
    {
        track = this.repository.findOne(1L);
        this.repository.delete(track);
    }
}
