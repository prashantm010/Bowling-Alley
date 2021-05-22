package handlers;

import exceptions.LaneNotFound;
import models.Game;
import models.Team;
import models.Lane;
import storage.GameQueue;
import storage.LaneQueue;

public class Scheduler {
    public void scheduleGame(Lane lane, Team team){
        lane.setOccupied(true);
        Game game = new Game(lane, team);
        GameQueue.getInstance().addGame(game);
    }

    public Lane laneFinder(){
        Lane lane = LaneQueue.getInstance().getAvailableLane();
        if (lane != null){
            return lane;
        }
        return lane;
//        throw new LaneNotFound();
    }
}
