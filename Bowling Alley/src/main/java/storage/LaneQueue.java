package storage;

import models.Lane;

import java.util.LinkedList;
import java.util.Queue;

public class LaneQueue {
    private static LaneQueue laneQueue;
    private Queue<Lane> lanes = new LinkedList<>();

    public static LaneQueue getInstance(){
        if (laneQueue == null){
            laneQueue = new LaneQueue();
        }
        return laneQueue;
    }

    public void addLane(Lane lane){
        lanes.add(lane);
    }

    public void updateLane(Lane lane){
        for (Lane l1: lanes){
            if (lane.getId() == l1.getId()){
                l1.setOccupied(false);
            }
        }
    }

    public Lane getAvailableLane(){
        Lane lane1 = null;
        for (Lane lane: lanes){
            if (!lane.isOccupied()){
                lane1 = lane;
                break;
            }
        }
        return lane1;
    }

}
