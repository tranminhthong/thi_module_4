package com.example.thi.service;

import com.example.thi.model.City;
import com.example.thi.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    Page<City> findAll(Pageable pageable);

    Optional<City> findById(Long id);

    void save(City city);

    City delete(Long id);

    List<Country> findAllCountry();
}
