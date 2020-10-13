package iota.springboot.courses;

import iota.springboot.topic.Topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/course")
    public List<Course> getAllCourses(){
        //get converted to JSON by spring MVC
        return courseService.getAllCourses();
    }

    @RequestMapping("/topic/{id}/course")
    public List<Course> getAllCoursesByTopicId(@PathVariable String id){
        //get converted to JSON by spring MVC
        return courseService.getAllCoursesByTopicId(id);
    }

    @RequestMapping("topic/{topicId}/course/{courseId}")
    public Course getCourseById(@PathVariable String topicId, @PathVariable String courseId){
        return courseService.getCourseById(courseId);
    }

    @RequestMapping(value = "topic/{topicId}/course",method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/topic/{topicId}/course/{courseId}",method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(value = "/course/{id}",method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
