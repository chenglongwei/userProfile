package com.sjsu.cmpe275.model;

import javax.persistence.*;

/**
 * Created by chenglongwei on 3/24/16.
 */
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="firstname", length = 30)
    private String firstname;

    @Column(name="lastname", length = 30)
    private String lastname;

    @Column(name="email", length = 50)
    private String email;

    @Column(name="address", length = 50)
    private String address;

    @Column(name="organization", length = 50)
    private String organization;

    @Column(name="aboutmyself", length = 100)
    private String aboutMyself;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAboutMyself() {
        return aboutMyself;
    }

    public void setAboutMyself(String aboutMyself) {
        this.aboutMyself = aboutMyself;
    }
}
