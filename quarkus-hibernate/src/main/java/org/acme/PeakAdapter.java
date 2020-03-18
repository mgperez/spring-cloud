package org.acme;

import java.util.ArrayList;
import java.util.List;

public class PeakAdapter {

    public static PeakFront adapt(List<Peak> adaptedp) {
       
        PeakFront adapted = new PeakFront();
        List<Peak> peaks = new ArrayList<Peak>();

        adapted.setPeaks(peaks);
        
        return adapted;
        
    }
}
