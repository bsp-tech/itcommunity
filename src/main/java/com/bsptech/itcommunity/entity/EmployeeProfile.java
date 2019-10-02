/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.entity;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "employee_profile")
public class EmployeeProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "required")
    @Column(name = "approved")
    private Boolean approved;
    @Basic(optional = false)
    @Column(name = "approved_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDateTime;
    @Basic(optional = false)
    @Size(max = 1000)
//    @Pattern(regexp="^((http|https):\\/\\/)?+[a-zA-Z0-9-]+$", message="Invalid cv path")
    @Column(name = "cv_path")
    private String cvPath;
    @Size(max = 255)
//    @Pattern(regexp="^$|((http|https):\\/\\/)?+(github.com\\/)+[a-zA-Z0-9-]+$", message="invalid github account")
    @Column(name = "github_path")
    private String githubPath;
    @Size(max = 255)
//    @Pattern(regexp="^$|((http|https):\\/\\/)?+(www.linkedin.com\\/in\\/)+[a-zA-Z0-9-]{5,30}+$", message="Invalid Linkedin account")
    @Column(name = "linkedin_path")
    private String linkedinPath;
    @Basic(optional = false)
    @Size(min=5, message = "use your real speciality")
    @Column(name = "speciality")
    private String speciality;
    @NotNull(message = "required")
    @Min(value = 1, message = "oh, no, really?")
    @Column(name = "experience")
    private Integer experience;
    @Basic(optional = false)
    @Column(name = "about")
//    @Size(min=300, max = 500, message = "use at least 300, maximum 500 symbols")
    private String about;
    @Basic(optional = false)
    @NotNull(message = "required")
    @Column(name = "is_looking_for_work")
    private Integer isLookingForWork;
    @Basic(optional = false)
    @NotNull(message = "required")
    @Column(name = "is_working")
    private Integer isWorking;
    @Basic(optional = false)
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Basic(optional = false)
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private User userId;
    @OneToMany(mappedBy = "employeeProfileId", fetch = FetchType.LAZY,cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<EmployeeProfileSkill> employeeProfileSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<EmployeeProject> employeeProjectList;
    @OneToMany(mappedBy = "employeeProfileId", fetch = FetchType.LAZY,cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<EmployeeProfileLanguage> employeeProfileLanguageList;

    public EmployeeProfile() {
    }

    public EmployeeProfile(Integer id) {
        this.id = id;
    }

    public EmployeeProfile(Integer id, Boolean approved, Date approvedDateTime, Integer isLookingForWork, Integer isWorking, Date insertDateTime, Date lastUpdateDateTime) {
        this.id = id;
        this.approved = approved;
        this.approvedDateTime = approvedDateTime;
        this.isLookingForWork = isLookingForWork;
        this.isWorking = isWorking;
        this.insertDateTime = insertDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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

    public String getGithubPath() {
        return githubPath;
    }

    public void setGithubPath(String githubPath) {
        this.githubPath = githubPath;
    }

    public Integer getIsLookingForWork() {
        return isLookingForWork;
    }

    public void setIsLookingForWork(Integer isLookingForWork) {
        this.isLookingForWork = isLookingForWork;
    }

    public Integer getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(Integer isWorking) {
        this.isWorking = isWorking;
    }

    public String getLinkedinPath() {
        return linkedinPath;
    }

    public void setLinkedinPath(String linkedinPath) {
        this.linkedinPath = linkedinPath;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @XmlTransient
    public List<EmployeeProfileSkill> getEmployeeProfileSkillList() {
        return employeeProfileSkillList;
    }

    public void setEmployeeProfileSkillList(List<EmployeeProfileSkill> employeeProfileSkillList) {
        this.employeeProfileSkillList = employeeProfileSkillList;
    }

    @XmlTransient
    public List<EmployeeProject> getEmployeeProjectList() {
        return employeeProjectList;
    }

    public void setEmployeeProjectList(List<EmployeeProject> employeeProjectList) {
        this.employeeProjectList = employeeProjectList;
    }

    @XmlTransient
    public List<EmployeeProfileLanguage> getEmployeeProfileLanguageList() {
        return employeeProfileLanguageList;
    }

    public void setEmployeeProfileLanguageList(List<EmployeeProfileLanguage> employeeProfileLanguageList) {
        this.employeeProfileLanguageList = employeeProfileLanguageList;
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
        return "EmployeeProfile{" + "employeeProfileSkillList=" + employeeProfileSkillList + ", employeeProfileLanguageList=" + employeeProfileLanguageList + '}';
    }




	public boolean isFilledAnyField(){
        boolean result = userId!=null &&(
                        StringUtils.isNoneBlank(userId.getName())||
                        StringUtils.isNoneBlank(userId.getSurname())||
                        StringUtils.isNoneBlank(userId.getEmail())||
                        StringUtils.isNoneBlank(userId.getPhone()))||
                (employeeProfileLanguageList!=null && employeeProfileLanguageList.size()>0)||
                (employeeProfileSkillList!=null && employeeProfileSkillList.size()>0);
        return result;
    }
}
