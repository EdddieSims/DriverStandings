package driver.com.repositoryTests;

import driver.com.App;
import driver.com.conf.factory.CarFactory;
import driver.com.domain.Car;
import driver.com.repositories.CarRepository;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Edmund.Simons on 2016/08/09.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CarCRUDTest  extends AbstractTestNGSpringContextTests
{
    private Long id;
    Car formulaOneCar;
    Car readFormulaOneCar;
    Car updateFormulaOneCar;

    @Autowired
    private CarRepository repository;

    @Test
    public void create() throws Exception
    {
        formulaOneCar = CarFactory.createCar("Audi", "TT RS", 2015);

        repository.save(formulaOneCar);
        this.id = formulaOneCar.getId();
        System.out.println(this.id);
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception
    {
        readFormulaOneCar = this.repository.findOne(this.id);
        Assert.assertEquals("Audi", readFormulaOneCar.getMake());
        System.out.println(readFormulaOneCar.getModel());
    }

    @Test
    public void update() throws Exception
    {
        formulaOneCar = this.repository.findOne(7L);
        updateFormulaOneCar = new Car.Builder(formulaOneCar.getMake()).copy(formulaOneCar).year(2016).build();
        this.repository.save(updateFormulaOneCar);

        updateFormulaOneCar = this.repository.findOne(7L);
        Assert.assertEquals(2016, updateFormulaOneCar.getYear());
        System.out.println(updateFormulaOneCar.getYear());
    }

    @Test
    public void delete() throws Exception
    {
        formulaOneCar = this.repository.findOne(7L);
        this.repository.delete(formulaOneCar);
    }
}
