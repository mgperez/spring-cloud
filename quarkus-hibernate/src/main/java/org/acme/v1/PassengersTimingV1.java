package org.acme.v1;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * https://www.baeldung.com/jpa-entity-table-names
 */
@Data
@Entity
@Table(name = PassengersTimingV1.TABLE_NAME)
public class PassengersTimingV1 extends PanacheEntity {
    public static final String TABLE_NAME= "PassengersTiming";
    public String xLabel;
    public float yValue;
}
