package com.user.post.service;

import com.user.post.constants.KafkaProperties;
import com.user.post.model.User;
import com.user.post.repository.UserRepository;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    // Kafka properties
    @Value("${kafka.topic}")
    private String kafkaTopicName;

    @Value("${kafka.bootstrap.servers}")
    private String kafkaBootstrapServers;

    public List<User> getUsers() {

        List<User> users = repository.findAll();

        return users;

    }

    public String postUserObject(User user) {

        Properties producerProperties = new Properties();
        producerProperties.put(KafkaProperties.BOOTSTRAP_SERVERS_KEY, kafkaBootstrapServers);
        producerProperties.put(KafkaProperties.BOOTSTRAP_ACKS_KEY, KafkaProperties.BOOTSTRAP_ACKS_VALUE);
        producerProperties.put(KafkaProperties.BOOTSTRAP_RETRIES_KEY, 0);
        producerProperties.put(KafkaProperties.BOOTSTRAP_BATCH_SIZE_KEY, 16384);
        producerProperties.put(KafkaProperties.BOOTSTRAP_LINGER_MS_KEY, 1);
        producerProperties.put(KafkaProperties.BOOTSTRAP_BUFFER_MEMEORY_KEY, 33554432);
        producerProperties.put(KafkaProperties.BOOTSTRAP_SERIALIZER_KEY, KafkaProperties.BOOTSTRAP_SERIALIZER_VALUE);
        producerProperties.put(KafkaProperties.BOOTSTRAP_SERIALIZER_VALUE_KEY, KafkaProperties.BOOTSTRAP_SERIALIZER_VALUE_VALUE);

        KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties);

        try{

            producer.send(new ProducerRecord<>(kafkaTopicName, user.toString()));

        }catch(Exception ex) {

            ex.printStackTrace();

            return "Failed to send the user object in topic \""+kafkaTopicName+"\"";
        }

        return "User object has been sent successfully to topic \""+kafkaTopicName+"\"";

    }


}
