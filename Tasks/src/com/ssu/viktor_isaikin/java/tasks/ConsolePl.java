package com.ssu.viktor_isaikin.java.tasks;

import com.ssu.viktor_isaikin.java.tasks.Common.Dish;
import com.ssu.viktor_isaikin.java.tasks.Common.Employee;
import com.ssu.viktor_isaikin.java.tasks.Dao.DaoEmployee;
import com.ssu.viktor_isaikin.java.tasks.Dao.Menu;
import com.ssu.viktor_isaikin.java.tasks.Dao.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Created by isaik on 26.05.2016.
 */
public class ConsolePl {
    Order orders = new Order();
    DaoEmployee employees = new DaoEmployee();
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    public static void main(String[] args) {
        ConsolePl app = new ConsolePl();

        app.Start();
    }

    public void  AddEmployee(String name)
    {
        employees.Add(name);
    }

    public void  AddDish(Integer idEmployee)
    {
        ArrayList<Integer> temporder = new ArrayList<Integer>();
        HashMap<Integer,Dish> temp = menu.getMenu();
        for (Integer item:temp.keySet()) {
            System.out.println(item.toString()+temp.get(item).toString());
        }
        while(true)
        {
            System.out.println("Для добовление блюда в заказ введите 1");
            System.out.println("Для добовление заказа введите 2");
            switch (sc.nextLine())
            {
                case "1":
                    System.out.println("Введете id блюда");
                    temporder.add(sc.nextInt());
                    break;
                case "2": {
                    orders.Add(idEmployee, temporder);
                    return;

                }

            }
        }

    }

    public void AddDish()
    {
        System.out.println("Название");
        String name = sc.nextLine();
        System.out.println("Вес");
        double wt = sc.nextDouble();
        System.out.println("Цена");
        double price = sc.nextDouble();
        menu.Add(name,wt,price);
    }

    public void PrintEmployee()
    {
        HashMap<Integer,Employee> temp = employees.getEmployeeDictionary();
        for (Integer item:temp.keySet()) {
            System.out.print(item.toString() + ' ');
            System.out.println(temp.get(item).getName().toString());
        }
    }

    public void PrintOrders()
    {
        HashMap<Integer, ArrayList<Integer>> temp = orders.Get();
        for (Integer item:temp.keySet()) {
            System.out.print(employees.GetEmploee(item).toString() + ' ');
            for (Integer i:temp.get(item)) {
                System.out.print(Menu.getDish(i));
            }
            System.out.println();
        }
    }
    public  void CountOrder(Integer id)
    {
        HashMap<Integer, ArrayList<Integer>> temp = orders.Get();
        double count = 0;

        for (Integer i:temp.get(id)) {
            count +=Menu.getDish(i).getPrice();
        }

        System.out.println("счет"+ count);
    }
    public void Start()
    {
        while(true)
        {
            System.out.println("Для создания сотрудника введите 1");
            System.out.println("Для выводв списка сторудников введите 2");
            System.out.println("Для для добавления блюда введите 3");
            System.out.println("Для добавления  заказов  введите 4");
            System.out.println("Для создания заказа  введите 5");
            System.out.println("Для подсчета заказа введите 6");
            switch (sc.nextLine())
            {
                case "1":
                    System.out.println("Введете ФИО");
                    this.AddEmployee(sc.nextLine());
                break;
                case "2":
                    this.PrintEmployee();
                    break;
                case "3":
                    this.AddDish();
                    break;
                case "4":
                    System.out.println("Введите id Работника");
                    this.AddDish(sc.nextInt());
                    break;
                case "5":
                    this.PrintOrders();
                    break;
                case "6":
                    this.CountOrder(sc.nextInt());
                    break;
            }
        }
    }
}
