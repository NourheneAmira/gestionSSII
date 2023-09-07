package com.example.ssii.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MissionExterne extends Mission {
    private static final long serialVersionUID = -3046278688391172322L;
    @CreatedDate
    @Column(name = "datecreation", nullable = false, updatable = false)
    private Date dateCreation;
    @LastModifiedDate
    @Column(name = "dateModification")
    private Date dateModification;

    private String emailFacturation;


    private float tauxJournalierMoyen;

}
