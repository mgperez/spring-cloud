package org.acme.v1;

import lombok.Data;
import org.acme.DataFront;

import java.util.List;

/**
 * POJO holding information about the ...
 * Dto that matches our API
 */
@Data
public class PassengersTimingFront {
    private List<String> labels;
    private List<DataFront> datasets;
}
