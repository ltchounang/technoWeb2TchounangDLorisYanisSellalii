package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.salary.Salary;
import fr.univparis8.iut.dut.salary.SalaryEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name = "employee")

public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "number")
    private Integer num;

    @Column(name = "street")
    private String street;

    @Column(name = "postcode")
    private Long postcode;

    @Column(name = "city")
    private String city;

    @Column(name = "salary_amount")
    private Long salaryAmount;

    @OneToMany(mappedBy = "employeeEntity")
    private List<SalaryEntity> salaries;

    public EmployeeEntity() {
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

    public Integer getNum() { return num; }

    public void setNum(Integer num) { this.num = num; }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) { this.street = street; }

    public Long getPostCode() {
        return postcode;
    }

    public void setPostcode(Long postcode) { this.postcode = postcode; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) { this.city = city; }

    public List<SalaryEntity> getSalaries() { return this.salaries; }

    public void setSalaries(List<SalaryEntity> salaries) { this.salaries = salaries; }

    public Long getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(Long salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return num == that.num &&
                postcode == that.postcode &&
                Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(salaries, that.salaries) &&
                Objects.equals(salaryAmount, that.salaryAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, num, street, postcode, city, salaries);
    }

    public static final class EmployeEntityBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Integer num;
        private String street;
        private Long postcode;
        private String city;
        private Long salaryAmount;
        private List<SalaryEntity> salaries;

        private EmployeEntityBuilder() {
        }

        public static EmployeEntityBuilder create() {
            return new EmployeEntityBuilder();
        }

        public EmployeEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeEntityBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeEntityBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeEntityBuilder withNum(Integer num) {
            this.num = num;
            return this;
        }

        public EmployeEntityBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public EmployeEntityBuilder withPostcode(Long postcode) {
            this.postcode = postcode;
            return this;
        }

        public EmployeEntityBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public EmployeEntityBuilder withSalaries(List<SalaryEntity> salaries) {
            this.salaries = salaries;
            return this;
        }

        public EmployeEntityBuilder withSalaryAmount(Long salaryAmount) {
            this.salaryAmount = salaryAmount;
            return this;
        }

        public EmployeeEntity build() {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setId(id);
            employeeEntity.setFirstName(firstName);
            employeeEntity.setLastName(lastName);
            employeeEntity.setNum(num);
            employeeEntity.setStreet(street);
            employeeEntity.setPostcode(postcode);
            employeeEntity.setCity(city);
            employeeEntity.setSalaries(salaries);
            employeeEntity.setSalaryAmount(salaryAmount);
            return employeeEntity;
        }
    }
}
