package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class InheritanceDemo {
    public static void main(String[] args){
        ArrayList<Employee> a = new ArrayList<Employee>();
        HourlyEmployee e1 = new HourlyEmployee("John Doe", LocalDate.of(2009,5,21),50.5,160.0);
        HourlyEmployee e2 = new HourlyEmployee("Jane Doe", LocalDate.of(2005,9,1),150.5,80.0);
        a.add(e1);
        a.add(e2);
        SalariedEmployee e3 = new SalariedEmployee("Moe Howard", LocalDate.of(2004,1,1),75000.0);
        SalariedEmployee e4 = new SalariedEmployee("Curly Howard", LocalDate.of(2018,1,1),105000.0);
        a.add(e3);
        a.add(e4);

        //Before sort
        System.out.println("List of Employees (before sorting)");
        for(Employee e : a){
            System.out.println(e);
        }
        System.out.println();


        //Sort
        Collections.sort(a);


        //After sort
        System.out.println("List of Employees (after sorting)");
        for(Employee e : a){
            System.out.println(e);
        }
        System.out.println();


        //Monthly pay
        double totalPay = 0.0;
        System.out.println("Monthly Pay");
        for(Employee employee: a){
            System.out.printf("%s: $%,.2f\n", employee.getName(), employee.getMonthlyPay());
            totalPay += employee.getMonthlyPay();
        }


        System.out.printf("Total Monthly Pay: $%,.2f", totalPay);
    }

}
