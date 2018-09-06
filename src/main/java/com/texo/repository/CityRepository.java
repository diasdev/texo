package com.texo.repository;


import com.texo.entity.City;
import com.texo.specification.CitySpecification;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities", exported = false)
public interface CityRepository extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor<City> {

    @Query("select c from city c where (:ufcode is null or :ufcode = '' or c.state.code = :ufcode)")
    List<City> findAll(@Param("ufcode") String ufcode);

    City findById(long id);

    //@Query("select c from city c where c.state.code = ?1")
    //List<City> findByState(String UFCode);

    @Query("select c from city c where c.capital = true")
    List<City> findCapitals(Sort sort);
}