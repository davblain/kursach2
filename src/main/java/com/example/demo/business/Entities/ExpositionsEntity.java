package com.example.demo.business.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

/**
 * Created by davblain on 20.05.2017.
 */
@Entity
@Table(name = "expositions", schema = "mydb", catalog = "")
public class ExpositionsEntity implements Serializable {
    private Integer id;
    private String name;
    private Calendar dateOfBegining;
    private Calendar dateOfEnd;
    private String description;
    private String image;
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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(value = TemporalType. DATE)
    @Column(name = "date_of_begining", nullable = true)
    public Calendar getDateOfBegining() {
        return dateOfBegining;
    }

    public void setDateOfBegining(Calendar dateOfBegining) {
        this.dateOfBegining = dateOfBegining;
    }

    @Temporal(value = TemporalType. DATE)
    @Column(name = "date_of_end", nullable = true)
    public Calendar getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Calendar dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 45)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "exposition_to_arts",joinColumns = @JoinColumn(name="id_expos"),inverseJoinColumns = @JoinColumn(name="id_art"))
    public Collection<ArtsEntity> getArts() {
        return arts;
    }

    public void setArts(Collection<ArtsEntity> arts) {
        this.arts = arts;
    }
}
