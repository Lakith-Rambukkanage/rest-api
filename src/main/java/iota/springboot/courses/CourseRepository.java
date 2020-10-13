package iota.springboot.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {
	//all repos would be similar

	//have custom methods
	public List<Course> findByTopicId(String topicId);

}
