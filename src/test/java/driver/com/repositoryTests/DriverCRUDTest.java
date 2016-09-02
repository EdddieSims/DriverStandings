package driver.com.repositoryTests;

import driver.com.App;
import driver.com.conf.factory.DriverFactory;
import driver.com.domain.Driver;
import driver.com.repositories.DriverRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Edmund.Simons on 2016/08/10.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class DriverCRUDTest extends AbstractTestNGSpringContextTests
{
    private Long id;
    Driver formulaOneDriver;
    Driver readFormulaOneDriver;
    Driver updateFormulaOneDriver;

    HashMap<String, String> raceDriver;

    @Autowired
    private DriverRepository repository;


    @Test
    public void create() throws Exception
    {
        raceDriver = new HashMap<String, String>();
        raceDriver.put("name","Lewis");
        raceDriver.put("surname","Hamilton");
        raceDriver.put("country","Great Brittan");
        raceDriver.put("team","Mercedes AMG");

        formulaOneDriver = DriverFactory.createDriver(raceDriver, 0, 0, 0);
        repository.save(formulaOneDriver);
        this.id = formulaOneDriver.getId();
        System.out.println(this.id);
    }

    @Test
    public void read() throws Exception
    {
        readFormulaOneDriver = this.repository.findOne(1L);
        System.out.println(readFormulaOneDriver.getName());
    }

    @Test
    public void update() throws Exception
    {
        formulaOneDriver = this.repository.findOne(1L);
        updateFormulaOneDriver = new Driver.Builder(formulaOneDriver.getSurname()).copy(formulaOneDriver).surname("Rosburg").build();
        this.repository.save(updateFormulaOneDriver);

        System.out.println(updateFormulaOneDriver.getSurname());
    }

    @Test
    public void delete() throws Exception
    {
        formulaOneDriver = this.repository.findOne(1L);
        this.repository.delete(formulaOneDriver);
    }
}