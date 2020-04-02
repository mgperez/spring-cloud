package org.mgperez;

import lombok.Data;

import java.util.List;


public class DataFront {
    public List<Float> getData() {
        return data;
    }

    public void setData(List<Float> data) {
        this.data = data;
    }

    private List<Float> data;

    public DataFront() {

    }
    public DataFront(List<Float> data) {
        this.data = data;
    }
}
