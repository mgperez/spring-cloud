package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


public class PassengersTimingFront{
    private List<String> labels;
    private List<DataFront> datasets;
    
    public PassengersTimingFront(){

    }

    public PassengersTimingFront(List<String> labels, List<DataFront> datasets){
        
        this.labels = labels;
        this.datasets = datasets;
    }

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<DataFront> getDatasets() {
		return datasets;
	}

	public void setDatasets(List<DataFront> datasets) {
		this.datasets = datasets;
	}
}