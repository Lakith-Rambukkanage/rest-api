package iota.springboot.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topic")
    public List<Topic> getAllTopics(){
        //get converted to JSON by spring MVC
        return Arrays.asList(
                new Topic("Spring","Spring Framework","About Spring Framework"),
                new Topic("java","Java Lang.","About Java"),
                new Topic("js","JavaScript","About JS")
        );
    }

}
