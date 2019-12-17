package com.igor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Ingredient extends AbstractEntity {

    @Column
    String name;

}
