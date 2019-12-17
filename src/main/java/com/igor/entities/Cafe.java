package com.igor.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cafe extends AbstractEntity{

    @Column
    String name;

    @Column
    String address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<CafeReview> cafeReviews;

}
