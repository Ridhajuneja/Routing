package com.example.routing.repositry;

import com.example.routing.dao.Biker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ridha on 1/8/17.
 */
@Repository
public interface BikerRepositry extends JpaRepository<Biker,Long> {
    @Query(value = "Select u from Biker u where u.userName=:name")
    Biker getUserByname(@Param("name") String name);

    @Query(value="Select u from Biker u where u.id=:id")
    Biker getUserByid(@Param("id") Long id);
}
