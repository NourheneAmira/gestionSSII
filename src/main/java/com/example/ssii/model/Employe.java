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
public class Employe implements Serializable {
    private static final long serialVersionUID = -1396669830860400871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreatedDate
    @Column(name = "datecreation", nullable = false, updatable = false)
    private Date dateCreation;
    @LastModifiedDate
    @Column(name = "dateModification")
    private Date dateModification;

    private String prenom;

    private String nom;

    private String password;


    private String email;

    private boolean actif;

    @Enumerated(EnumType.STRING)
    // @NotNull
    private Role role;
    @OneToOne(mappedBy = "employe")
    private Contrat contrat;

    @JsonIgnore
    @ManyToMany(mappedBy = "employes", fetch = FetchType.EAGER)
    // @NotNull
    private List<Departement> departements;
    @JsonIgnore
    // @JsonBackReference
    @OneToMany(mappedBy = "employe")
    private List<Timesheet> timesheets;

}
