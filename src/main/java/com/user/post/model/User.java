package com.user.post.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Document
public class User {

    /** The object id. */
    @Id
    private String objectId;

    /** The user id. */
    private Long userId;

    /** The name. */
    private String name;

    /** The age. */
    private Long age;

    /** The place. */
    private String place;


    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the age.
     *
     * @return the age
     */
    public Long getAge() {
        return age;
    }

    /**
     * Gets the place.
     *
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * Gets the object id.
     *
     * @return the object id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the age.
     *
     * @param age the new age
     */
    public void setAge(Long age) {
        this.age = age;
    }

    /**
     * Sets the place.
     *
     * @param place the new place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Sets the object id.
     *
     * @param objectId the new object id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

}
