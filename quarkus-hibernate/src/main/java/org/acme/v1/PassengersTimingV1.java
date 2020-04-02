package org.acme.v1;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class PassengersTiming extends PanacheEntity {
    public String xLabel;
    public float yValue;
}
