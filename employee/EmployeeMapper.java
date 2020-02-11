package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.salary.Salary;
import fr.univparis8.iut.dut.salary.SalaryDto;
import fr.univparis8.iut.dut.salary.SalaryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeMapper {

    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = EmployeeDto.EmployeeDtoBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withSalaryAmount(employee.getSalaryAmount())
                .build();
        if (employee.getAddress() != null)
            employeeDto.setAddress(employee.getAddress());
        else if (employee.getSalaries() != null) {
            List<SalaryDto> salaryDtos = employee.getSalaries().stream().map(x -> SalaryDto.SalaryDtoBuilder.create()
                    .withId(x.getId())
                    .withWage(x.getWage())
                    .withNb_days(x.getNb_days())
                    .withSalary_month(x.getSalary_month())
                    .withDate_versement(x.getDate_versement())
                    .build())
                    .collect(Collectors.toList());
            employeeDto.setSalaries(salaryDtos);
        }
        return employeeDto;
    }

    public static Employee toEmployee(EmployeeDto employeeDto) {
        List<Salary> salaries;
        if (employeeDto.getSalaries() != null)  {
           salaries = employeeDto.getSalaries().stream().map(x -> Salary.SalaryBuilder.create()
                    .withId(x.getId())
                    .withWage(x.getWage())
                    .withNb_days(x.getNb_days())
                    .withSalary_month(x.getSalary_month())
                    .withDate_versement(x.getDate_versement())
                    .build())
                    .collect(Collectors.toList());
        }
        else {
            salaries = new ArrayList<>();
        }

        if (employeeDto.getAddress() == null)
            return Employee.EmployeeBuilder.create()
                    .withId(employeeDto.getId())
                    .withFirstName(employeeDto.getFirstName())
                    .withLastName(employeeDto.getLastName())
                    .withSalaryAmount(employeeDto.getSalaryAmount())
                    .withSalaries(salaries)
                    .build();
        return Employee.EmployeeBuilder.create()
                .withId(employeeDto.getId())
                .withFirstName(employeeDto.getFirstName())
                .withLastName(employeeDto.getLastName())
                .withAddress(employeeDto.getAddress())
                .withSalaryAmount(employeeDto.getSalaryAmount())
                .withSalaries(salaries)
                .build();
    }

    public static Employee toEmployee(EmployeeEntity employeeEntity) {
        List<Salary> salaries;
        if (employeeEntity.getSalaries() != null) {
            salaries = employeeEntity.getSalaries().stream().map(x -> Salary.SalaryBuilder.create()
                    .withId(x.getId())
                    .withWage(x.getWage())
                    .withNb_days(x.getNb_days())
                    .withSalary_month(x.getSalary_month())
                    .withDate_versement(x.getDate_versement())
                    .build())
                    .collect(Collectors.toList());
        }
        else
            salaries = new ArrayList<>();

        if (employeeEntity.getNum() == null && employeeEntity.getStreet() == null && employeeEntity.getPostCode() == null && employeeEntity.getCity() == null)
            return Employee.EmployeeBuilder.create()
                    .withId(employeeEntity.getId())
                    .withFirstName(employeeEntity.getFirstName())
                    .withLastName(employeeEntity.getLastName())
                    .withSalaryAmount(employeeEntity.getSalaryAmount())
                    .withSalaries(salaries)
                    .build();
        return Employee.EmployeeBuilder.create()
                    .withId(employeeEntity.getId())
                    .withFirstName(employeeEntity.getFirstName())
                    .withLastName(employeeEntity.getLastName())
                    .withAddress(new Address(employeeEntity.getNum(), employeeEntity.getStreet(), employeeEntity.getPostCode(), employeeEntity.getCity()))
                    .withSalaryAmount(employeeEntity.getSalaryAmount())
                    .withSalaries(salaries)
                    .build();
    }

    public static EmployeeEntity toEmployee(Employee employee) {
        List<SalaryEntity> salaries;
        if (employee.getSalaries() != null) {
            salaries = employee.getSalaries().stream().map(x -> SalaryEntity.SalaryEntityBuilder.create()
                    .withId(x.getId())
                    .withWage(x.getWage())
                    .withNb_days(x.getNb_days())
                    .withSalary_month(x.getSalary_month())
                    .withDate_versement(x.getDate_versement())
                    .build())
                    .collect(Collectors.toList());
        }
        else
            salaries = new ArrayList<>();

        if (employee.getAddress() == null)
            return EmployeeEntity.EmployeEntityBuilder.create()
                    .withId(employee.getId())
                    .withFirstName(employee.getFirstName())
                    .withLastName(employee.getLastName())
                    .withSalaryAmount(employee.getSalaryAmount())
                    .withSalaries(salaries)
                    .build();
        return EmployeeEntity.EmployeEntityBuilder.create()
                    .withId(employee.getId())
                    .withFirstName(employee.getFirstName())
                    .withLastName(employee.getLastName())
                    .withNum(employee.getAddress().getNum())
                    .withStreet(employee.getAddress().getStreet())
                    .withPostcode(employee.getAddress().getPostCode())
                    .withCity(employee.getAddress().getCity())
                    .withSalaries(salaries)
                    .withSalaryAmount(employee.getSalaryAmount())
                    .build();
    }

    public static List<Employee> toEmployeesList(List<EmployeeEntity> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }

    public static List<EmployeeDto> toEmployeesDtoList(List<Employee> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployeeDto)
                .collect(Collectors.toList());
    }

    public static List<Employee> toEmployeesList2(List<EmployeeDto> employeeDTOS) {
        return employeeDTOS.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }

    public static List<Employee> toEmployeesList3(List<EmployeeEntity> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }

    public static List<EmployeeEntity> toEmployeesEntitiesList(List<Employee> employee) {
        return employee.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }

}
