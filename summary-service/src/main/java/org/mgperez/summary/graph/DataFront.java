package org.mgperez.summary.graph;

import lombok.Data;

import java.util.List;

@Data
public class DataFront {
    private List<Float> data;

    public DataFront() {}
    public DataFront(List<Float> data) {
        this.data = data;
    }
}
