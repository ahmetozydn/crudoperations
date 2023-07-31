package springapplication.crudoperations.dal;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springapplication.crudoperations.entities.City;
import java.util.List;

@Repository
public class HibernateCityDal implements ICityDal{

    private final EntityManager entityManager;

    @Autowired // comes from Spring, makes constructor injection
    public HibernateCityDal(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override // implements methods from Interface ICityDal
    @Transactional // open a transaction and close before and after the process
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);

        List<City> cities = session.createQuery("FROM City",City.class).getResultList();
        for(City eachCity : cities){
            System.out.println(eachCity.getName());
        }
        return cities;
    }

    @Override
    @Transactional
    public void add(City city) { // if the id is not 0 update the record
     Session session = entityManager.unwrap(Session.class);
     session.save(city); // it is deprecated use another one
    }

    @Override
    @Transactional
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        City cityToDelete = session.get(City.class,city.getId());
        session.delete(cityToDelete);
    }

    @Override
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class, id);
        return city;
    }

    @Override
    public City findByName(String name) {
        String hql = "FROM City WHERE name = :name"; // hibernate query language HQL
        Session session = entityManager.unwrap(Session.class);
        Query<City> query = session.createQuery(hql, City.class);
        query.setParameter("name",name);

        if(query.uniqueResult() == null){
            System.out.println("there is no record named "+name);
        }
        return query.uniqueResult(); // return a single result, if no result available returns null, use getResultList
    }
}
