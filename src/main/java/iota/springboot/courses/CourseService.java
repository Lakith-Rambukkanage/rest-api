package iota.springboot.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;


	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll()
			.forEach(courses::add);
		return courses;
	}

	public List<Course> getAllCoursesByTopicId(String id) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(id) //spring data jpa takes care
			.forEach(courses::add);
		return courses;
	}

	public Course getCourseById(String id){
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		//instance should have the id
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
