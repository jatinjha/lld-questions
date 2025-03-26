package com.jatin.designpatterns.proxypattern;

public class EmployeeProxy implements Employee{
    private Employee employee;
    public EmployeeProxy(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void create() {
        System.out.println("done some custom validation");
        this.employee.create();
    }
}
