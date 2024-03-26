package com.festus.week8.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends  CrudRepository<SchoolEntity, Long> {

}
