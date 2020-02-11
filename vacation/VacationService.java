package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.common.exception.ObjectNotFoundException;
import fr.univparis8.iut.dut.employee.*;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class VacationService {

    private static final String NOT_FOUND_MESSAGE = "Vacation with id  [ %s ] not found";

    private final VacationRepository VacationRepository;

    public VacationService(VacationRepository VacationRepository) {
        this.VacationRepository = VacationRepository;
    }


    public Vacation get(Integer id) {
        try {
            return VacationMapper.toVacation(VacationRepository.getOne(id));
        } catch (PersistenceException ex) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
        }
    }

    public Vacation create(Vacation vacation) {
        return VacationMapper.toVacation(VacationRepository.save(VacationMapper.toVacation(vacation)));
    }

    public List<Vacation> create(List<Vacation> vacation) {
        List<VacationEntity> vacationEntities = VacationMapper.toVacationsEntitytoList(vacation);
        List<VacationEntity> vacationEntitiesResponse = VacationRepository.saveAll(vacationEntities);

        return VacationMapper.toVacationsList(vacationEntitiesResponse);
    }

    public List<VacationDto> getAll() {
        List<Vacation> vacations = VacationMapper.toVacationsList(VacationRepository.findAll());
        return VacationMapper.toVacationsDtoList(vacations);
    }

    public List<VacationDto> getAllTrie() {
        return VacationMapper.toVacationsDtoList(VacationMapper.toVacationsList(VacationRepository.findAllOrderByFirstNameDesc()));
    }


    public Vacation update(Vacation vacation) {
        if(!VacationRepository.existsById(vacation.getIdVac())) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, vacation.getIdVac()));
        }
        VacationEntity savedVacation = VacationRepository.save(VacationMapper.toVacation((vacation)));
        return VacationMapper.toVacation(savedVacation);
    }

    public Vacation partialUpdate(Vacation vacation) {
        if(!VacationRepository.existsById(vacation.getIdVac())) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, vacation.getIdVac()));
        }

        Vacation currentVacation = VacationMapper.toVacation(VacationRepository.getOne(vacation.getIdVac()));
        Vacation mergedVacation = currentVacation.mergeWith(vacation);

        VacationEntity newVacation = VacationRepository.save(VacationMapper.toVacation(mergedVacation));

        return VacationMapper.toVacation(newVacation);
    }

    public void delete(Integer id) {
        if(VacationRepository.existsById(id)) {
            VacationRepository.deleteById(id);
        }
    }
}