package fr.univparis8.iut.dut.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("select e from EmployeeEntity e order by e.firstName, e.lastName asc")
    List<EmployeeEntity> findAllOrderByFirstNameLastName();
}
