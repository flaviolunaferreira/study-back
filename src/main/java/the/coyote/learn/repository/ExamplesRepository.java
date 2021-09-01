package the.coyote.learn.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import the.coyote.learn.entity.Example;

public interface ExamplesRepository extends PagingAndSortingRepository<Example, Integer>{

}
