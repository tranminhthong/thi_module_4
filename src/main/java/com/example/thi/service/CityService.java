package com.example.thi.service;

import com.example.thi.model.City;
import com.example.thi.model.Country;
import com.example.thi.repository.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    private ICityRepo cityRepo;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepo.findAll(pageable);
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepo.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepo.save(city);
    }

    @Override
    public City delete(Long id) {
        City city = cityRepo.findById(id).get();
        cityRepo.deleteById(id);
        return city;
    }

    @Override
    public List<Country> findAllCountry() {
        TypedQuery<Country> query = em.createQuery("select c from Country c", Country.class);
        return query.getResultList();
    }

    @Override
    public Page<City> search(String key,Pageable pageable) {
        return cityRepo.findAllCityByKey("%"+key+"%",pageable);
    }
}
