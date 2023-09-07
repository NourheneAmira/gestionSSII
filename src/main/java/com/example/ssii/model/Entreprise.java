package com.example.ssii.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entreprise implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @CreatedDate
    @Column(name = "datecreation", nullable = false, updatable = false)
    private Date dateCreation;
    @LastModifiedDate
    @Column(name = "dateModification")
    private Date dateModification;

    private String name;


    private String raisonSocial;
    @OneToMany(mappedBy="entreprise",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch=FetchType.EAGER)
    private List<Departement> departements = new ArrayList<>();

}
