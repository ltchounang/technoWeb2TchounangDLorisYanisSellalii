package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.employee.Employee;

import java.time.LocalDate;

public class Salary {

    private Long id;
    private Long wage;
    private Integer nb_days;
    private String salary_month;
    private LocalDate date_versement;
    private Employee employee;

    public Salary(Long id, Long wage, Integer nb_days, String salary_month, Employee employee) {
        this.id = id;
        this.wage = wage;
        this.nb_days = nb_days;
        this.salary_month = salary_month;
        this.date_versement = LocalDate.now();
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public Long getWage() {
        return wage;
    }

    public Integer getNb_days() {
        return nb_days;
    }

    public String getSalary_month() { return salary_month; }

    public LocalDate getDate_versement() { return date_versement; }

    public Employee getEmployee() { return this.employee; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    public void setNb_days(Integer nb_days) {
        this.nb_days = nb_days;
    }

    public void setSalary_month(String salary_month) {
        this.salary_month = salary_month;
    }

    public void setDate_versement(LocalDate date_versement) {
        this.date_versement = date_versement;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Salary mergeWith(Salary other) {
        return SalaryBuilder.create()
                .withId(id)
                .withWage(other.wage != null ? other.wage : wage)
                .withNb_days(other.nb_days != null ? other.nb_days : nb_days)
                .withSalary_month(other.salary_month != null ? other.salary_month : salary_month)
                .withDate_versement(other.date_versement != null ? other.date_versement : date_versement)
                .withEmployee(other.employee != null ? other.employee : employee)
                .build();
    }

    public static final class SalaryBuilder {
        private Long id;
        private Long wage;
        private Integer nb_days;
        private String salary_month;
        private LocalDate date_versement;
        private Employee employee;

        private SalaryBuilder() {
        }

        public static SalaryBuilder create() {
            return new SalaryBuilder();
        }

        public SalaryBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SalaryBuilder withWage(Long wage) {
            this.wage = wage;
            return this;
        }

        public SalaryBuilder withNb_days(Integer nb_days) {
            this.nb_days = nb_days;
            return this;
        }

        public SalaryBuilder withSalary_month(String salary_month) {
            this.salary_month = salary_month;
            return this;
        }

        public SalaryBuilder withDate_versement(LocalDate date_versement) {
            this.date_versement = date_versement;
            return this;
        }

        public SalaryBuilder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Salary build() {
            return new Salary(id, wage, nb_days, salary_month, employee);
        }
    }
}