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
public class Timesheet implements Serializable {
    private static final long serialVersionUID = 3876346912862238239L;
    @EmbeddedId
    private TimesheetPK timesheetPK;
    @CreatedDate
    @Column(name = "datecreation", nullable = false,insertable = false, updatable = false)
    private Date dateCreation;
    @LastModifiedDate
    @Column(name = "dateModification",insertable = false, updatable = false)
    private Date dateModification;

    private boolean isValide;
    @ManyToOne
    @JoinColumn(name = "idMission", referencedColumnName = "id", insertable=false, updatable=false)
    private Mission mission;

    //idEmploye est a la fois primary key et foreign key

    @ManyToOne
    @JoinColumn(name = "idEmploye", referencedColumnName = "id", insertable=false, updatable=false)
    private Employe employe;

}
