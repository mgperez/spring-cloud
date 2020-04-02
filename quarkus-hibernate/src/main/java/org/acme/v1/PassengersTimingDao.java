package org.acme.v1;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.v1.PassengersTiming;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class PassengersDao implements PanacheRepository<PassengersTiming> {

    public List<PassengersTiming> findByName(String xLabel) {
        return find("xLabel", xLabel).list();
    }

    public PassengersTiming findByX(String xLabel){
        return find("xLabel", xLabel).firstResult();
    }

    public void removeByX(String xLabel){
        delete("xLabel", xLabel);
    }
}
