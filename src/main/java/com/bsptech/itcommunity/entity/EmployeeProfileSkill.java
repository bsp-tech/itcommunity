/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "employee_profile_skill")
public class EmployeeProfileSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "level")
    private Integer level;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @JoinColumn(name = "employee_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmployeeProfile employeeProfileId;
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Skill skillId;

    public EmployeeProfileSkill() {
    }

    public EmployeeProfileSkill(Integer id) {
        this.id = id;
    }

    public EmployeeProfileSkill(Integer id, Date insertDateTime) {
        this.id = id;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
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

    public Skill getSkillId() {
        return skillId;
    }

    public void setSkillId(Skill skillId) {
        this.skillId = skillId;
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
        if (!(object instanceof EmployeeProfileSkill)) {
            return false;
        }
        EmployeeProfileSkill other = (EmployeeProfileSkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "skillid:"+skillId+",level:"+level;
    }

}
