//access Employee data from the database
package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    //List<Employee> findByFieldName_AndFirstName(String fieldName, String firstName);

    @Query("SELECT e FROM Employee e JOIN e.field f WHERE e.firstName = :firstName AND f.name = :fieldName")
    List<Employee> findAllEmployee(String firstName, String fieldName);

}