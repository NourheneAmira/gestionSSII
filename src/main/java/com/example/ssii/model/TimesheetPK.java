package com.example.ssii.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TimesheetPK implements Serializable {
    private static final long serialVersionUID = 5377539445871317492L;

    private int idMission;

    private int idEmploye;
    @CreatedDate
    @Column(name = "datecreation", nullable = false, updatable = false)
    private Date dateCreation;
    @LastModifiedDate
    @Column(name = "dateModification")
    private Date dateModification;
}
