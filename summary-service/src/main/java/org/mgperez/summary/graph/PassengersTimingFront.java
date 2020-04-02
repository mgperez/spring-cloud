package org.mgperez;

import lombok.Data;

import java.util.List;

/**
 * POJO holding information about the ...
 * Dto that matches our API
 */
public class PassengersTimingFront {
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

    private List<String> labels;
    private List<DataFront> datasets;

    public PassengersTimingFront() {

    }

    public PassengersTimingFront(List<String> labels, List<DataFront> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}