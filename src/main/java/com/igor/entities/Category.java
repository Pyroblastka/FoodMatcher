package com.igor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Category extends AbstractEntity {
    @Column
    String name;
}
