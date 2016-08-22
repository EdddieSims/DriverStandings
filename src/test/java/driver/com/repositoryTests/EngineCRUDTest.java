package driver.com.repositoryTests;

import driver.com.App;
import driver.com.conf.factory.EngineFactory;
import driver.com.domain.Engine;
import driver.com.repositories.EngineRepository;
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
public class EngineCRUDTest  extends AbstractTestNGSpringContextTests
{
    private Long id;
    Engine engine;
    Engine readEngine;
    Engine updateEngine;

    @Autowired
    private EngineRepository repository;

    @Test
    public void create() throws Exception
    {
        engine = EngineFactory.createEngine("Mercedes Benz", "AMG-12/6", 8, 4.5);
        repository.save(engine);

        this.id = engine.getId();
        System.out.println(this.id);
    }

    @Test
    public void read() throws Exception
    {
        readEngine = this.repository.findOne(1L);
        System.out.println(readEngine.getBrand());
    }

    @Test
    public void update() throws Exception
    {
        engine = this.repository.findOne(1L);
        updateEngine = new Engine.Builder(engine.getBrand()).copy(engine).numOfPistons(6).powerOutput(1.6).brand("Ford").build();
        this.repository.save(updateEngine);

        System.out.println(updateEngine.getNumOfPistons());
    }

    @Test
    public void delete() throws Exception
    {
        engine = this.repository.findOne(1L);
        this.repository.delete(engine);
    }
}
