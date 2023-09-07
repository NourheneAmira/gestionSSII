package com.example.ssii.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contart")
public class Contart implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int reference;
    @CreatedDate
    @Column(name = "datecreation", nullable = false, updatable = false)
    private Date dateCreation;
    @LastModifiedDate
    @Column(name = "dateModification")
    private Date dateModification;

    @Column(name = "typeContrat")
    private String typeContrat;
    @Column(name = "salaire")
    private float salaire;


}
