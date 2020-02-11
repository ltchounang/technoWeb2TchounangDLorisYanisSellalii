package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.common.exception.IdMismatchException;
import fr.univparis8.iut.dut.employee.Employee;
import fr.univparis8.iut.dut.employee.EmployeeDto;
import fr.univparis8.iut.dut.employee.EmployeeMapper;
import fr.univparis8.iut.dut.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/vacations")
public class VacationController {

    private final VacationService vacationService;

    @Autowired
    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping
    public List<VacationDto> getAllVacations(@RequestParam (required = false , defaultValue = "false" ) boolean trie) {

        if (trie == true) {
            return vacationService.getAllTrie();
        } else {
            return vacationService.getAll();

        }
    }

    @GetMapping("{id}")
    public VacationDto getVacation(@PathVariable Integer idVac) {
        return VacationMapper.toVacationDto(vacationService.get(idVac));
    }

    @PostMapping
    public ResponseEntity<VacationDto> createVacation(@RequestBody VacationDto vacationDto) throws URISyntaxException {

        if(vacationDto.getIdVac() != null) {
            throw new IllegalArgumentException("Vacation id should not be populated when creating and Vacation");
        }

        Vacation newVacation = vacationService.create(VacationMapper.toVacation(vacationDto));

        URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{id}")
                .buildAndExpand(newVacation.getIdVac())
                .toUri().getPath()
        );

        return ResponseEntity.created(uri).body(VacationMapper.toVacationDto(newVacation));
    }



    @PostMapping("/batch")
    public ResponseEntity<List<VacationDto>> batchCreate(@RequestBody List<VacationDto> vacationDtos) {

        List<Vacation> newLIstEmploye = vacationService.create(VacationMapper.toVacationsEtoList(vacationDtos));

        return ResponseEntity.ok(VacationMapper.toVacationsDtoList(newLIstEmploye));
    }


    @PutMapping("{id}")
    public VacationDto updateVacation(@PathVariable Long id, @RequestBody VacationDto vacationDto) {
        if(vacationDto.getIdVac() == null) {
            throw new IllegalArgumentException("Vacation id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(vacationDto.getIdVac())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        Vacation updatedVacation = vacationService.update(VacationMapper.toVacation(vacationDto));
        return VacationMapper.toVacationDto(updatedVacation);
    }

    @PatchMapping("{id}")
    public VacationDto partialUpdateVacation(@PathVariable Long id, @RequestBody VacationDto vacationDto) {
        if(vacationDto.getIdVac() == null) {
            throw new IllegalArgumentException("Vacation id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(vacationDto.getIdVac())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        Vacation updatedVacation = vacationService.partialUpdate(VacationMapper.toVacation(vacationDto));
        return VacationMapper.toVacationDto(updatedVacation);
    }

    @DeleteMapping("{id}")
    public void deleteVacation(@PathVariable Integer idVac) {
        vacationService.delete(idVac);
    }

}