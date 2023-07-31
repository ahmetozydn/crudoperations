package springapplication.crudoperations.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springapplication.crudoperations.business.ICityService;
import springapplication.crudoperations.entities.City;
import java.util.List;

@RestController
@RequestMapping("/api") // naming convention for API
public class CityController {
    private final ICityService cityService; // const variable

    @Autowired // automatically injection
    public CityController(ICityService cityService) { // why we didn't implement ICityService directly
        this.cityService = cityService;
    }
    @GetMapping("/cities")
    public List<City> get(){
        return cityService.getAll();
    }
    @PostMapping("/add") // Method 'POST' is not supported by the browsers. Instead postman can be used for post operations
    public void add( @RequestBody City city){
        cityService.add(city);
    }
    @PostMapping("/update")
    public void update(@RequestBody City city){
        cityService.update(city);
    }
    @PostMapping("/delete")
    public void delete(@RequestBody City city){ // use id or complete record, record would be deleted
        cityService.delete(city);
    }
    @GetMapping("/cities/{id}") // get id dynamically
    public City getById(@PathVariable int id){ // use the parametre inside the variable
       return cityService.getById(id);
    }

    @GetMapping("/cities/search/{name}") // get id dynamically
    public City getByName(@PathVariable String name){ // use the parametre inside the variable
        return cityService.findByName(name);
    }


}
