package com.igor.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cafe extends ImagedEntity{

    @Column
    String name;

    @Column
    String address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<CafeReview> cafeReviews;

    public Cafe() {
    }

    public Cafe(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CafeReview> getCafeReviews() {
        return cafeReviews;
    }

    public void setCafeReviews(List<CafeReview> cafeReviews) {
        this.cafeReviews = cafeReviews;
    }
}
