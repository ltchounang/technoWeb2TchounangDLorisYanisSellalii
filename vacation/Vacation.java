package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.employee.Employee;

import java.time.LocalDate;
import java.util.List;

public class Vacation {

    private Integer idVac ;
    private  LocalDate date_deb;
    private  LocalDate date_fin;
    private  Integer idEmp;
    private List<VacationDay> jourDeVacance;
    public Vacation() {

    }

    public Integer getIdVac() {
        return idVac;
    }

    public List<VacationDay> getJourDeVacance() {
        return jourDeVacance;
    }

    public void setJourDeVacance(List<VacationDay> jourDeVacance) {
        this.jourDeVacance = jourDeVacance;
    }

    public void setIdVac(Integer idVac) {
        this.idVac = idVac;
    }

    public LocalDate getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(LocalDate date_deb) {
        this.date_deb = date_deb;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public Vacation mergeWith(Vacation other) {
        return Vacation.VacationBuilder.create()
                .withIdVac(idVac)
                .withDateDeb(other.date_deb != null ? other.date_deb : date_deb)
                .withDateFin(other.date_fin != null ? other.date_fin : date_fin)
                .withIdEmp(other.idEmp != null ? other.idEmp : idEmp)
                .build();
    }

    public static final class VacationBuilder {

        private Integer idVac ;
        private LocalDate date_deb;
        private  LocalDate date_fin;
        private Integer idEmp;
        private List<VacationDay> jourDeVacance;

        private VacationBuilder() {
        }
        public static Vacation.VacationBuilder create() {
            return new Vacation.VacationBuilder();
        }
        public static VacationBuilder VacationEntity() {
            return new VacationBuilder();
        }

        public VacationBuilder withIdVac(Integer idVac) {
            this.idVac = idVac;
            return this;
        }

        public VacationBuilder withDateDeb(LocalDate date_deb) {
            this.date_deb = date_deb;
            return this;
        }

        public VacationBuilder withDateFin(LocalDate date_fin) {
            this.date_fin = date_fin;
            return this;
        }

        public VacationBuilder withIdEmp(Integer idEmp) {
            this.idEmp = idEmp;
            return this;
        }

        public VacationBuilder withJourDeVacance(List<VacationDay> jourDeVacance) {
            this.jourDeVacance = jourDeVacance;
            return this;
        }
        public Vacation build() {
            Vacation vacationEntity = new Vacation();
            vacationEntity.setIdVac(idVac);
            vacationEntity.setDate_deb(date_deb);
            vacationEntity.setDate_fin(date_fin);
            vacationEntity.setIdEmp(idEmp);
            vacationEntity.setJourDeVacance(jourDeVacance);
            return vacationEntity;
        }
    }
}