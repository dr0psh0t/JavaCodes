package com.daryll.eightfeatures.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DailyCodeBufferStreams {

    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee(
                "Shabbir", "Dawoodi", 5000.0, List.of("Project 1", "Project 2")));
        employees.add(new Employee(
                "Nikhil", "Gupta", 6000.0, List.of("Project 1", "Project 3")));
        employees.add(new Employee(
                "Shivam", "Kumar", 5500.0, List.of("Project 3", "Project 4")));
    }

    public static void main(String[] args) {

        List<Employee> increasedSal = employees
                .stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toList());

        System.out.println(increasedSal);
    }

    private static class Employee {
        private String firstName;
        private String lastName;
        private Double salary;
        private List<String> projects;

        public Employee(String firstName, String lastName, Double salary, List<String> projects) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
            this.projects = projects;
        }

        public Employee() {}

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public List<String> getProjects() {
            return projects;
        }

        public void setProjects(List<String> projects) {
            this.projects = projects;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", salary=" + salary +
                    ", projects=" + projects +
                    '}';
        }
    }
}
