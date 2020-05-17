package com.cts.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.client.RestTemplate;

import com.cts.project.config.ServiceConfig;
import com.cts.project.model.Answers;
import com.cts.project.model.Assessment;
import com.cts.project.model.Mockquiz;
import com.cts.project.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.EurekaClient;
@RestController
@RequestMapping("/mockquiz")
@CrossOrigin(origins="http://localhost:4200")
public class MockquizController {
	@Autowired
	RestTemplate restTemplate;
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	ServiceConfig configuration;

	private Mockquiz mockquiz;
	
	@RequestMapping("/getAllMockquiz")

	public List<Mockquiz> getAllMockquiz() {
		List<Mockquiz> list = new ArrayList<Mockquiz>();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		list = restTemplate.exchange("http://localhost:9099/Mockquiz/getAllMockquiz",
              HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Mockquiz>>() { }).getBody();
		return list;
	}
	
	//@RequestMapping("/saveMockquiz")
	//@RequestMapping(value = "/saveMockquiz", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/saveMockquiz", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Mockquiz> saveMockquiz1(@RequestBody Mockquiz mockquiz) {

		HttpHeaders header = new HttpHeaders();
		//header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<Mockquiz> requestEntity = new HttpEntity<>(mockquiz,header);
		ResponseEntity<Mockquiz> mockquiz1 = restTemplate.exchange("http://localhost:9099/Mockquiz/saveMockquiz",
              HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Mockquiz>() { });
		return mockquiz1;

	}

	@PostMapping("/saveAnswers")

	public ResponseEntity<String> saveAnswers(@RequestBody String answers) {
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		System.out.println(answers);

		    return ResponseEntity.ok(answers);
		

	}

	@PutMapping("/updateMockquiz/{qid}")

	public Mockquiz updateMockquiz(@RequestBody Mockquiz mockquiz,
			@PathVariable("qid") Integer qid) {

		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		mockquiz = restTemplate.exchange("http://localhost:9099/Mockquiz/updateMockquiz",
              HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<Mockquiz>() { }).getBody();
		return mockquiz;

	}
	

	@DeleteMapping("/deleteMockquiz/{qid}")

	public Boolean deleteMockquiz(@PathVariable("qid") Integer qid) {

		 HttpHeaders header = new HttpHeaders();
			header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
			HttpEntity<String> requestEntity = new HttpEntity<String>( header);
			mockquiz = restTemplate.exchange("http://localhost:9099/Mockquiz/deleteMockquiz",
	              HttpMethod.DELETE, requestEntity, new ParameterizedTypeReference<Mockquiz>() { }).getBody();
		return true;
	}

	@GetMapping("/getAllEasy") 
	public List<Mockquiz> easyLevel()
	{
		List<Mockquiz> list = new ArrayList<Mockquiz>();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		list = restTemplate.exchange("http://localhost:9099/Mockquiz/getAllMockquiz",
              HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Mockquiz>>() { }).getBody();
	   list = list.stream().filter(e->"easy".equals(e.getDifficulty())).collect(Collectors.toList());
		return list;
	} 
	@GetMapping("/getAllMedium") 
	public List<Mockquiz> mediumLevel()
	{
		List<Mockquiz> list = new ArrayList<Mockquiz>();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		list = restTemplate.exchange("http://localhost:9099/Mockquiz/getAllMockquiz",
              HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Mockquiz>>() { }).getBody();
	   list = list.stream().filter(e->"medium".equals(e.getDifficulty())).collect(Collectors.toList());
		return list;
	}
	@GetMapping("/getAllExpert") 
	public List<Mockquiz> expertLevel()
	{
		List<Mockquiz> list = new ArrayList<Mockquiz>();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		list = restTemplate.exchange("http://localhost:9099/Mockquiz/getAllMockquiz",
              HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Mockquiz>>() { }).getBody();
	   list = list.stream().filter(e->"expert".equals(e.getDifficulty())).collect(Collectors.toList());
		return list;
	}
	
	@GetMapping("/easy")
	public ArrayList<Assessment> easy(){
		List<Mockquiz> list = new ArrayList<Mockquiz>();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		list = restTemplate.exchange("http://localhost:9099/Mockquiz/getAllMockquiz",
              HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Mockquiz>>() { }).getBody();
	   list = list.stream().filter(e->"easy".equals(e.getDifficulty())).collect(Collectors.toList());
	   ArrayList<Assessment> ms1list=new ArrayList<>();
		 for(int i=0;i<10;i++)
		 {
			 RandomDataGenerator a=new RandomDataGenerator();
			 int x=a.nextInt(1,10);
			 Mockquiz mq=list.get(x);
			 Assessment pojo=new Assessment();
			 ObjectMapper mapper = new ObjectMapper();
			 Map<String, String> mqmap = mapper.convertValue(mq, new TypeReference<Map<String, String>>(){});
			 pojo.setQid(mqmap.get("qid"));
			 pojo.setQuestion(mqmap.get("question"));
			 pojo.setDifficulty(mqmap.get("difficulty"));
			 List li=new ArrayList<String>();
			 li.add(mqmap.get("answer"));
			 for(int j=0;j<3;j++)
			 {
				 RandomDataGenerator b=new RandomDataGenerator();
				 int y=b.nextInt(1,7);
				 li.add((mqmap).get("op"+y));
				 
			 }
			 Collections.shuffle(li);
			 pojo.setOptions(li);
			 ms1list.add(pojo);
			System.out.println(ms1list);
			
		 }
			return ms1list;
		}
		
	
	@GetMapping("/medium")
	public ArrayList<Assessment> medium(){
		List<Mockquiz> list = new ArrayList<Mockquiz>();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		list = restTemplate.exchange("http://localhost:9099/Mockquiz/getAllMockquiz",
              HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Mockquiz>>() { }).getBody();
	   list = list.stream().filter(e->"medium".equals(e.getDifficulty())).collect(Collectors.toList());
	   ArrayList<Assessment> ms1list=new ArrayList<>();
		 for(int i=0;i<10;i++)
		 {
			 RandomDataGenerator a=new RandomDataGenerator();
			 int x=a.nextInt(1,10);
			 Mockquiz mq=list.get(x);
			 Assessment pojo=new Assessment();
			 ObjectMapper mapper = new ObjectMapper();
			 Map<String, String> mqmap = mapper.convertValue(mq, new TypeReference<Map<String, String>>(){});
			 pojo.setQid(mqmap.get("qid"));
			 pojo.setQuestion(mqmap.get("question"));
			 pojo.setDifficulty(mqmap.get("difficulty"));
			 List li=new ArrayList<String>();
			 li.add(mqmap.get("answer"));
			 for(int j=0;j<3;j++)
			 {
				 RandomDataGenerator b=new RandomDataGenerator();
				 int y=b.nextInt(1,7);
				 li.add((mqmap).get("op"+y));
				 
			 }
			 Collections.shuffle(li);
			 pojo.setOptions(li);
			 ms1list.add(pojo);
			System.out.println(ms1list);
			
		 }
			return ms1list;
		}
	@GetMapping("/expert")
	public ArrayList<Assessment> expert(){
		List<Mockquiz> list = new ArrayList<Mockquiz>();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		list = restTemplate.exchange("http://localhost:9099/Mockquiz/getAllMockquiz",
              HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Mockquiz>>() { }).getBody();
	   list = list.stream().filter(e->"expert".equals(e.getDifficulty())).collect(Collectors.toList());
	 ArrayList<Assessment> ms1list=new ArrayList<>();
	 for(int i=0;i<10;i++)
	 {
		 RandomDataGenerator a=new RandomDataGenerator();
		 int x=a.nextInt(1,10);
		 Mockquiz mq=list.get(x);
		 Assessment pojo=new Assessment();
		 ObjectMapper mapper = new ObjectMapper();
		 Map<String, String> mqmap = mapper.convertValue(mq, new TypeReference<Map<String, String>>(){});
		 pojo.setQid(mqmap.get("qid"));
		 pojo.setQuestion(mqmap.get("question"));
		 pojo.setDifficulty(mqmap.get("difficulty"));
		 List li=new ArrayList<String>();
		 li.add(mqmap.get("answer"));
		 for(int j=0;j<3;j++)
		 {
			 RandomDataGenerator b=new RandomDataGenerator();
			 int y=b.nextInt(1,7);
			 li.add((mqmap).get("op"+y));
			 
		 }
		 Collections.shuffle(li);
		 pojo.setOptions(li);
		 ms1list.add(pojo);
		System.out.println(ms1list);
		
	 }
		return ms1list;
	}
	
}
