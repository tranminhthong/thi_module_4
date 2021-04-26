package com.example.thi.repository;

import com.example.thi.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICityRepo extends JpaRepository<City,Long> {
    @Query(value = "select * from thi_th_m4.cities where name like ?1",nativeQuery = true)
    Page<City> findAllCityByKey(String key, Pageable pageable);
}
