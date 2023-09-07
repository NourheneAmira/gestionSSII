package com.example.ssii.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departement implements Serializable {
    private static final long serialVersionUID = -357738161698377833L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @CreatedDate
    @Column(name = "datecreation", nullable = false, updatable = false)
    private Date dateCreation;
    @LastModifiedDate
    @Column(name = "dateModification")
    private Date dateModification;
    @Column(name = "nameentreprise")
    private String nameEntreprise;
    @JsonIgnore
    @ManyToMany
    private List<Employe> employes;

    @OneToMany(mappedBy="departement")
    private List<Mission> missions;
    @ManyToOne
    private Entreprise entreprise;


}
