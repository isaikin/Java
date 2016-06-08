package com.ssu.viktor_isaikin.java.tasks.Dao;

import com.ssu.viktor_isaikin.java.tasks.Common.Dish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by isaik on 27.05.2016.
 */
public class Menu implements Serializable {
    private static HashMap<Integer,Dish> menu;
    private SerializeConnector connector = new SerializeConnector();

    public Menu() {
        try {
            menu = connector.deserializeDish("C:\\Users\\isaik\\OneDrive\\Documents\\Java\\Tasks\\src\\com\\ssu\\viktor_isaikin\\java\\tasks\\Dao\\Menu.txt");
        }
        catch (java.io.IOException | java.lang.ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public void  Add(String name, double wt, double price)
    {   Dish item = new Dish(wt,name,price);
        menu.put(menu.size(),item);

        try {
            connector.serializeDish(menu,"C:\\Users\\isaik\\OneDrive\\Documents\\Java\\Tasks\\src\\com\\ssu\\viktor_isaikin\\java\\tasks\\Dao\\Menu.txt");
        }
        catch (java.io.IOException exception) {
            exception.printStackTrace();
        }
    }

    public HashMap<Integer,Dish> getMenu() {
        return menu;
    }

    public static Dish getDish(Integer id)
    {
        return menu.get(id);
    }
}
