package com.example.thi.repository;

import com.example.thi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepo extends JpaRepository<City,Long> {
}
