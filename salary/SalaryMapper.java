package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.employee.EmployeeMapper;
import fr.univparis8.iut.dut.employee.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SalaryMapper {

    public static SalaryDto toSalaryDto(Salary salary) {
        if (salary.getEmployee().getId() != null)
            return SalaryDto.SalaryDtoBuilder.create()
                    .withId(salary.getId())
                    .withWage(salary.getWage())
                    .withNb_days(salary.getNb_days())
                    .withSalary_month(salary.getSalary_month())
                    .withDate_versement(salary.getDate_versement())
                    .withEmployeeDto(EmployeeMapper.toEmployeeDto(salary.getEmployee()))
                    .build();
        return null;
    }

    public static Salary toSalary(SalaryDto salary) {
        if (salary.getEmployeeDto().getId() != null)
            return Salary.SalaryBuilder.create()
                .withId(salary.getId())
                .withWage(salary.getWage())
                .withNb_days(salary.getNb_days())
                .withSalary_month(salary.getSalary_month())
                .withDate_versement(salary.getDate_versement())
                .withEmployee(EmployeeMapper.toEmployee(salary.getEmployeeDto()))
                .build();
        return null;
    }

    public static Salary toSalary(SalaryEntity salary) {
        if (salary.getEmployeeEntity() != null)
        return Salary.SalaryBuilder.create()
                .withId(salary.getId())
                .withWage(salary.getWage())
                .withNb_days(salary.getNb_days())
                .withSalary_month(salary.getSalary_month())
                .withDate_versement(salary.getDate_versement())
                .withEmployee(EmployeeMapper.toEmployee(salary.getEmployeeEntity()))
                .build();
        return null;
    }

    public static SalaryEntity toSalary(Salary salary) {
        if (salary.getEmployee().getId() != null)
        return SalaryEntity.SalaryEntityBuilder.create()
                .withId(salary.getId())
                .withWage(salary.getWage())
                .withNb_days(salary.getNb_days())
                .withSalary_month(salary.getSalary_month())
                .withDate_versement(salary.getDate_versement())
                .withEmployeeEntity(EmployeeMapper.toEmployee(salary.getEmployee()))
                .build();
        return null;
    }

    public static List<Salary> toSalariesList(List<SalaryEntity> salaryEntities) {
        if (!salaryEntities.isEmpty())
            return salaryEntities.stream()
                    .map(SalaryMapper::toSalary)
                    .collect(Collectors.toList());
        return new ArrayList<>();
    }

    public static List<SalaryDto> toSalariesDtoList(List<Salary> salaryEntities) {
        if (!salaryEntities.isEmpty())
            return salaryEntities.stream()
                    .map(SalaryMapper::toSalaryDto)
                    .collect(Collectors.toList());
        return new ArrayList<>();
    }

    public static List<Salary> toSalariesList2(List<SalaryDto> salaryDTOS) {
        if (!salaryDTOS.isEmpty())
            return salaryDTOS.stream()
                    .map(SalaryMapper::toSalary)
                    .collect(Collectors.toList());
        return new ArrayList<>();
    }

    public static List<Salary> toSalariesList3(List<SalaryEntity> salaryEntities) {
        if (!salaryEntities.isEmpty())
            return salaryEntities.stream()
                    .map(SalaryMapper::toSalary)
                    .collect(Collectors.toList());
        return new ArrayList<>();
    }

    public static List<SalaryEntity> toSalariesEntitiesList(List<Salary> salary) {
        if (!salary.isEmpty())
            return salary.stream()
                    .map(SalaryMapper::toSalary)
                    .collect(Collectors.toList());
        return new ArrayList<>();
    }
}
