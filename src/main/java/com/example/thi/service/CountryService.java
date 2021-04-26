package com.example.thi.service;

import com.example.thi.model.Country;
import com.example.thi.repository.ICountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    private ICountryRepo countryRepo;
    Iterable<Country> countries(){
       return countryRepo.findAll();
    }
}
