package springapplication.crudoperations.business;

import springapplication.crudoperations.entities.City;

import java.util.List;

// business layer same with service
public interface ICityService {
    List<City> getAll(); // method signatures
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);
    City findByName(String name);
}
