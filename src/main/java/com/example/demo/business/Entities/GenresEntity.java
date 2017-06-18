package com.example.demo.business.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by davblain on 20.05.2017.
 */
@Entity
@Table(name = "genres", schema = "mydb", catalog = "")
public class GenresEntity implements Serializable {
    private Integer id;
    private String name;
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

    @OneToMany(mappedBy = "genre" )
    public Collection<ArtsEntity> getArts() {
        return arts;
    }

    public void setArts(Collection<ArtsEntity> arts) {
        this.arts = arts;
    }



}
