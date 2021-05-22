package models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Set {
    private UUID id;
    private int set;
    private Player player;
    private Lane lane;

    public Set(int set, Player player, Lane lane) {
        this.id = UUID.randomUUID();
        this.set = set;
        this.player = player;
        this.lane = lane;
    }
}
