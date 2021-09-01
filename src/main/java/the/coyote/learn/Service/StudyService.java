package the.coyote.learn.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import the.coyote.learn.Exceptions.NotFound;
import the.coyote.learn.entity.Study;
import the.coyote.learn.entity.form.StudyForm;

@Service
public interface StudyService {

	Iterable<Study> getAllStudy();

	Study findById(Integer id) throws NotFound;

	List<String> findAllDistinctStack();

	Study save(@Valid StudyForm form);


}
