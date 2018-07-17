package com.worldsnas.snappfoodtest.entity;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class DummyEntity {
    @Id
    long id;
}
