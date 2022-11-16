//access Employee data from the database
package com.example.demo.repository;

import com.example.demo.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "field", path = "field")
public interface FieldRepository extends JpaRepository<Field, Long> {
}
