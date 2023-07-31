package springapplication.crudoperations.business;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springapplication.crudoperations.dal.ICityDal;
import springapplication.crudoperations.entities.City;


import java.util.List;
@Service
public class CityManager implements ICityService{
    private final ICityDal cityDal;

    @Autowired // constructor injection
    public CityManager(ICityDal cityDal){
        this.cityDal = cityDal;
    }
    @Override
    @Transactional // open a transaction and close automatically before and after the process
    public List<City> getAll() {
        return this.cityDal.getAll();
    }

    @Override
    @Transactional
    public void add(City city) {
        this.cityDal.add(city); // can be checked the city is added before or not
    }

    @Override
    @Transactional
    public void update(City city) {
        this.cityDal.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        this.cityDal.delete(city);
    }

    @Override
    @Transactional
    public City getById(int id) {

        return this.cityDal.getById(id);

    }

    @Override
    public City findByName(String name) {
        return this.cityDal.findByName(name);
    }
}
