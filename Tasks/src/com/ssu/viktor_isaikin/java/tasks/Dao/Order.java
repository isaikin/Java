package com.ssu.viktor_isaikin.java.tasks.Dao;

import com.ssu.viktor_isaikin.java.tasks.Common.Dish;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by isaik on 26.05.2016.
 */
public class Order implements Serializable {
    private HashMap<Integer, ArrayList<Integer>> dishs;
    private SerializeConnector connector = new SerializeConnector();

    public Order() {
        this.dishs = this.Get();
    }

    public void Add(int idEmployee, ArrayList<Integer> temp) {
        this.dishs.put(idEmployee, temp);
        try {
            connector.serializeOrder(dishs, "C:\\Users\\isaik\\OneDrive\\Documents\\Java\\Tasks\\src\\com\\ssu\\viktor_isaikin\\java\\tasks\\Dao\\Orders.txt");
        } catch (java.io.IOException exception) {
            exception.printStackTrace();
        }
    }

    public HashMap<Integer, ArrayList<Integer>> Get() {
        HashMap<Integer, ArrayList<Integer>> temp = new HashMap<Integer, ArrayList<Integer>>();
        try {
            temp = connector.deserializeOrder("C:\\Users\\isaik\\OneDrive\\Documents\\Java\\Tasks\\src\\com\\ssu\\viktor_isaikin\\java\\tasks\\Dao\\Orders.txt");
        }
        catch (java.io.IOException | java.lang.ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        return  temp;
    }

}
