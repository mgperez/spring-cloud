package org.acme;

import java.util.List;

public class ThroughputFront {
    private List<Throughput> throughputs;

    
    
    public ThroughputFront(){

    }

    public ThroughputFront(List<Throughput> throughputs){
        this.throughputs=throughputs;
       
    }

    public List<Throughput> getThroughputs() {
        return throughputs;
    }

    public void setThroughputs(List<Throughput> throughputs) {
        this.throughputs = throughputs;
    }

    

}
