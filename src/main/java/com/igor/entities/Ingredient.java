package com.igor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Ingredient extends AbstractEntity {

    @Column
    String name;

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
