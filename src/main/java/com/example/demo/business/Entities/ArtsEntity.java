package com.example.demo.business.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by davblain on 20.05.2017.
 */
@Entity
@Table(name = "arts", schema = "mydb", catalog = "")
public class ArtsEntity implements Serializable {
    private Integer id;
    private String name;
    private Integer yearOfCreation;
    private String description;
    private MaterialsEntity material;
    private AuthorsEntity author;
    private TypesOfArtEntity type;
    private GenresEntity genre;
    private Collection<CollectionsEntity> collections;
    private Collection<ExpositionsEntity> expositions;


    @Id
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    @Column(name = "artid", nullable = false)
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
    @Column(name = "year_of_creation", nullable = true)
    public Integer getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(Integer yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }


    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @JsonIgnoreProperties("arts")
    @ManyToOne
    @JoinColumn(name = "material")
    public MaterialsEntity getMaterial() {
        return material;
    }
    public void setMaterial(MaterialsEntity material) {
        this.material = material;
    }

    @ManyToOne
    @JoinColumn(name="author")
    @JsonIgnoreProperties({"arts","img","desription","dateOfBirth","dateOfDeath","country"})

    public AuthorsEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorsEntity author) {
        this.author = author;
    }
    @ManyToOne
    @JoinColumn(name = "type")
    @JsonIgnoreProperties("artsById")
    public TypesOfArtEntity getType() {
        return type;
    }

    public void setType(TypesOfArtEntity type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name = "genre")
    @JsonIgnoreProperties("arts")
    public GenresEntity getGenre() {
        return genre;
    }

    public void setGenre(GenresEntity genre) {
        this.genre = genre;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "collections_to_art",joinColumns = @JoinColumn(name="id_art"),inverseJoinColumns = @JoinColumn(name="id_coll"))
    public Collection<CollectionsEntity> getCollections() {
        return collections;
    }
    public void setCollections(Collection<CollectionsEntity> collections) {
        this.collections = collections;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "exposition_to_arts",joinColumns = @JoinColumn(name="id_art"),inverseJoinColumns = @JoinColumn(name="id_expos"))
    public Collection<ExpositionsEntity> getExpositions() {
        return expositions;
    }

    public void setExpositions(Collection<ExpositionsEntity> expositions) {
        this.expositions = expositions;
    }








}
