package manager;

import models.Lane;
import storage.LaneQueue;

public class LaneManager {
    private int laneCount;

    public LaneManager(int laneCount) {
        this.laneCount = laneCount;
    }

    public void createLanes(){
        for (int i=0; i<this.laneCount; i++){
            LaneQueue.getInstance().addLane(new Lane(String.valueOf(i+1)));
        }
    }
}
