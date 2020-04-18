package org.acme.v1;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.PassengersTimingFront;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class PassengersTimingDao implements PanacheRepository<PassengersTimingV1> {

    public PassengersTimingV1 findByX(String xLabel){
        return find("xLabel", xLabel).firstResult();
    }

    public void removeByX(String xLabel){
        delete("xLabel", xLabel);
    }

}
