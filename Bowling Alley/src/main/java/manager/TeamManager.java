package manager;

import models.Player;
import models.Team;
import storage.TeamQueue;

import java.util.ArrayList;
import java.util.List;

public class TeamManager {
    private int teamsCount;
    private int minPlayers;
    private int maxPlayers;

    public TeamManager(int teamsCount) {
        this.teamsCount = teamsCount;
        this.minPlayers = 1;
        this.maxPlayers = 6;
    }

    public List<Player> createPlayers(int n){
        List<Player> playerList = new ArrayList<>();
        for (int i=0; i<n; i++){
            playerList.add(new Player(String.valueOf(i+1)));
        }
        return playerList;
    }

    public void createTeams(){
        for (int i=0; i<this.teamsCount; i++){
            TeamQueue.getInstance().addTeam(new Team(createPlayers((int) ((Math.random() * (this.maxPlayers - this.minPlayers)) + 1))));
        }
    }
}
