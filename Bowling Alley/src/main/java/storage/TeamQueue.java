package storage;

import models.Team;

import java.util.LinkedList;
import java.util.Queue;

public class TeamQueue {
    private static TeamQueue teamQueue;
    private Queue<Team> teams = new LinkedList<>();

    public static TeamQueue getInstance(){
        if (teamQueue == null){
            teamQueue = new TeamQueue();
        }
        return teamQueue;
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public int teamSize(){
        return teams.size();
    }

    public Team getTeam(){
        return teams.poll();
    }
}
