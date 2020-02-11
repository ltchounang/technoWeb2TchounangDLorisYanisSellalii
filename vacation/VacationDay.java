package fr.univparis8.iut.dut.vacation;

import java.time.LocalDate;

public class VacationDay {

    private Integer idEmp ;
    private LocalDate date_day;

    public VacationDay() {

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

    public VacationDay mergeWith(VacationDay other) {
        return VacationDay.VacationDayBuilder.create()
                .withIdEmp(idEmp)
                .withDateDay(other.date_day != null ? other.date_day : date_day)
                .build();
    }

    public static final class VacationDayBuilder {

        private Integer idEmp ;
        private LocalDate date_day;

        private VacationDayBuilder() {
        }
        public static VacationDay.VacationDayBuilder create() {
            return new VacationDay.VacationDayBuilder();
        }
        public static VacationDayBuilder aVacationEntity() {
            return new VacationDayBuilder();
        }

        public VacationDayBuilder withDateDay(LocalDate date_day) {
            this.date_day = date_day;
            return this;
        }


        public VacationDayBuilder withIdEmp(Integer idEmp) {
            this.idEmp = idEmp;
            return this;
        }

        public VacationDay build() {
            VacationDay vacationEntity = new VacationDay();
            vacationEntity.setIdEmp(idEmp);
            vacationEntity.setDate_day(date_day);
            return vacationEntity;
        }
    }
}