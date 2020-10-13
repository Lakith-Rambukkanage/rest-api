package iota.springboot.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topic")
    public List<Topic> getAllTopics(){
        //get converted to JSON by spring MVC
        return topicService.getAllTopics();
    }

    @RequestMapping("/topic/{id}")
    public Topic getTopicById(@PathVariable String id){
        return topicService.getTopicById(id);
    }

    @RequestMapping(value = "/topic",method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        //spring takes care of the body to object conversion @RequestBody
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topic",method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic){
        topicService.updateTopic(topic);
    }

    @RequestMapping(value = "/topic/{id}",method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
