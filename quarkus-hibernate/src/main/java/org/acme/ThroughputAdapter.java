package org.acme;

import java.util.ArrayList;
import java.util.List;

public class ThroughputAdapter {
    public static ThroughputFront adapt(List<ThroughputFront> adaptee) {
        ThroughputFront adapted = new ThroughputFront();
        
        List<Throughput> throughputs = new ArrayList<Throughput>();

        adapted.setThroughputs(throughputs);
        
        return adapted;
        
       
        
    }

}
