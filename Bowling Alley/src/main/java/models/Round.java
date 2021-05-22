package models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Round {
    private UUID id;
    private int roundNo;
    private Team team;
    private Lane lane;
    private List<Set> sets;

    public Round(int roundNo, Lane lane, Team team) {
        this.id = UUID.randomUUID();
        this.roundNo = roundNo;
        this.lane = lane;
        this.team = team;
        this.sets = new ArrayList<>();
    }

    public void setSets(Set set) {
        this.sets.add(set);
    }
}
