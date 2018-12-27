package com.user.post.service;

import com.user.post.model.User;
import com.user.post.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
@Service
public class UserService {

    /** The repository. */
    @Autowired
    UserRepository repository;
    
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    /** The kafka topic name. */
    @Value("${kafka.topic}")
    private String kafkaTopicName;

    /** The kafka bootstrap servers. */
    @Value("${kafka.bootstrap.servers}")
    private String kafkaBootstrapServers;

    /**
     * Gets the users.
     *
     * @return the users
     */
    public List<User> getUsers() {

        List<User> users = repository.findAll();

        return users;

    }

    /**
     * Post user object.
     *
     * @param user the user
     * @return the string
     */
    public String postUserObject(User user) {

        try{
        	
            kafkaTemplate.send(kafkaTopicName, user);

        }catch(Exception ex) {

            ex.printStackTrace();

            return "Failed to send the user object in topic \""+kafkaTopicName+"\"";
        }

        return "User object has been sent successfully to topic \""+kafkaTopicName+"\"";

    }


}
