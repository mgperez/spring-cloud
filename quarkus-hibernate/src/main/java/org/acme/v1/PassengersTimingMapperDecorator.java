package org.acme.v1;

import org.acme.DataFront;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.Collections;
import java.util.List;

public abstract class PassengersTimingMapperDecorator implements PassengersTimingMapper {

    @Inject
    @Named
    private PassengersTimingMapper delegate;

    //private final PassengersTimingMapper delegate;

    /*
    public PassengersTimingMapperDecorator(PassengersTimingMapper delegate) {
        this.delegate = delegate;
    }
     */

    @Override
    public PassengersTimingFront toFront(PassengersTimingDto person) {
        PassengersTimingFront dto = delegate.toFront( person );

        List<String> labels = Collections.emptyList();
        List<Float> data = Collections.emptyList();
        List<DataFront> datasets = Collections.<DataFront>emptyList();

        List<PassengersTimingV1> list = person.getPassengersTiming();
        for (PassengersTimingV1 timing : list){
            labels.add(timing.getXLabel());
            data.add(timing.getYValue());
        }

        datasets.add(new DataFront(data));

        dto.setLabels(labels);
        dto.setDatasets(datasets);

        return dto;
    }
}
