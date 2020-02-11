package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.common.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class SalaryService {

    private static final String NOT_FOUND_MESSAGE = "Salary with id  [ %s ] not found";

    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public Salary get(Long id) {
        try {
            return SalaryMapper.toSalary(salaryRepository.getOne(id));
        } catch (PersistenceException ex) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
        }
    }

    public Salary create(Salary salary) {
        return SalaryMapper.toSalary(salaryRepository.save(SalaryMapper.toSalary(calculeSalary(salary))));
    }

    public List<Salary> create(List<Salary> employees) {
        return SalaryMapper.toSalariesList3(salaryRepository.saveAll(SalaryMapper.toSalariesEntitiesList(employees)));
    }

    public List<SalaryDto> getAll() {
        List<Salary> salaries = SalaryMapper.toSalariesList(salaryRepository.findAll());
        return SalaryMapper.toSalariesDtoList(salaries);
    }

    public Salary calculeSalary(Salary salary) {
        if (salary.getNb_days() > 20)
            return null;
        salary.setWage((salary.getEmployee().getSalaryAmount()*salary.getNb_days())/20);
        return salary;
    }

}
