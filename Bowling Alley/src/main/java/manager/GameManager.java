package manager;

import handlers.Scheduler;
import models.Lane;
import models.Team;
import storage.TeamQueue;

public class GameManager {

    public void manageGames(){
        Scheduler scheduler = new Scheduler();
        while(TeamQueue.getInstance().teamSize() > 0){
            Lane lane = scheduler.laneFinder();
            if (lane != null) {
                Team team = TeamQueue.getInstance().getTeam();
                scheduler.scheduleGame(lane, team);
            } else{
                break;
            }
        }
    }
}
