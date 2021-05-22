package models;

import lombok.Data;

import java.util.UUID;

@Data
public class Player {
    private UUID id;
    private String name;
    private int score;

    public Player(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        score = 0;
    }

    public void UpdateScore(int score){
        this.score = this.score + score;
    }
}
