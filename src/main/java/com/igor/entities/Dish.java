package com.igor.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dish extends ImagedEntity{
    @Column
    String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<DishReview> dishReviews;

    public Dish() {
    }

    public Dish(String name, List<DishReview> dishReviews) {
        this.name = name;
        this.dishReviews = dishReviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DishReview> getDishReviews() {
        return dishReviews;
    }

    public void setDishReviews(List<DishReview> dishReviews) {
        this.dishReviews = dishReviews;
    }
}
