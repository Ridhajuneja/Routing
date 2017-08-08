package com.example.routing.repositry;

import com.example.routing.dao.BikerLocation;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by ridha on 1/8/17.
 */
@Repository
public interface BikerLocationRepositry extends JpaRepository<BikerLocation,Integer> {

    @Query(value = "Select u from BikerLocation u where u.biker.id=:id ORDER BY u.dateTimeFormat DESC")
    Page<BikerLocation> getLatestEntry(@Param("id") Long id, @Param("pageable") Pageable pageable);
    @Query(value="Select u from BikerLocation u where u.biker.id=:id")
    BikerLocation getLocation(@Param("id") Long id);
    @Query(value="Select u from BikerLocation u where u.locationId=:id")
    BikerLocation getLocationById(@Param("id") Long id);
    @Query(value="Select u from BikerLocation u where u.biker.name=:name and u.dateTimeFormat=:date")
    List<BikerLocation> getCoordinates(@Param("name") String name,@Param("date") DateTime date);
}
