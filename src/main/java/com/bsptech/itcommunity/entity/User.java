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
@Table(name = "user")
public class User implements Serializable {

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
    @Size(min = 1, max = 255)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<ProjectSkill> projectSkillCollection;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<Role> roleCollection;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<Gender> genderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<Itproject> itprojectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private Collection<EmployeeProfile> employeeProfileCollection;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<EmployeeProfileSkill> employeeProfileSkillCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<Language> languageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private Collection<UserGender> userGenderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private Collection<UserRole> userRoleCollection;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<Skill> skillCollection;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<EmployeeProfileLanguage> employeeProfileLanguageCollection;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String surname, String username, String password, int age, String email, boolean enabled, Date insertDateTime) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.enabled = enabled;
        this.insertDateTime = insertDateTime;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
    public Collection<ProjectSkill> getProjectSkillCollection() {
        return projectSkillCollection;
    }

    public void setProjectSkillCollection(Collection<ProjectSkill> projectSkillCollection) {
        this.projectSkillCollection = projectSkillCollection;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @XmlTransient
    public Collection<Gender> getGenderCollection() {
        return genderCollection;
    }

    public void setGenderCollection(Collection<Gender> genderCollection) {
        this.genderCollection = genderCollection;
    }

    @XmlTransient
    public Collection<Itproject> getItprojectCollection() {
        return itprojectCollection;
    }

    public void setItprojectCollection(Collection<Itproject> itprojectCollection) {
        this.itprojectCollection = itprojectCollection;
    }

    @XmlTransient
    public Collection<EmployeeProfile> getEmployeeProfileCollection() {
        return employeeProfileCollection;
    }

    public void setEmployeeProfileCollection(Collection<EmployeeProfile> employeeProfileCollection) {
        this.employeeProfileCollection = employeeProfileCollection;
    }

    @XmlTransient
    public Collection<EmployeeProfileSkill> getEmployeeProfileSkillCollection() {
        return employeeProfileSkillCollection;
    }

    public void setEmployeeProfileSkillCollection(Collection<EmployeeProfileSkill> employeeProfileSkillCollection) {
        this.employeeProfileSkillCollection = employeeProfileSkillCollection;
    }

    @XmlTransient
    public Collection<Language> getLanguageCollection() {
        return languageCollection;
    }

    public void setLanguageCollection(Collection<Language> languageCollection) {
        this.languageCollection = languageCollection;
    }

    @XmlTransient
    public Collection<UserGender> getUserGenderCollection() {
        return userGenderCollection;
    }

    public void setUserGenderCollection(Collection<UserGender> userGenderCollection) {
        this.userGenderCollection = userGenderCollection;
    }

    @XmlTransient
    public Collection<UserRole> getUserRoleCollection() {
        return userRoleCollection;
    }

    public void setUserRoleCollection(Collection<UserRole> userRoleCollection) {
        this.userRoleCollection = userRoleCollection;
    }

    @XmlTransient
    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.itcommunity.entity.User[ id=" + id + " ]";
    }
    
}
