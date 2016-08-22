package driver.com.repositoryTests;

import driver.com.App;
import driver.com.conf.factory.SponsorFactory;
import driver.com.domain.Sponsor;
import driver.com.repositories.SponsorRepository;
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
public class SponsorCRUDTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private SponsorRepository repository;

    Sponsor sponsor;
    Sponsor readSponsor;
    Sponsor updateSponsor;

    @Test
    public void create() throws Exception
    {
        sponsor = SponsorFactory.createSponsor("Petron", "Marine Blue");
        this.repository.save(sponsor);
        this.id = sponsor.getId();
        System.out.println(this.id);
    }

    @Test
    public void read() throws Exception
    {
        readSponsor = this.repository.findOne(1L);
        System.out.println(readSponsor.getName());
    }

    @Test
    public void update() throws Exception
    {
        sponsor = this.repository.findOne(1L);
        updateSponsor = new Sponsor.Builder(sponsor.getName()).copy(sponsor).name("Petronas").logoColour("Petrol Green").build();
        this.repository.save(updateSponsor);

        System.out.println(updateSponsor.getName());
    }

    @Test
    public void delete() throws Exception
    {
        sponsor = this.repository.findOne(1L);
        this.repository.delete(sponsor);
    }
}
