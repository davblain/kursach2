package com.example.demo.business.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by davblain on 20.05.2017.
 */
@Entity
@Table(name = "countries", schema = "mydb", catalog = "")
public class CountriesEntity implements Serializable {
    private Integer id;
    private String name;
    private Collection<AuthorsEntity> authorsById;
    @Id
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    @Column(name = "country_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 45,unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @OneToMany(mappedBy = "country", orphanRemoval = true,cascade = CascadeType.ALL)
    public Collection<AuthorsEntity> getAuthorsById() {
        return authorsById;
    }

    public void setAuthorsById(Collection<AuthorsEntity> authorsById) {
        this.authorsById = authorsById;
    }
}
