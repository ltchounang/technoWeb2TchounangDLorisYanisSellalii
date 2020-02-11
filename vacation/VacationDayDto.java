package fr.univparis8.iut.dut.vacation;

import java.time.LocalDate;

public class VacationDayDto {

    private Integer idEmp ;
    private LocalDate date_day;

    public VacationDayDto(Integer idEmp, LocalDate date_day) {
        this.idEmp = idEmp;
        this.date_day = date_day;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public LocalDate getDate_day() {
        return date_day;
    }

    public void setDate_day(LocalDate date_day) {
        this.date_day = date_day;
    }

    public static final class VacationDayDtoBuilder {
        private Integer idEmp ;
        private LocalDate date_day;

        private VacationDayDtoBuilder() {
        }

        public static VacationDayDtoBuilder aVacationDayDto() {
            return new VacationDayDtoBuilder();
        }

        public VacationDayDtoBuilder withIdEmp(Integer idEmp) {
            this.idEmp = idEmp;
            return this;
        }

        public VacationDayDtoBuilder withDate_day(LocalDate date_day) {
            this.date_day = date_day;
            return this;
        }

        public VacationDayDto build() {
            return new VacationDayDto(idEmp, date_day);
        }
    }
}