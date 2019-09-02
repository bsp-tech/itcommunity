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
import javax.persistence.Lob;
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
@Table(name = "itproject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itproject.findAll", query = "SELECT i FROM Itproject i")
    , @NamedQuery(name = "Itproject.findById", query = "SELECT i FROM Itproject i WHERE i.id = :id")
    , @NamedQuery(name = "Itproject.findByName", query = "SELECT i FROM Itproject i WHERE i.name = :name")
    , @NamedQuery(name = "Itproject.findByInDevelopment", query = "SELECT i FROM Itproject i WHERE i.inDevelopment = :inDevelopment")
    , @NamedQuery(name = "Itproject.findByNeedEmployee", query = "SELECT i FROM Itproject i WHERE i.needEmployee = :needEmployee")
    , @NamedQuery(name = "Itproject.findByWebsitePath", query = "SELECT i FROM Itproject i WHERE i.websitePath = :websitePath")
    , @NamedQuery(name = "Itproject.findByGithubPath", query = "SELECT i FROM Itproject i WHERE i.githubPath = :githubPath")
    , @NamedQuery(name = "Itproject.findByInsertDateTime", query = "SELECT i FROM Itproject i WHERE i.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "Itproject.findByLastUpdateDateTime", query = "SELECT i FROM Itproject i WHERE i.lastUpdateDateTime = :lastUpdateDateTime")
    , @NamedQuery(name = "Itproject.findByPublishDate", query = "SELECT i FROM Itproject i WHERE i.publishDate = :publishDate")})
public class Itproject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "about")
    private String about;
    @Basic(optional = false)
    @NotNull
    @Column(name = "in_development")
    private short inDevelopment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "need_employee")
    private short needEmployee;
    @Size(max = 255)
    @Column(name = "website_path")
    private String websitePath;
    @Size(max = 255)
    @Column(name = "github_path")
    private String githubPath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.LAZY)
    private Collection<ProjectSkill> projectSkillCollection;
    @JoinColumn(name = "insert_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User insertUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.LAZY)
    private Collection<EmployeeProject> employeeProjectCollection;

    public Itproject() {
    }

    public Itproject(Integer id) {
        this.id = id;
    }

    public Itproject(Integer id, String name, String about, short inDevelopment, short needEmployee, Date insertDateTime, Date lastUpdateDateTime, Date publishDate) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.inDevelopment = inDevelopment;
        this.needEmployee = needEmployee;
        this.insertDateTime = insertDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public short getInDevelopment() {
        return inDevelopment;
    }

    public void setInDevelopment(short inDevelopment) {
        this.inDevelopment = inDevelopment;
    }

    public short getNeedEmployee() {
        return needEmployee;
    }

    public void setNeedEmployee(short needEmployee) {
        this.needEmployee = needEmployee;
    }

    public String getWebsitePath() {
        return websitePath;
    }

    public void setWebsitePath(String websitePath) {
        this.websitePath = websitePath;
    }

    public String getGithubPath() {
        return githubPath;
    }

    public void setGithubPath(String githubPath) {
        this.githubPath = githubPath;
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @XmlTransient
    public Collection<ProjectSkill> getProjectSkillCollection() {
        return projectSkillCollection;
    }

    public void setProjectSkillCollection(Collection<ProjectSkill> projectSkillCollection) {
        this.projectSkillCollection = projectSkillCollection;
    }

    public User getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(User insertUserId) {
        this.insertUserId = insertUserId;
    }

    @XmlTransient
    public Collection<EmployeeProject> getEmployeeProjectCollection() {
        return employeeProjectCollection;
    }

    public void setEmployeeProjectCollection(Collection<EmployeeProject> employeeProjectCollection) {
        this.employeeProjectCollection = employeeProjectCollection;
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
