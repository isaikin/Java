package com.ssu.viktor_isaikin.java.tasks.Common;

import java.io.Serializable;

/**
 * Created by isaik on 26.05.2016.
 */
public class Dish implements Serializable {
    private double wt;
    private  String name;
    private double price;

    @Override
    public String toString() {
        return "Dish{" +
                "wt=" + wt +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Dish(double wt, String name, double price) {
        this.wt = wt;
        this.name = name;
        this.price = price;
    }

    public double getWt() {
        return wt;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
