package com.cts.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.dao.MockquizRepository;
import com.cts.project.pojos.Mockquiz;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/Mockquiz")
public class MockquizController {
	@Autowired

	private MockquizRepository mockquizRepository;

	@RequestMapping("/getAllMockquiz")

	public List<Mockquiz> getAllMockquiz() {

		return mockquizRepository.findAll();

	}
	
	//@PostMapping("/saveMockquiz")
	//@RequestMapping(value = "/saveMockquiz", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/saveMockquiz", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
	public Mockquiz saveMockquiz(@RequestBody Mockquiz mockquiz) {

		System.out.println(mockquiz);

		mockquizRepository.save(mockquiz);

		return mockquiz;

	}

	@PutMapping("/updateMockquiz/{qid}")

	public Mockquiz updateMockquiz(@RequestBody Mockquiz mockquiz,
			@PathVariable("qid") Integer qid) {

		mockquiz.setQid(qid);

		System.out.println(mockquiz);

		mockquizRepository.save(mockquiz);

		return mockquiz;

	}

	@DeleteMapping("/deleteMockquiz/{qid}")

	public Boolean deleteMockquiz(@PathVariable("qid") Integer qid) {

		System.out.println(qid);

		Optional<Mockquiz> mockquiz = mockquizRepository.findById(qid);
		mockquizRepository.delete(mockquiz.get());

		return true;

	}

	@GetMapping("/findOneInAll4/{qid}")

	public Mockquiz findOneInAll4(@PathVariable("qid") Integer qid) {

		Optional<Mockquiz> mockquiz = mockquizRepository.findById(qid);

		return mockquiz.get();

	}
}
