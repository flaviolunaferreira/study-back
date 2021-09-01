package the.coyote.learn.Service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.coyote.learn.Exceptions.NotFound;
import the.coyote.learn.Service.StudyService;
import the.coyote.learn.entity.Study;
import the.coyote.learn.entity.form.StudyForm;
import the.coyote.learn.repository.StudyRepository;

@Service


public class StudyServiceImpl implements StudyService{

	private StudyRepository repository;
	
	@Autowired
	public StudyServiceImpl(StudyRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Iterable<Study> getAllStudy() {
		Iterable<Study> result = repository.findAll();
		return result;
	}

	@Override
	public Study findById(Integer id) throws NotFound {
		Optional<Study> result = repository.findById(id);
		return result.orElseThrow(() -> new NotFound("Sorry but, couldn`t find the item study with the id " + id));
	}

	@Override
	public List<String> findAllDistinctStack() {
		List<String> result = repository.findAllDistinctStack();
		return result;
	}

	@Override
	public Study save(@Valid StudyForm form) {
		Study result = form.newStudy();
		result.setCreatedAt(LocalDate.now());
		return repository.save(result);
	}

		
}
