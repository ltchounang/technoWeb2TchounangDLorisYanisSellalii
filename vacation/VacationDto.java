package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.employee.Address;
import fr.univparis8.iut.dut.employee.Employee;

import java.time.LocalDate;
import java.util.List;

public class VacationDto {

    private Integer idVac ;
    private LocalDate date_deb;
    private  LocalDate date_fin;
    private Integer idEmp;
    private List<VacationDay> jourDeVac;
    public VacationDto() {
    }

    public VacationDto(Integer idVac, LocalDate date_deb, LocalDate date_fin, Integer idEmp) {
        this.idVac = idVac;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.idEmp = idEmp;
    }

    public Integer getIdVac() {
        return idVac;
    }

    public void setIdVac(Integer idVac) {
        this.idVac = idVac;
    }

    public List<VacationDay> getJourDeVac() {
        return jourDeVac;
    }

    public void setJourDeVac(List<VacationDay> jourDeVac) {
        this.jourDeVac = jourDeVac;
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

    public static final class VacationDtoBuilder {
        private Integer idVac ;
        private  LocalDate date_deb;
        private  LocalDate date_fin;
        private  Integer idEmp;
        private List<VacationDay> jourDeVac;
        private VacationDtoBuilder() {
        }

        public static VacationDtoBuilder create() {
            return new VacationDtoBuilder();
        }

        public VacationDtoBuilder withIdVac(Integer idVac) {
            this.idVac = idVac;
            return this;
        }

        public VacationDtoBuilder withDateDeb(LocalDate date_deb) {
            this.date_deb = date_deb;
            return this;
        }

        public VacationDtoBuilder withDateFin(LocalDate date_fin) {
            this.date_fin = date_fin;
            return this;
        }

        public VacationDtoBuilder withIdEmp(Integer idEmp) {
            this.idEmp = idEmp;
            return this;
        }

        public VacationDtoBuilder withIdEmp(List<VacationDay> jourDeVac) {
            this.jourDeVac = jourDeVac;
            return this;
        }

        public VacationDto build() {
            return new VacationDto(idVac, date_deb, date_fin, idEmp);
        }
    }
}