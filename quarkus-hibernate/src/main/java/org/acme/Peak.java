package org.acme;
import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Peak extends PanacheEntity{
    public String name;
    public Timestamp dateFrom;
    public Timestamp dateTo;
    public int total;
	
	public Peak(){}
    
    public Peak(String name, Timestamp dateFrom, Timestamp dateTo, int total) {
		this.name = name;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.total = total;
    }
    
    public static Person findByName(String name){
        return find("name", name).firstResult();
    }
    
    public static void remove(String name){
        delete("name", name);
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Timestamp getDateFrom() {
		return dateFrom;
	}


	public void setDateFrom(Timestamp dateFrom) {
		this.dateFrom = dateFrom;
	}


	public Timestamp getDateTo() {
		return dateTo;
	}


	public void setDateTo(Timestamp dateTo) {
		this.dateTo = dateTo;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
    
    




}