package the.coyote.learn.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import the.coyote.learn.entity.Videos;

public interface VideosRepository extends PagingAndSortingRepository<Videos, Integer>{

}
