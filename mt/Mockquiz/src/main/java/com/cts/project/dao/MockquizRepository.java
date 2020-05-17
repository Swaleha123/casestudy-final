package com.cts.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.cts.project.pojos.Mockquiz;
public interface MockquizRepository extends CrudRepository<Mockquiz,Integer> {
	List<Mockquiz> findAll();
}
