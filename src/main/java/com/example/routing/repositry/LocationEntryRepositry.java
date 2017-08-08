package com.example.routing.repositry;

import com.example.routing.dao.LocationEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ridha on 27/7/17.
 */
@Repository
public interface LocationEntryRepositry extends JpaRepository<LocationEntry,Integer>{
//    @Query(value = "Select u from BikerEntry  u  where u.fieldExecutive.id=:id ORDER BY u.dateTimeFormat DESC  ")
//    Page<BikerEntry> getLatestEntry(@Param("id") Long id, @Param("pageable") Pageable pageable);
      @Query(value = "Select u from LocationEntry u ORDER BY u.dateTimeFormat DESC  ")
      Page<LocationEntry> getLatestEntry(@Param("id") Long id, @Param("pageable") Pageable pageable);
    @Query(value="Select u from LocationEntry u where u.id=:id")
    LocationEntry getLocation(@Param("id") Long id);
    @Query(value="Select u from LocationEntry u where u.locationId=:id")
    LocationEntry getLocationById(@Param("id") Long id);

}
