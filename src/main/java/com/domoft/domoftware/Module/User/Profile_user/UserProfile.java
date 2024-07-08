package com.domoft.domoftware.Module.User.Profile_user;

import com.domoft.domoftware.Module.User.User;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String phone;

    private String address;

    @Column(name = "date_of_birth")
    private java.sql.Date dateOfBirth;

    @Column(name = "profile_pictures_url")
    private String profilePicturesUrl;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfilePicturesUrl() {
        return profilePicturesUrl;
    }

    public void setProfilePicturesUrl(String profilePicturesUrl) {
        this.profilePicturesUrl = profilePicturesUrl;
    }

    //Contractor

    public UserProfile(Long id, User user, String phone, String address, Date dateOfBirth, String profilePicturesUrl) {
        this.id = id;
        this.user = user;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.profilePicturesUrl = profilePicturesUrl;
    }

    public UserProfile(User user, String phone, String address, Date dateOfBirth, String profilePicturesUrl) {
        this.user = user;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.profilePicturesUrl = profilePicturesUrl;
    }

    public UserProfile() {
    }

}
