package the.coyote.learn.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import the.coyote.learn.Exceptions.NotFound;
import the.coyote.learn.Service.StudyService;
import the.coyote.learn.entity.Study;
import the.coyote.learn.entity.form.StudyForm;

@RestController
@RequestMapping(value = "/api")
public class StudyController {

	private StudyService service;
	
	@Autowired
	public StudyController(StudyService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = "/")
	public ResponseEntity<Iterable<Study>> getAllStudy() {
		Iterable<Study> result = service.getAllStudy();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Study> findById(@PathVariable Integer id) throws NotFound{
		Study result = service.findById(id);
		return ResponseEntity.ok().body(result);
	}

	@ResponseBody
	@GetMapping(value = "/stack")
	public ResponseEntity<List<String>> findAllDistinctStack() {
		List<String> result = service.findAllDistinctStack();
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<Study> saveStudy(@RequestBody @Valid StudyForm form) {
		Study saved = service.save(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(uri).body(saved);
	}
}
