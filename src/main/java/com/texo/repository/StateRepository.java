package com.texo.repository;

import com.texo.DTO.StateInfo;
import com.texo.entity.City;
import com.texo.entity.State;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "states", path = "states", exported = false)
public interface StateRepository extends PagingAndSortingRepository<State, Long> {

    @Query(value = "select uf_code as ufcode, name, (select count(*) as cnt from city c where c.uf_code = s.uf_code group by c.uf_code) as numberofcities from state s where " +
            "(select count(*) as cnt from city c where c.uf_code = s.uf_code group by c.uf_code) = (select min(cnt) from (select count(*) as cnt from city c group by c.uf_code)) " +
            "or " +
            "(select count(*) as cnt from city c where c.uf_code = s.uf_code group by c.uf_code) = (select max(cnt) from (select count(*) as cnt from city c group by c.uf_code))", nativeQuery = true)
    List<StateInfo> getStatesWithMostAndLeastCities();

}