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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "auth_group_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthGroupRole.findAll", query = "SELECT a FROM AuthGroupRole a")
    , @NamedQuery(name = "AuthGroupRole.findById", query = "SELECT a FROM AuthGroupRole a WHERE a.id = :id")
    , @NamedQuery(name = "AuthGroupRole.findByRoleId", query = "SELECT a FROM AuthGroupRole a WHERE a.roleId = :roleId")
    , @NamedQuery(name = "AuthGroupRole.findByUserId", query = "SELECT a FROM AuthGroupRole a WHERE a.userId = :userId")
    , @NamedQuery(name = "AuthGroupRole.findByInsertDateTime", query = "SELECT a FROM AuthGroupRole a WHERE a.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "AuthGroupRole.findByLastUpdateDateTime", query = "SELECT a FROM AuthGroupRole a WHERE a.lastUpdateDateTime = :lastUpdateDateTime")})
public class AuthGroupRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private int roleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;

    public AuthGroupRole() {
    }

    public AuthGroupRole(Integer id) {
        this.id = id;
    }

    public AuthGroupRole(Integer id, int roleId, int userId, Date insertDateTime) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthGroupRole)) {
            return false;
        }
        AuthGroupRole other = (AuthGroupRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.itcommunity.entity.AuthGroupRole[ id=" + id + " ]";
    }
    
}
