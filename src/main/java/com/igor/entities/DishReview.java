package com.igor.entities;

import javax.persistence.*;

@Entity
public class DishReview extends AbstractEntity{

    @Column
    private int stars;

    @Column
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "customer", nullable = false)
    private User user;

    public DishReview() {
    }

    public DishReview(int stars, String text, User user) {
        this.stars = stars;
        this.text = text;
        this.user = user;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
