package iota.springboot.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,String> {
	//getAllTopics()
	//getTopicById(String id)
	//updateTopic(String id, Topic topic)
	//addTopic(Topic topic)
	//deleteTopic(String id)

	//all repos would be similar

}
