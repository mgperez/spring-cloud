package org.mgperez;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Quarkus: Hibernate with panache | DevNation Live
 * https://www.youtube.com/watch?v=aKsxaCiP7bE
 * https://quarkus.io/guides/hibernate-orm-panache
 *
 * https://www.baeldung.com/jpa-entity-table-names
 */
@Data
@Entity
@Table(name = "PassengersTiming")
public class PassengersTiming extends PanacheEntity {
    @Column(unique = true)
    @NotBlank
    public String xLabel;
    public float yValue;
}

