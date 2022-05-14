package com.company;

import java.io.Serializable;
import java.util.Date;

public class Info implements Serializable {

    private Integer id;
    private String username;
    private String action;

    public Info(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Info(Integer id, String username, String action) {
        this.id = id;
        this.username = username;
        this.action = action;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return
                action ;

    }
}
