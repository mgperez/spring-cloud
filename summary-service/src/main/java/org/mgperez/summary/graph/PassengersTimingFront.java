package org.mgperez.summary.graph;

import lombok.Data;

import java.util.List;

/**
 * POJO holding information about the ...
 * Dto that matches our API
 */
@Data
public class PassengersTimingFront {
    private List<String> labels;
    private List<DataFront> datasets;

    public PassengersTimingFront() {}

    public PassengersTimingFront(List<String> labels, List<DataFront> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}