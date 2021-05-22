package storage;

import models.Game;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public class GameQueue {
    private static GameQueue gameQueue;
    private HashMap<UUID, Game> gamesList = new HashMap<>();

    public static GameQueue getInstance() {
        if (gameQueue == null) {
            gameQueue = new GameQueue();
        }
        return gameQueue;
    }

    public void addGame(Game game){
        gamesList.put(game.getId(), game);
    }

    public void updateGame(Game game){
        Game game1 = gamesList.get(game.getId());
        game1.setCompleted(true);
        game1.setEndTime(LocalDateTime.now());
        game1.setTeam(game.getTeam());
        game1.setRound(game.getRound());
        gamesList.put(game.getId(), game1);
    }

    public Game getGame(){
        Game game = null;
        for (UUID key: gamesList.keySet()) {
            if (!gamesList.get(key).isCompleted()) {
                game = gamesList.get(key);
                break;
            }
        }
        return game;
    }
}
