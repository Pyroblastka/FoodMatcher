package com.igor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cafe extends AbstractEntity{

    @Column
    String name;

    @Column
    String address;

    //@ManyToOne(fetch = FetchType.EAGER)
    //Category category;
}
