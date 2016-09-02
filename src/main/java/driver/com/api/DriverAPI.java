package driver.com.api;

import driver.com.domain.Driver;
import driver.com.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Edmund.Simons on 2016/08/23.
 */
@RestController
@RequestMapping("/api/**")
public class DriverAPI
{
    @Autowired
    private DriverService service;

    //-------------------Retrieve All Drivers--------------------------------------------------------

    @RequestMapping(value = "/drivers/", method = RequestMethod.GET)
    public ResponseEntity<List<Driver>> listAllCars()
    {
        List<Driver> driver = service.findAll();
        if(driver.isEmpty())
        {
            return new ResponseEntity<List<Driver>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Driver>>(driver, HttpStatus.OK);
    }


    //-------------------Retrieve Single Driver--------------------------------------------------------

    @RequestMapping(value = "/driver/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Driver> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Driver driver = service.findById(id);
        if (driver == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Driver>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Driver>(driver, HttpStatus.OK);
    }


    //-------------------Create a Driver--------------------------------------------------------

    @RequestMapping(value = "/driver/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Driver driver, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Subject" + driver.getName());
        service.save(driver);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/driver/{id}").buildAndExpand(driver.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a Driver --------------------------------------------------------

    @RequestMapping(value = "/driver/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Driver> updateDriver(@PathVariable("id") long id, @RequestBody Driver driver)
    {
        System.out.println("Updating Driver " + id);

        Driver currentDriver = service.findById(id);

        if (currentDriver == null)
        {
            System.out.println("Driver with id " + id + " not found");
            return new ResponseEntity<Driver>(HttpStatus.NOT_FOUND);
        }

        Driver updatedDriver = new Driver
                .Builder(currentDriver.getName())
                .copy(currentDriver)
                .build();
        service.update(updatedDriver);
        return new ResponseEntity<Driver>(updatedDriver, HttpStatus.OK);
    }


    //------------------- Delete a Driver --------------------------------------------------------

    @RequestMapping(value = "/driver/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Driver> deleteDriver(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Driver with id " + id);

        Driver driver = service.findById(id);
        if (driver == null) {
            System.out.println("Unable to delete driver with id " + id + ", not found");
            return new ResponseEntity<Driver>(HttpStatus.NOT_FOUND);
        }

        service.delete(driver);
        return new ResponseEntity<Driver>(HttpStatus.NO_CONTENT);
    }
}
