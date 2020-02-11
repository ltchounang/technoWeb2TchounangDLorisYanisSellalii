package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.common.exception.IdMismatchException;
import fr.univparis8.iut.dut.employee.EmployeeMapper;
import fr.univparis8.iut.dut.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/salaries")
public class SalaryController {


    private final SalaryService salaryService;
    private final EmployeeService employeeService;

    @Autowired
    public SalaryController(SalaryService salaryService, EmployeeService employeeService) {
        this.salaryService = salaryService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<SalaryDto> getAllSalaries() {
        return salaryService.getAll();
    }

    @GetMapping("{id}")
    public SalaryDto getSalary(@PathVariable Long id) {
        return SalaryMapper.toSalaryDto(salaryService.get(id));
    }

    @PostMapping
    public ResponseEntity<SalaryDto> createSalary(@RequestBody SalaryDto salaryDto) throws URISyntaxException {

        if(salaryDto.getId() != null) {
            throw new IllegalArgumentException("Salary id should not be populated when creating and employee");
        }
        salaryDto.setEmployeeDto(EmployeeMapper.toEmployeeDto(this.employeeService.get(salaryDto.getEmployeeDto().getId())));
        Salary newSalary = salaryService.create(SalaryMapper.toSalary(salaryDto));

        URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{id}")
                .buildAndExpand(newSalary.getId())
                .toUri().getPath()
        );

        return ResponseEntity.created(uri).body(SalaryMapper.toSalaryDto(newSalary));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<SalaryDto>> batchCreate(@RequestBody List<SalaryDto> employeeDtos) {
        List <Salary> employees = salaryService.create(SalaryMapper.toSalariesList2(employeeDtos));
        return ResponseEntity.ok(SalaryMapper.toSalariesDtoList(employees));
    }

}


