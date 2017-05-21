package com.example.gameofcode;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Mohru on 21.05.2017.
 */

public class Character extends SugarRecord {
    private String name;
    private String gender;
    private String house;
    private String culture;
    private boolean isAlive;

    public Character() {
        this.name = "";
        this.gender = "";
        this.house = "";
        this.culture = "";
        this.isAlive = false;
    }

    public Character(String name, String gender, String house, String culture, boolean isAlive) {
        this.name = name;
        this.gender = gender;
        this.house = house;
        this.culture = culture;
        this.isAlive = isAlive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", gender: " + gender + ", house: " + house + ", culture: " + culture + ", isAlive: " + isAlive;
    }

    public static List<Character> listAll() {
        return listAll(Character.class);
    }
}
