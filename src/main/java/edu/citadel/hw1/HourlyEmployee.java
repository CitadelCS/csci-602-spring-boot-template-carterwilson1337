package edu.citadel.hw1;

import java.time.LocalDate;

public class HourlyEmployee extends Employee{
    private double wageRate;
    private double hoursWorked;
    public HourlyEmployee(String name, LocalDate hireDate, Double wageRate, Double hoursWorked){
        super(name, hireDate);
        this.wageRate = wageRate;
        this.hoursWorked = hoursWorked;

    }

    public double getWageRate() {
        return wageRate;
    }

    public void setWageRate(double wageRate) {
        this.wageRate = wageRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getMonthlyPay(){
        return this.wageRate * this.hoursWorked;
    }

    public String toString(){
        return "HourlyEmployee[name=" + this.getName() + ", hireDate=" + this.getHireDate() + ", wageRate=" + this.getWageRate() + ", hoursWorked=" + this.getHoursWorked() + "]";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
