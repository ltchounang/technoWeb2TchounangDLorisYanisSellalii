package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.salary.SalaryDto;

import java.util.List;

public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Address address;

    private Long salaryAmount;

    private List<SalaryDto> salaries;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String firstName, String lastName, Address address, Long salaryAmount, List<SalaryDto> salaryDtos) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salaries = salaryDtos;
        this.salaryAmount = salaryAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<SalaryDto> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<SalaryDto> salaries) {
        this.salaries = salaries;
    }

    public Long getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(Long salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public static final class EmployeeDtoBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Address address;
        private Long salaryAmount;
        private List<SalaryDto> salaries;

        private EmployeeDtoBuilder() {
        }

        public static EmployeeDtoBuilder create() {
            return new EmployeeDtoBuilder();
        }

        public EmployeeDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeDtoBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeDtoBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeDtoBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public EmployeeDtoBuilder withSalaryDtos(List<SalaryDto> salaryDtos) {
            this.salaries = salaryDtos;
            return this;
        }

        public EmployeeDtoBuilder withSalaryAmount(Long salaryAmount) {
            this.salaryAmount = salaryAmount;
            return this;
        }

        public EmployeeDto build() {
            return new EmployeeDto(id, firstName, lastName, address, salaryAmount, salaries);
        }
    }
}
