package edu.citadel.hw1;



import java.time.LocalDate;

public abstract class Employee implements Comparable<Employee>{


    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate){
        this.name = name;
        this.hireDate = hireDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public abstract double getMonthlyPay();

    public int compareTo(Employee emp2){

        return Double.compare(this.getMonthlyPay(), emp2.getMonthlyPay());
    }

}
