package com.example.demo.business.Entities;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by davblain on 20.05.2017.
 */
@Entity
@Table(name = "types_of_art", schema = "mydb", catalog = "")
public class TypesOfArtEntity implements Serializable {
    private Integer id;
    private String name;
    private Collection<ArtsEntity> artsById;

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
    @OneToMany(mappedBy = "type",cascade=CascadeType.ALL )
    public Collection<ArtsEntity> getArtsById() {
        return artsById;
    }

    public void setArtsById(Collection<ArtsEntity> artsById) {
        this.artsById = artsById;
    }




}
