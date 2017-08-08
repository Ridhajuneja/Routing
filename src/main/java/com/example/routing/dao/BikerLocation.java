package com.example.routing.dao;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by ridha on 1/8/17.
 */
@Entity
@Table(name = "BikerLocation")
public class BikerLocation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long locationId;

    @Column(nullable = false)
    private DateTime dateTimeFormat;
    private Double lattitude;


    private Double longitude;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id",nullable = false)
    private Biker biker;

    public DateTime getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateTimeFormat(DateTime dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    public Double getLattitude() {
        return lattitude;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Biker getBiker() {
        return biker;
    }

    public void setBiker(Biker biker) {
        this.biker = biker;
    }


}
