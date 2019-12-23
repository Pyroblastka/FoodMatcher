package com.igor.entities;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dish extends ImagedEntity{

    @Column(name = "dish_name")
    String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<DishReview> dishReviews;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dish_ingredients",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    List<Ingredient> ingredients;

    public Dish() {
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Dish(String name, List<DishReview> dishReviews) {
        this.name = name;
        this.dishReviews = dishReviews;
    }
    @Transactional
    public void addIngredient(Ingredient ingredient) {
        if(this.ingredients==null) {
            this.ingredients = new ArrayList<Ingredient>();
        }
        this.ingredients.add(ingredient);
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

    public String getIngredientsStr(){
        String out="";
        out+=ingredients.get(0).getName();
        for(int i = 1; i<ingredients.size(); i++) {
            out+=", ";
            out+=ingredients.get(i).getName();
        }
        out+=".";
    return out;
    }
}
