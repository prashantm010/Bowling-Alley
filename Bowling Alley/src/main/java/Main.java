import handlers.Alley;
import manager.GameManager;
import manager.LaneManager;
import manager.TeamManager;

public class Main {
    public static void main(String[] args){
        LaneManager laneManager = new LaneManager(2);
        laneManager.createLanes();

        TeamManager teamManager = new TeamManager(5);
        teamManager.createTeams();

        GameManager gameManager = new GameManager();
        gameManager.manageGames();

        Alley alley = new Alley(gameManager);
        alley.playGame();
    }
}
