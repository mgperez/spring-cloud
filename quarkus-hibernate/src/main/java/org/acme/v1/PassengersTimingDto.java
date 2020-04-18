package org.acme.v1;

import lombok.Data;

import java.util.List;

@Data
public class PassengersTimingDto {
    private List<PassengersTimingV1> passengersTiming;

    public PassengersTimingDto() {
    }
    public PassengersTimingDto(List<PassengersTimingV1> passengersTiming) {
        this.passengersTiming = passengersTiming;
    }
}
