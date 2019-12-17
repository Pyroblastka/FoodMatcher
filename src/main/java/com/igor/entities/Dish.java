package com.igor.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dish extends AbstractEntity{
    @Column
    String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<DishReview> dishReviews;
}
