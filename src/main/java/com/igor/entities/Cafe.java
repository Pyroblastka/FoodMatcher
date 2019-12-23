package com.igor.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cafe extends ImagedEntity {


    @Column(name = "cafe_name")
    String name;

    @Column
    String address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<CafeReview> cafeReviews;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "cafe_dishes",
            joinColumns = @JoinColumn(name = "cafe_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    List<Dish> dishes;

    public Cafe() {
    }

    public Cafe(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public void addDish(Dish dish) {
        if (dishes == null) {
            dishes = new ArrayList<Dish>();
        }
        dishes.add(dish);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
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
