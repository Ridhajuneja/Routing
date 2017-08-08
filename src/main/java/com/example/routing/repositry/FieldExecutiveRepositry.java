package com.example.routing.repositry;

import com.example.routing.dao.FieldExecutive;
import com.example.routing.dao.LocationEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ridha on 31/7/17.
 */
@Repository
public interface FieldExecutiveRepositry extends JpaRepository<FieldExecutive,Integer> {
    @Query(value = "Select u from FieldExecutive u where u.userName=:name")
    FieldExecutive getUserByname(@Param("name") String name);

   @Query(value="Select u from FieldExecutive u where u.id=:id")
   FieldExecutive getUserByid(@Param("id") Long id);
}
