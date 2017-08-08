package com.example.routing.dao;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by ridha on 31/7/17.
 */
@Entity
@Table(name = "LocationEntry")
public class LocationEntry {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long locationId;
    @Column(nullable = false)
    private DateTime dateTimeFormat;
    private Double lattitude;
    private Double longitude;

    @ManyToOne(targetEntity=FieldExecutive.class, optional = false)
//    @JoinColumn(name="id",
//          foreignKey = @ForeignKey(name = "id", value = ConstraintMode.PROVIDER_DEFAULT))
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
