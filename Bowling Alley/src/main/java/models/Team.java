package models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Team {
    private UUID id;
    private List<Player> playerList;

    public Team(List<Player> playerList) {
        this.id = UUID.randomUUID();
        this.playerList = playerList;
    }
}
