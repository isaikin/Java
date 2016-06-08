package com.ssu.viktor_isaikin.java.tasks.Dao;

import com.ssu.viktor_isaikin.java.tasks.Common.Employee;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by isaik on 26.05.2016.
 */
public class DaoEmployee implements Serializable  {
    private HashMap<Integer, Employee> employeeDictionary;
    private SerializeConnector connector = new SerializeConnector();
    public DaoEmployee() {
      try {
            this.employeeDictionary = connector.deserializeEmployee("C:\\Users\\isaik\\OneDrive\\Documents\\Java\\Tasks\\src\\com\\ssu\\viktor_isaikin\\java\\tasks\\Dao\\Employee.txt");
      }
       catch (java.io.IOException | java.lang.ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public  boolean Add(String name)
    {
        int id = employeeDictionary.size();
        employeeDictionary.put(id,new Employee(id,name));
        this.Save();
        return  true;
    }

    public HashMap<Integer, Employee> getEmployeeDictionary() {
        return employeeDictionary;
    }

    public String GetEmploee(Integer id) {
        return this.getEmployeeDictionary().get(id).getName();
    }

    public void Save()
    {
        try {
            connector.serializeEmployee(employeeDictionary,"C:\\Users\\isaik\\OneDrive\\Documents\\Java\\Tasks\\src\\com\\ssu\\viktor_isaikin\\java\\tasks\\Dao\\Employee.txt");
        }
        catch (java.io.IOException exception) {
            exception.printStackTrace();
        }

    }
}
