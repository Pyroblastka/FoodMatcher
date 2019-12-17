package com.igor.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class User extends AbstractEntity {

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;
    @Column(name = "enabled")
    private int enabled;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DishReview> dishReviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CafeReview> cafeReviews;

    public User() {
    }

    public User(String email, int enabled, String username, String password, List<Role> roles) {
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }

    public List<DishReview> getDishReviews() {
        return dishReviews;
    }

    public void setDishReviews(List<DishReview> dishReviews) {
        this.dishReviews = dishReviews;
    }

    public List<CafeReview> getCafeReviews() {
        return cafeReviews;
    }

    public void setCafeReviews(List<CafeReview> cafeReviews) {
        this.cafeReviews = cafeReviews;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
