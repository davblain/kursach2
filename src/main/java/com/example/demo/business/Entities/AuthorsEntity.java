package com.example.demo.business.Entities;



import com.example.demo.DemoApplication;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

/**
 * Created by davblain on 20.05.2017.
 */
@Entity
@Table(name = "authors", schema = "mydb", catalog = "")
public class AuthorsEntity implements Serializable {
    private Integer id;
    private String name;
    private String desription;
    private Calendar dateOfBirth;
    private Calendar dateOfDeath;
    private CountriesEntity country;
    private Collection<ArtsEntity> arts;

    @Id
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "desription", nullable = true, length = -1)
    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }
    @JsonSerialize(using=DemoApplication.CalendarSerializer.class)
    @JsonDeserialize(using = DemoApplication.CalendarDeserializer.class)
    @Temporal(value = TemporalType. DATE)
    @Column(name = "date_of_birth", nullable = true)
    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    @JsonSerialize(using=DemoApplication.CalendarSerializer.class)
    @JsonDeserialize(using = DemoApplication.CalendarDeserializer.class)
    @Temporal(value = TemporalType. DATE)
    @Column(name = "date_of_death", nullable = true)
    public Calendar getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Calendar dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties({"yearOfCreation","description","material","author","type","genre","collections","expositions", "prewImage","image"})
    public Collection<ArtsEntity> getArts() {
        return arts;
    }

    public void setArts(Collection<ArtsEntity> arts) {
        this.arts = arts;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country")
    @JsonIgnoreProperties("authorsById")
    public CountriesEntity getCountry() {
        return country;
    }

    public void setCountry(CountriesEntity country) {
        this.country = country;
    }







}
