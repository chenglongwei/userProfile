package com.sjsu.cmpe275.model;

import javax.persistence.*;

/**
 * @author chenglongwei
 * @version 1.2
 * @since 2016-03-24
 * Profile bean, id is primary key.
 */
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "firstname", length = 50)
    private String firstname;

    @Column(name = "lastname", length = 50)
    private String lastname;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "organization", length = 50)
    private String organization;

    @Column(name = "aboutmyself", length = 150)
    private String aboutMyself;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
