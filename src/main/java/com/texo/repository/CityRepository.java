package com.texo.repository;


import com.texo.entity.City;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities", exported = false)
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    //List<City> findByName(@Param("name") String name);

    List<City> findAll(Sort sort);

    @Query("select c from city c where c.capital = true")
    List<City> findCapitals(Sort sort);
}