package com.igor.entities;

import javax.persistence.*;

@Entity
public class DishReview extends AbstractEntity{

    @Column
    int stars;

    @Column
    String text;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "customer", nullable = false)
    private User user;
}
