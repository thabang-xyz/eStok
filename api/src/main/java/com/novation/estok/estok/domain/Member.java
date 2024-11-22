package com.novation.estok.estok.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "membership_status", nullable = false)
    private String membershipStatus;

    @Column(name = "date_joined", nullable = false)
    private LocalDate dateJoined;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stokvel_group_id", nullable = false)
    private StokvelGroup stokvelGroup;

    @ManyToOne
    @JoinColumn(name = "stokvel_id")  // Foreign key column for the relationship
    private Stokvel stokvel;

    public Member() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public StokvelGroup getStokvelGroup() {
        return stokvelGroup;
    }

    public void setStokvelGroup(StokvelGroup stokvelGroup) {
        this.stokvelGroup = stokvelGroup;
    }

    public Stokvel getStokvel() {
        return stokvel;
    }

    public void setStokvel(Stokvel stokvel) {
        this.stokvel = stokvel;
    }
}
