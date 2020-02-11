package fr.univparis8.iut.dut.vacation;

//package fr.univparis8.iut.dut.employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vacationDay")
public class VacationDayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "date_day")
    private LocalDate dateDay;

    @Column(name = "id_emp")
    private Integer idEmp;

    public VacationDayEntity() {
    }

    public LocalDate getDateDay() {
        return dateDay;
    }

    public void setDateDay(LocalDate dateDay) {
        this.dateDay = dateDay;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VacationDayEntity)) return false;
        VacationDayEntity that = (VacationDayEntity) o;
        return Objects.equals(idEmp, that.idEmp) &&
                dateDay.equals(that.dateDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmp, dateDay );
    }

    public static final class VacationDayEntityBuilder {
        private Integer IdEmp ;
        private  LocalDate date_day;


        private VacationDayEntityBuilder() {
        }

        public static VacationDayEntityBuilder create() {
            return new VacationDayEntityBuilder();
        }

        public VacationDayEntityBuilder withIdEmp(Integer getIdEmp) {
            this.IdEmp = getIdEmp;
            return this;
        }

        public VacationDayEntityBuilder withDateDay(LocalDate date_day) {
            this.date_day = date_day;
            return this;
        }
        public VacationDayEntity build() {
            VacationDayEntity vacationDayEntity = new VacationDayEntity();
            vacationDayEntity.setIdEmp(this.IdEmp);
            vacationDayEntity.setDateDay(this.date_day);
            return vacationDayEntity;
        }

    }



}