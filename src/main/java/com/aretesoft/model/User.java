package com.aretesoft.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Ayodeji.Agboola on 3/27/2017.
 */
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Indexed(unique=true)
    private String username;
    private String password;
    @Indexed(unique=true)
    private String email;
    private String active;
public User(String username, String password, String email,String active){
    this.setUsername(username);
    this.setPassword(password);
    this.setEmail(email);
    this.setActive(active);
}

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getActive() {
        return active;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
