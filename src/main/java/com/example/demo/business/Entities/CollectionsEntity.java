package com.example.demo.business.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by davblain on 20.05.2017.
 */
@Entity
@Table(name = "collections", schema = "mydb", catalog = "")
public class CollectionsEntity implements Serializable {
    private Integer id;
    private String name;
    private String image;
    private String description;
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

    @Basic
    @Column(name = "image", nullable = true, length = 45)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @ManyToMany
    @JoinTable(name="collections_to_art",joinColumns =@JoinColumn(name = "id_coll"),inverseJoinColumns = @JoinColumn(name = "id_art"))
    public Collection<ArtsEntity> getArts() {
        return arts;
    }

    public void setArts(Collection<ArtsEntity> arts) {
        this.arts = arts;
    }





}
