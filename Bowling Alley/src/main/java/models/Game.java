package models;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Game {
    private UUID id;
    private Lane lane;
    private List<Round> round;
    private Team team;
    private boolean isCompleted;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    public Game(Lane lane, Team team) {
        this.id = UUID.randomUUID();
        this.lane = lane;
        this.team = team;
        this.round = new ArrayList<>();
    }

    public void UpdateRound(Round round) {
        this.round.add(round);
    }
}
