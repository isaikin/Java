package com.ssu.viktor_isaikin.java.tasks.Common;
import java.io.Serializable;
/**
 * Created by isaik on 26.05.2016.
 */
public class Employee implements Serializable {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
