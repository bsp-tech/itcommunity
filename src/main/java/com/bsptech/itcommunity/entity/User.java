package com.bsptech.itcommunity.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "user")
@XmlRootElement
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "you must be at least 13 years old")
    @Min(value = 13, message = "You must be at least 13 years old")
    @Column(name = "age")
    private Integer age;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Size(min = 7, max = 255)//a@a.com
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;

    @Basic(optional = false)
    @Size(min = 3, max = 15, message ="use your real name")
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Size(min = 3, max = 30, message = "use your real surname")
    @Column(name = "surname")
    private String surname;

    @Basic(optional = false)
    @Size(min = 5, max = 255, message = "use minimum 5 symbols")
    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;
    @Column(name = "verify_email_code")
    private String verifyEmailCode;
    @Basic(optional = false)
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @Size(max = 300)
    @Column(name = "thumbnail")
    private String thumbnail;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<EmployeeProfile> employeeProfileList;
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Gender genderId;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AuthGroup groupId;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, int age, String email, boolean enabled, String name, String password, String surname, Date insertDateTime) {
        this.id = id;
        this.age = age;
        this.email = email;
        this.enabled = enabled;
        this.name = name;
        this.password = password;
        this.surname = surname;
        this.insertDateTime = insertDateTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerifyEmailCode() {
        return verifyEmailCode;
    }

    public void setVerifyEmailCode(String verifyEmailCode) {
        this.verifyEmailCode = verifyEmailCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @XmlTransient
    public List<EmployeeProfile> getEmployeeProfileList() {
        return employeeProfileList;
    }

    public void setEmployeeProfileList(List<EmployeeProfile> employeeProfileList) {
        this.employeeProfileList = employeeProfileList;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public AuthGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(AuthGroup groupId) {
        this.groupId = groupId;
    }

    public EmployeeProfile getEmployeeProfile(){
        return this.employeeProfileList!=null && this.employeeProfileList.size()>0 ? this.employeeProfileList.get(0):null;
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
        return "User [id=" + id + "]";
    }



}