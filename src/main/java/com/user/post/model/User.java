package com.user.post.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String objectId;

    private Long userId;

    private String name;

    private Long age;

    private String place;


    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getPlace() {
        return place;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", place='" + place + '\'' +
                '}';
    }
}
