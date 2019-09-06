/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "itproject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itproject.findAll", query = "SELECT i FROM Itproject i")
    , @NamedQuery(name = "Itproject.findById", query = "SELECT i FROM Itproject i WHERE i.id = :id")
    , @NamedQuery(name = "Itproject.findByGithubPath", query = "SELECT i FROM Itproject i WHERE i.githubPath = :githubPath")
    , @NamedQuery(name = "Itproject.findByInDevelopment", query = "SELECT i FROM Itproject i WHERE i.inDevelopment = :inDevelopment")
    , @NamedQuery(name = "Itproject.findByName", query = "SELECT i FROM Itproject i WHERE i.name = :name")
    , @NamedQuery(name = "Itproject.findByNeedEmployee", query = "SELECT i FROM Itproject i WHERE i.needEmployee = :needEmployee")
    , @NamedQuery(name = "Itproject.findByPublishDate", query = "SELECT i FROM Itproject i WHERE i.publishDate = :publishDate")
    , @NamedQuery(name = "Itproject.findByWebsitePath", query = "SELECT i FROM Itproject i WHERE i.websitePath = :websitePath")
    , @NamedQuery(name = "Itproject.findByThumbnail", query = "SELECT i FROM Itproject i WHERE i.thumbnail = :thumbnail")
    , @NamedQuery(name = "Itproject.findByInsertDateTime", query = "SELECT i FROM Itproject i WHERE i.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "Itproject.findByLastUpdateDateTime", query = "SELECT i FROM Itproject i WHERE i.lastUpdateDateTime = :lastUpdateDateTime")})
public class Itproject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "about")
    private String about;
    @Size(max = 255)
    @Column(name = "github_path")
    private String githubPath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "in_development")
    private boolean inDevelopment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Column(name = "need_employee")
    private Boolean needEmployee;
    @Column(name = "publish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;
    @Size(max = 255)
    @Column(name = "website_path")
    private String websitePath;
    @Size(max = 200)
    @Column(name = "thumbnail")
    private String thumbnail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.LAZY)
    private List<ProjectSkill> projectSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.LAZY)
    private List<EmployeeProject> employeeProjectList;

    public Itproject() {
    }

    public Itproject(Integer id) {
        this.id = id;
    }

    public Itproject(Integer id, String about, boolean inDevelopment, String name, Date insertDateTime) {
        this.id = id;
        this.about = about;
        this.inDevelopment = inDevelopment;
        this.name = name;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getGithubPath() {
        return githubPath;
    }

    public void setGithubPath(String githubPath) {
        this.githubPath = githubPath;
    }

    public boolean getInDevelopment() {
        return inDevelopment;
    }

    public void setInDevelopment(boolean inDevelopment) {
        this.inDevelopment = inDevelopment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNeedEmployee() {
        return needEmployee;
    }

    public void setNeedEmployee(Boolean needEmployee) {
        this.needEmployee = needEmployee;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getWebsitePath() {
        return websitePath;
    }

    public void setWebsitePath(String websitePath) {
        this.websitePath = websitePath;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    @XmlTransient
    public List<ProjectSkill> getProjectSkillList() {
        return projectSkillList;
    }

    public void setProjectSkillList(List<ProjectSkill> projectSkillList) {
        this.projectSkillList = projectSkillList;
    }

    @XmlTransient
    public List<EmployeeProject> getEmployeeProjectList() {
        return employeeProjectList;
    }

    public void setEmployeeProjectList(List<EmployeeProject> employeeProjectList) {
        this.employeeProjectList = employeeProjectList;
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
        if (!(object instanceof Itproject)) {
            return false;
        }
        Itproject other = (Itproject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.itcommunity.entity.Itproject[ id=" + id + " ]";
    }
    
}
