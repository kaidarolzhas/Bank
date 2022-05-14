package com.company;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer id;
    private String name;
    private String surname;

    private String username;
    private String password;

    private double money;

    private String card;

    public Customer(Integer id, String username , String password, String name, String surname, double money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.money = money;
    }

    public Customer(Integer id,String username, String password, String name, String surname ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;

    }

    public Customer() {
    }





    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return id +" " + name + " " + surname + " " + username + " " + password;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}


