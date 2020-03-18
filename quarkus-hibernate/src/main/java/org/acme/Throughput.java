package org.acme;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Throughput extends PanacheEntity {
    public int noPassengers;
    public float previousPeriod;

    public Throughput(){}

    public Throughput(int noPassengers, float previousPeriod){
        
        this.noPassengers = noPassengers;
        this.previousPeriod = previousPeriod;
    }
    
    public static Throughput findById(long rowId){
        return find("id", rowId).firstResult();
    }
    
    public static void remove(String name){
        delete("name", name);
    }
}