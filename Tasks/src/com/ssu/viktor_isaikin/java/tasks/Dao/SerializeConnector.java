package com.ssu.viktor_isaikin.java.tasks.Dao;
import com.ssu.viktor_isaikin.java.tasks.Common.Dish;
import com.ssu.viktor_isaikin.java.tasks.Common.Employee;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by isaik on 26.05.2016.
 */
public class SerializeConnector {

    public void serializeEmployee(HashMap<Integer, Employee> person, String fileName)
            throws java.io.IOException {
        try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(person);
        }
    }

    public HashMap<Integer, Employee> deserializeEmployee(String fileName) throws IOException, ClassNotFoundException {

        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            HashMap<Integer, Employee> person = (HashMap<Integer, Employee>) ois.readObject();
            if(person == null)
                return new HashMap<Integer, Employee>();

            return person;
        }
    }

    public void serializeOrder(HashMap<Integer, ArrayList<Integer>> person, String fileName)
            throws java.io.IOException {
        File f = new File(fileName);
        try(FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(person);
            oos.close();
        }
    }

    public HashMap<Integer,ArrayList<Integer>> deserializeOrder(String fileName) throws IOException, ClassNotFoundException {
        File f = new File(fileName);
        try(FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            HashMap<Integer, ArrayList<Integer>> person = (HashMap<Integer,ArrayList<Integer>>) ois.readObject();
            if(person == null)
                return new HashMap<Integer,ArrayList<Integer>>();
            return person;
        }
    }

    public void serializeDish(HashMap<Integer,Dish> person, String fileName)
            throws java.io.IOException {
        File f = new File(fileName);
        try(FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(person);
            oos.close();
        }
    }

    public HashMap<Integer,Dish> deserializeDish(String fileName) throws IOException, ClassNotFoundException {
        File f = new File(fileName);
        try(FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            HashMap<Integer,Dish> person = (HashMap<Integer,Dish>) ois.readObject();
            if(person == null)
                return new HashMap<Integer,Dish>();
            return person;
        }
    }

}

