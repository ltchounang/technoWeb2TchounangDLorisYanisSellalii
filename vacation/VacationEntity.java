package fr.univparis8.iut.dut.vacation;

//package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.employee.Employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vacation")
public class VacationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vac")
    private Integer idVac;

    @Column(name = "date_deb")
    private LocalDate date_deb;

    @Column(name = "date_fin")
    private LocalDate date_fin;

    @JoinColumn(name = "employee_id")
    @Column(name = "id_emp")
    private Integer idEmp;

    public VacationEntity() {
    }

    public Integer getIdVac() {
        return idVac;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VacationEntity)) return false;
        VacationEntity that = (VacationEntity) o;
        return Objects.equals(idVac, that.idVac) &&
                date_deb.equals(that.date_deb) &&
                date_fin.equals(that.date_fin) && idEmp.equals(that.idEmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVac, date_deb, date_fin , idEmp);
    }

    public static final class VacationEntityBuilder {
        private Integer idVac ;
        private  LocalDate date_deb;
        private  LocalDate date_fin;
        private  Integer idEmp;


        private VacationEntityBuilder() {
        }

        public static VacationEntityBuilder create() {
            return new VacationEntityBuilder();
        }

        public VacationEntityBuilder withIdVac(Integer idVac) {
            this.idVac = idVac;
            return this;
        }

        public VacationEntityBuilder withDateDeb(LocalDate date_deb) {
            this.date_deb = date_deb;
            return this;
        }

        public VacationEntityBuilder withDateFin(LocalDate date_fin) {
            this.date_fin = date_fin;
            return this;
        }

        public VacationEntityBuilder withIdEmp(Integer idEmp) {
            this.idEmp = idEmp;
            return this;
        }

        public VacationEntity build() {
            VacationEntity vacationeEntity = new VacationEntity();
            vacationeEntity.setIdVac(idVac);
            vacationeEntity.setDate_deb(date_deb);
            vacationeEntity.setDate_fin(date_fin);
            vacationeEntity.setIdEmp(idEmp);
            return vacationeEntity;
        }

    }
}