/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "employee_profile_language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeProfileLanguage.findAll", query = "SELECT e FROM EmployeeProfileLanguage e")
    , @NamedQuery(name = "EmployeeProfileLanguage.findById", query = "SELECT e FROM EmployeeProfileLanguage e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeProfileLanguage.findByLevel", query = "SELECT e FROM EmployeeProfileLanguage e WHERE e.level = :level")
    , @NamedQuery(name = "EmployeeProfileLanguage.findByInsertDateTime", query = "SELECT e FROM EmployeeProfileLanguage e WHERE e.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "EmployeeProfileLanguage.findByLastUpdateDateTime", query = "SELECT e FROM EmployeeProfileLanguage e WHERE e.lastUpdateDateTime = :lastUpdateDateTime")})
public class EmployeeProfileLanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private int level;
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @JoinColumn(name = "employee_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmployeeProfile employeeProfileId;
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language languageId;

    public EmployeeProfileLanguage() {
    }

    public EmployeeProfileLanguage(Integer id) {
        this.id = id;
    }

    public EmployeeProfileLanguage(Integer id, int level) {
        this.id = id;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public EmployeeProfile getEmployeeProfileId() {
        return employeeProfileId;
    }

    public void setEmployeeProfileId(EmployeeProfile employeeProfileId) {
        this.employeeProfileId = employeeProfileId;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    @Override
    public String toString() {
        return "languageId:"+languageId+",level:"+level;
    }

}
