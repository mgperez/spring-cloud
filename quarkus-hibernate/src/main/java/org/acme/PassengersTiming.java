package org.acme;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class PassengersTiming extends PanacheEntity {
    public String xLabel;
    public float yValue;
    public PassengersTiming(){}

    public PassengersTiming(String xLabel, float yValue){
        
        this.xLabel = xLabel;
        this.yValue = yValue;
    }
    
    public static PassengersTiming findByX(String xLabel){
        return find("xLabel", xLabel).firstResult();
    }
    
    public static void removeByX(String xLabel){
        delete("xLabel", xLabel);
    }

	public String getxLabel() {
		return xLabel;
	}

	public void setxLabel(String xLabel) {
		this.xLabel = xLabel;
	}

	public float getyValue() {
		return yValue;
	}

	public void setyValue(float yValue) {
		this.yValue = yValue;
	}
}