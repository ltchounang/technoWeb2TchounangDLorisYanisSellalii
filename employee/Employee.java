package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.salary.Salary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final Long salaryAmount;
    private final List<Salary> salaries;

    public Employee(Long id, String firstName, String lastName, Address address, Long salaryAmount, List<Salary> salaries) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salaries = salaries;
        this.salaryAmount = salaryAmount;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() { return address; }

    public List<Salary> getSalaries() { return  salaries; }

    public Long getSalaryAmount() { return salaryAmount; }

    public Employee mergeWith(Employee other) {
        return EmployeeBuilder.create()
                .withId(id)
                .withLastName(other.lastName != null ? other.lastName : lastName)
                .withFirstName(other.firstName != null ? other.firstName : firstName)
                .withAddress(other.address != null ? other.address : address)
                .withSalaryAmount(other.salaryAmount != null ? other.salaryAmount : salaryAmount)
                .withSalaries(other.salaries != null ? other.salaries : salaries)
                .build();
    }

    public static final class EmployeeBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Address address;
        private List<Salary> salaries;
        private Long salaryAmount;

        private EmployeeBuilder() {
        }

        public static EmployeeBuilder create() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder withSalaries(List<Salary> salaries) {
            this.salaries = salaries;
            return this;
        }

        public EmployeeBuilder withSalaryAmount(Long salaryAmount) {
            this.salaryAmount = salaryAmount;
            return this;
        }

        public Employee build() {
            return new Employee(id, firstName, lastName, address, salaryAmount, salaries);
        }
    }
}
