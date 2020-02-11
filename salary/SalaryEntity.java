package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.employee.EmployeeEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "salary",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employee_id","salary_month"})
        })

public class SalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "wage")
    private Long wage;

    @Column(name = "nb_days")
    private int nb_days;

    @Column(name = "salary_month")
    private String salary_month;

    @Column(name = "date_versement")
    private LocalDate date_versement;

    @JoinColumn(name = "employee_id")
    @ManyToOne
    private EmployeeEntity employeeEntity;

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

    public int getNb_days() {
        return nb_days;
    }

    public void setNb_days(int nb_days) {
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

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryEntity that = (SalaryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(salary_month, that.salary_month) &&
                Objects.equals(date_versement, that.date_versement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary_month, date_versement);
    }

    public static final class SalaryEntityBuilder {
        private Long id;
        private Long wage;
        private int nb_days;
        private String salary_month;
        private LocalDate date_versement;
        private EmployeeEntity employeeEntity;

        private SalaryEntityBuilder() {
        }

        public static SalaryEntityBuilder create() {
            return new SalaryEntityBuilder();
        }

        public SalaryEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SalaryEntityBuilder withWage(Long wage) {
            this.wage = wage;
            return this;
        }

        public SalaryEntityBuilder withNb_days(int nb_days) {
            this.nb_days = nb_days;
            return this;
        }

        public SalaryEntityBuilder withSalary_month(String salary_month) {
            this.salary_month = salary_month;
            return this;
        }

        public SalaryEntityBuilder withDate_versement(LocalDate date_versement) {
            this.date_versement = date_versement;
            return this;
        }

        public SalaryEntityBuilder withEmployeeEntity(EmployeeEntity employeeEntity) {
            this.employeeEntity = employeeEntity;
            return this;
        }

        public SalaryEntity build() {
            SalaryEntity salaryEntity = new SalaryEntity();
            salaryEntity.setId(id);
            salaryEntity.setWage(wage);
            salaryEntity.setNb_days(nb_days);
            salaryEntity.setSalary_month(salary_month);
            salaryEntity.setDate_versement(date_versement);
            salaryEntity.setEmployeeEntity(employeeEntity);
            return salaryEntity;
        }
    }
}