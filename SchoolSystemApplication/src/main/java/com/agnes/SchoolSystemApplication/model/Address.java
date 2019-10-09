package com.agnes.SchoolSystemApplication.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String phoneNumber;
    private long postalCode;
    private String email;
    private String Town;
    private long postalAddress;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public long getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(long postalAddress) {
        this.postalAddress = postalAddress;
    }
}
