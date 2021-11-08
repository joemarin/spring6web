package com.joe.spring6web.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Publisher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String addressLine;
    private String city;
    private String stateCode;
    private String zip;

    @ManyToMany(mappedBy = "publishers")
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String addressLine, String city, String stateCode, String zip) {
        this.addressLine = addressLine;
        this.city = city;
        this.stateCode = stateCode;
        this.zip = zip;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return stateCode;
    }

    public void setState(String state) {
        this.stateCode = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    
    @Override
    public String toString() {
        return "Publisher{" + "id=" + id + ", addressLine=" + addressLine + ", city=" + city + ", stateCode=" + stateCode + ", zip=" + zip + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Publisher publisher = (Publisher) o;
        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
