package edu.citadel.hw1;

import java.time.LocalDate;

public class SalariedEmployee extends Employee{
    private double annualSalary;
    public SalariedEmployee(String name, LocalDate hireDate, double annualSalary){
        super(name, hireDate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double getMonthlyPay() {
        return this.annualSalary/12.0;
    }

    public String toString(){
        return "SalariedEmployee[name=" + this.getName() + ", hireDate=" + this.getHireDate() + ", annualSalary=" + this.getAnnualSalary() + "]";
    }
}
