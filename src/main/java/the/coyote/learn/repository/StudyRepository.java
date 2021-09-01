package the.coyote.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import the.coyote.learn.entity.Study;

public interface StudyRepository extends PagingAndSortingRepository<Study, Integer>, JpaRepository<Study, Integer> {

	@Query(value = "SELECT DISTINCT stack FROM study ORDER BY stack ASC", nativeQuery = true)
	List<String> findAllDistinctStack();


}
