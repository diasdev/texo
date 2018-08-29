package com.texo.repository;

import com.texo.entity.State;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "states", path = "states", exported = false)
public interface StateRepository extends PagingAndSortingRepository<State, Long> {

}