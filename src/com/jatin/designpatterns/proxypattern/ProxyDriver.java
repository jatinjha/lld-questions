package com.jatin.designpatterns.proxypattern;

public class ProxyDriver {
    public static void main(String[] args) {
        Employee employee = new EmployeeProxy(new EmployeeImpl());
        employee.create();
    }
}
