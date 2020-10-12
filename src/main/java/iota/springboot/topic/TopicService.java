package iota.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList (Arrays.asList(
			new Topic("Spring","Spring Framework","About Spring Framework"),
            new Topic("java","Java Lang.","About Java"),
            new Topic("js","JavaScript","About JavaScript")
            ));

	public List<Topic> getAllTopics() {
		return topics;
	}
	public Topic getTopicById(String id){
		return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for (int i=0;i<topics.size();i++){
			Topic t =topics.get(i);
			if (t.getId().equals(id)){
				topics.set(i,topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(topic -> topic.getId().equals(id));
	}
}
