package com.example.thi.repository;

import com.example.thi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepo extends JpaRepository<Country,Long> {
}
