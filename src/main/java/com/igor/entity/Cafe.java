package com.igor.entity;

import org.graalvm.compiler.nodeinfo.StructuralInput;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Cafe extends AbstractEntity{

    @Column
    String name;

    @Column
    String address;

    //@ManyToOne(fetch = FetchType.EAGER)
    //Category category;
}
