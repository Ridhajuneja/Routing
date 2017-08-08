package com.example.routing.dao;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by ridha on 31/7/17.
 */
public class LocationEntryDTO {

    private String dateTimeFormat;
    private List<Double> lattitude;
    private List<Double> longitude;
    private Long id ;


    public  LocationEntryDTO(){

    }

    public LocationEntryDTO(String dateTimeFormat, List<Double> lattitude, List<Double> longitude, Long id) {
        this.dateTimeFormat = dateTimeFormat;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.id = id;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }


    public List<Double> getLattitude() {
        return lattitude;
    }

    public void setLattitude(List<Double> lattitude) {
        this.lattitude = lattitude;
    }

    public List<Double> getLongitude() {
        return longitude;
    }

    public void setLongitude(List<Double> longitude) {
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
