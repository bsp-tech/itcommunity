/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "employee_project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeProject.findAll", query = "SELECT e FROM EmployeeProject e")
    , @NamedQuery(name = "EmployeeProject.findById", query = "SELECT e FROM EmployeeProject e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeProject.findByApproved", query = "SELECT e FROM EmployeeProject e WHERE e.approved = :approved")
    , @NamedQuery(name = "EmployeeProject.findByPosition", query = "SELECT e FROM EmployeeProject e WHERE e.position = :position")
    , @NamedQuery(name = "EmployeeProject.findByInsertDateTime", query = "SELECT e FROM EmployeeProject e WHERE e.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "EmployeeProject.findByJoinDateTime", query = "SELECT e FROM EmployeeProject e WHERE e.joinDateTime = :joinDateTime")
    , @NamedQuery(name = "EmployeeProject.findByLastUpdateDateTime", query = "SELECT e FROM EmployeeProject e WHERE e.lastUpdateDateTime = :lastUpdateDateTime")})
public class EmployeeProject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approved")
    private short approved;
    @Size(max = 255)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "join_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Itproject projectId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmployeeProfile employeeId;

    public EmployeeProject() {
    }

    public EmployeeProject(Integer id) {
        this.id = id;
    }

    public EmployeeProject(Integer id, short approved, Date insertDateTime, Date joinDateTime, Date lastUpdateDateTime) {
        this.id = id;
        this.approved = approved;
        this.insertDateTime = insertDateTime;
        this.joinDateTime = joinDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getApproved() {
        return approved;
    }

    public void setApproved(short approved) {
        this.approved = approved;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getJoinDateTime() {
        return joinDateTime;
    }

    public void setJoinDateTime(Date joinDateTime) {
        this.joinDateTime = joinDateTime;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public Itproject getProjectId() {
        return projectId;
    }

    public void setProjectId(Itproject projectId) {
        this.projectId = projectId;
    }

    public EmployeeProfile getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeProfile employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeProject)) {
            return false;
        }
        EmployeeProject other = (EmployeeProject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.itcommunity.entity.EmployeeProject[ id=" + id + " ]";
    }
    
}
