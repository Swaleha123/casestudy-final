package com.cts.project.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.dao.ExamRepository;
import com.cts.project.pojos.Exam;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/Exam")
public class ExamController {
	@Autowired

	private ExamRepository examRepository;

	@RequestMapping("/getAllExam")

	public Iterable<Exam> getAllExam() {

		return examRepository.findAll();

	}

	@PostMapping("/saveMockquiz")

	public Exam saveExam(@RequestBody Exam exam) {

		System.out.println(exam);

		examRepository.save(exam);

		return exam;

	}

	@PutMapping("/updateExam/{testid}")

	public Exam updateMockquiz(@RequestBody Exam exam,
			@PathVariable("testid") String testid) {

		exam.setTestid(testid);

		System.out.println(exam);

		examRepository.save(exam);

		return exam;

	}

	@DeleteMapping("/deleteExam/{testid}")

	public Boolean deleteExam(@PathVariable("testid") String testid) {

		System.out.println(testid);

		Optional<Exam> exam = examRepository.findById(testid);
		examRepository.delete(exam.get());

		return true;

	}

	@GetMapping("/findOneInAll5/{testid}")

	public Exam findOneInAll5(@PathVariable("testid") String testid) {

		Optional<Exam> exam = examRepository.findById(testid);

		return exam.get();

	}
}
