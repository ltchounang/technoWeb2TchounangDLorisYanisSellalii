package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.employee.Employee;
import fr.univparis8.iut.dut.employee.EmployeeDto;

import java.time.LocalDate;

public class SalaryDto {

    private Long id;
    private Long wage;
    private Integer nb_days;
    private String salary_month;
    private LocalDate date_versement;
    private EmployeeDto employeeDto;

    public SalaryDto() {
    }

    public SalaryDto(Long id, Long wage, Integer nb_days, String salary_month, EmployeeDto employeeDto) {
        this.id = id;
        this.wage = wage;
        this.nb_days = nb_days;
        this.salary_month = salary_month;
        this.date_versement = LocalDate.now();
        this.employeeDto = employeeDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    public Integer getNb_days() {
        return nb_days;
    }

    public void setNb_days(Integer nb_days) {
        this.nb_days = nb_days;
    }

    public String getSalary_month() {
        return salary_month;
    }

    public void setSalary_month(String salary_month) {
        this.salary_month = salary_month;
    }

    public LocalDate getDate_versement() {
        return date_versement;
    }

    public void setDate_versement(LocalDate date_versement) {
        this.date_versement = date_versement;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public static final class SalaryDtoBuilder {
        private Long id;
        private Long wage;
        private Integer nb_days;
        private String salary_month;
        private LocalDate date_versement;
        private EmployeeDto employeeDto;

        private SalaryDtoBuilder() {
        }

        public static SalaryDtoBuilder create() {
            return new SalaryDtoBuilder();
        }

        public SalaryDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SalaryDtoBuilder withWage(Long wage) {
            this.wage = wage;
            return this;
        }

        public SalaryDtoBuilder withNb_days(int nb_days) {
            this.nb_days = nb_days;
            return this;
        }

        public SalaryDtoBuilder withSalary_month(String salary_month) {
            this.salary_month = salary_month;
            return this;
        }

        public SalaryDtoBuilder withDate_versement(LocalDate date_versement) {
            this.date_versement = date_versement;
            return this;
        }

        public SalaryDtoBuilder withEmployeeDto(EmployeeDto employeeDto) {
            this.employeeDto = employeeDto;
            return this;
        }

        public SalaryDto build() {
            return new SalaryDto(id, wage, nb_days, salary_month, employeeDto);
        }
    }
}
