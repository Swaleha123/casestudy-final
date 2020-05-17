package com.cts.project.dao;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.cts.project.pojos.Exam;
public interface ExamRepository  extends CrudRepository<Exam,String> {
	Iterable<Exam> findAll();
}

