package org.acme;

import java.util.ArrayList;
import java.util.List;

public class PassengersTimingAdapter{
    public static PassengersTimingFront adapt(List<PassengersTiming> adaptee) {
        PassengersTimingFront adapted = new PassengersTimingFront();
        List<String> labels = new ArrayList<String>();
        List<Float> data = new ArrayList<Float>();

        for (PassengersTiming timing : adaptee){
            labels.add(timing.getxLabel());
            data.add(timing.getyValue());

        }
        
        List<DataFront> datasets = new ArrayList<DataFront>();
        datasets.add(new DataFront(data));
        adapted.setLabels(labels);
        adapted.setDatasets(datasets);
        
        return adapted;
        
    }

}