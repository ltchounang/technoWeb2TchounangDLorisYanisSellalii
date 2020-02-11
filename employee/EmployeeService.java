package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.common.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class EmployeeService {

    private static final String NOT_FOUND_MESSAGE = "Employee with id  [ %s ] not found";

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee get(Long id) {
        try {
            return EmployeeMapper.toEmployee(employeeRepository.getOne(id));
        } catch (PersistenceException ex) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
        }
    }

    public Employee create(Employee employee) {
        return EmployeeMapper.toEmployee(employeeRepository.save(EmployeeMapper.toEmployee(employee)));
    }

    public List<Employee> create(List<Employee> employees) {
        return EmployeeMapper.toEmployeesList3(employeeRepository.saveAll(EmployeeMapper.toEmployeesEntitiesList(employees)));
    }

    public List<EmployeeDto> getAll() {
        List<Employee> employees = EmployeeMapper.toEmployeesList(employeeRepository.findAll());
        return EmployeeMapper.toEmployeesDtoList(employees);
    }

    public List<EmployeeDto> getAllTrie() {
        return EmployeeMapper.toEmployeesDtoList(EmployeeMapper.toEmployeesList(employeeRepository.findAllOrderByFirstNameLastName()));
    }

    public Employee update(Employee employee) {
        if(!employeeRepository.existsById(employee.getId())) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, employee.getId()));
        }
        EmployeeEntity savedEmployee = employeeRepository.save(EmployeeMapper.toEmployee((employee)));
        return EmployeeMapper.toEmployee(savedEmployee);
    }

    public Employee partialUpdate(Employee employee) {
        if(!employeeRepository.existsById(employee.getId())) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, employee.getId()));
        }

        Employee currentEmployee = EmployeeMapper.toEmployee(employeeRepository.getOne(employee.getId()));
        Employee mergedEmployee = currentEmployee.mergeWith(employee);

        EmployeeEntity newEmployee = employeeRepository.save(EmployeeMapper.toEmployee(mergedEmployee));

        return EmployeeMapper.toEmployee(newEmployee);
    }

    public void delete(Long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }
}
