/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "employee_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeProfile.findAll", query = "SELECT e FROM EmployeeProfile e")
    , @NamedQuery(name = "EmployeeProfile.findById", query = "SELECT e FROM EmployeeProfile e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeProfile.findByApproved", query = "SELECT e FROM EmployeeProfile e WHERE e.approved = :approved")
    , @NamedQuery(name = "EmployeeProfile.findByApprovedDateTime", query = "SELECT e FROM EmployeeProfile e WHERE e.approvedDateTime = :approvedDateTime")
    , @NamedQuery(name = "EmployeeProfile.findByCvPath", query = "SELECT e FROM EmployeeProfile e WHERE e.cvPath = :cvPath")
    , @NamedQuery(name = "EmployeeProfile.findByInsertDateTime", query = "SELECT e FROM EmployeeProfile e WHERE e.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "EmployeeProfile.findByIsLookingForWork", query = "SELECT e FROM EmployeeProfile e WHERE e.isLookingForWork = :isLookingForWork")
    , @NamedQuery(name = "EmployeeProfile.findByIsWorking", query = "SELECT e FROM EmployeeProfile e WHERE e.isWorking = :isWorking")
    , @NamedQuery(name = "EmployeeProfile.findByLastUpdateDateTime", query = "SELECT e FROM EmployeeProfile e WHERE e.lastUpdateDateTime = :lastUpdateDateTime")})
public class EmployeeProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "approved")
    private Boolean approved;
    @Column(name = "approved_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDateTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cv_path")
    private String cvPath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "is_looking_for_work")
    private Boolean isLookingForWork;
    @Column(name = "is_working")
    private Boolean isWorking;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeProfileId", fetch = FetchType.LAZY)
    private Collection<EmployeeProfileSkill> employeeProfileSkillCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.LAZY)
    private Collection<EmployeeProject> employeeProjectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeProfileId", fetch = FetchType.LAZY)
    private Collection<EmployeeProfileLanguage> employeeProfileLanguageCollection;

    public EmployeeProfile() {
    }

    public EmployeeProfile(Integer id) {
        this.id = id;
    }

    public EmployeeProfile(Integer id, String cvPath, Date insertDateTime) {
        this.id = id;
        this.cvPath = cvPath;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Date getApprovedDateTime() {
        return approvedDateTime;
    }

    public void setApprovedDateTime(Date approvedDateTime) {
        this.approvedDateTime = approvedDateTime;
    }

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Boolean getIsLookingForWork() {
        return isLookingForWork;
    }

    public void setIsLookingForWork(Boolean isLookingForWork) {
        this.isLookingForWork = isLookingForWork;
    }

    public Boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(Boolean isWorking) {
        this.isWorking = isWorking;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<EmployeeProfileSkill> getEmployeeProfileSkillCollection() {
        return employeeProfileSkillCollection;
    }

    public void setEmployeeProfileSkillCollection(Collection<EmployeeProfileSkill> employeeProfileSkillCollection) {
        this.employeeProfileSkillCollection = employeeProfileSkillCollection;
    }

    @XmlTransient
    public Collection<EmployeeProject> getEmployeeProjectCollection() {
        return employeeProjectCollection;
    }

    public void setEmployeeProjectCollection(Collection<EmployeeProject> employeeProjectCollection) {
        this.employeeProjectCollection = employeeProjectCollection;
    }

    @XmlTransient
    public Collection<EmployeeProfileLanguage> getEmployeeProfileLanguageCollection() {
        return employeeProfileLanguageCollection;
    }

    public void setEmployeeProfileLanguageCollection(Collection<EmployeeProfileLanguage> employeeProfileLanguageCollection) {
        this.employeeProfileLanguageCollection = employeeProfileLanguageCollection;
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
        if (!(object instanceof EmployeeProfile)) {
            return false;
        }
        EmployeeProfile other = (EmployeeProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.itcommunity.entity.EmployeeProfileLanguageServiceInter[ id=" + id + " ]";
    }
    
}
