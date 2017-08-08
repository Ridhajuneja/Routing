package com.example.routing.dao;

import javax.persistence.*;

/**
 * Created by ridha on 1/8/17.
 */
@Entity
@Table(name = "Biker")
public class Biker {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name="status", columnDefinition="Boolean default True")
    private Boolean status;
    private Integer age;
    private String work;
    private String education;
    private String placeLived;
    @Column(length=10)
    private String contactNumber;
//    @OneToMany(mappedBy ="fieldExecutive", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
//    private Collection<BikerEntry> locationEntries = new ArrayList<BikerEntry>();


    public Biker(Long id, String name, Boolean status, Integer age, String work, String education, String placeLived, String contactNumber, String userName, String password) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.age = age;
        this.work = work;
        this.education = education;
        this.placeLived = placeLived;
        this.contactNumber = contactNumber;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPlaceLived() {
        return placeLived;
    }

    public void setPlaceLived(String placeLived) {
        this.placeLived = placeLived;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(unique=true, nullable=false,length=40)
    private String userName;
    @Column( nullable=false,length=40)
    private String password;

    public Biker() {
    }

}
