package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.employee.Address;
import fr.univparis8.iut.dut.employee.Employee;
import fr.univparis8.iut.dut.employee.EmployeeDto;
import fr.univparis8.iut.dut.employee.EmployeeEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class VacationMapper {

    public static VacationDto toVacationDto(Vacation vacation) {
        return VacationDto.VacationDtoBuilder.create()
                .withIdVac(vacation.getIdVac())
                .withDateDeb(vacation.getDate_deb())
                .withDateFin(vacation.getDate_fin())
                .withIdEmp(vacation.getIdEmp())
                .build();
    }

    public static Vacation toVacation(VacationDto vacation) {

        return Vacation.VacationBuilder.create()
                .withIdVac(vacation.getIdVac())
                .withDateDeb(vacation.getDate_deb())
                .withDateFin(vacation.getDate_fin())
                .withIdEmp(vacation.getIdEmp())
                .build();
    }

    public static Vacation toVacation(VacationEntity vacation) {
        return Vacation.VacationBuilder.create()
                .withIdVac(vacation.getIdVac())
                .withDateDeb(vacation.getDate_deb())
                .withDateFin(vacation.getDate_fin())
                .withIdEmp(vacation.getIdEmp())
                .build();
    }

    public static VacationEntity toVacation(Vacation vacation) {
        return VacationEntity.VacationEntityBuilder.create()
                .withIdVac(vacation.getIdVac())
                .withDateDeb(vacation.getDate_deb())
                .withDateFin(vacation.getDate_fin())
                .withIdEmp(vacation.getIdEmp())
                .build();
    }

    public static List<Vacation> toVacationsList(List<VacationEntity> vacationEntities) {
        return vacationEntities.stream()
                .map(VacationMapper::toVacation)
                .collect(Collectors.toList());
    }

    public static List<VacationDto> toVacationsDtoList(List<Vacation> vacation) {
        return vacation.stream()
                .map(VacationMapper::toVacationDto)
                .collect(Collectors.toList());
    }

    public static List<Vacation> toVacationsEtoList(List<VacationDto> vacationliste) {

        return vacationliste.stream()
                .map(VacationMapper::toVacation)
                .collect(Collectors.toList());
    }

    public static List<VacationEntity> toVacationsEntitytoList(List<Vacation> vacationENtityliste) {

        return vacationENtityliste.stream()
                .map(VacationMapper::toVacation)
                .collect(Collectors.toList());
    }



}