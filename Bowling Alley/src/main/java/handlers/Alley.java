package handlers;
import manager.GameManager;
import models.Game;
import storage.GameQueue;

import java.time.LocalDateTime;

public class Alley {
    private GameManager manager;

    public Alley(GameManager manager) {
        this.manager = manager;
    }

    public void playGame(){
        Game game = GameQueue.getInstance().getGame();
        this.manageGame(game);
    }

    private void manageGame(Game game){
        GameHandler gameHandler = new GameHandler(this, game);
        if (game != null) {
            game.setStartTime(LocalDateTime.now());
            gameHandler.startGame();
        }
    }

    public void changeGame(){
        this.manager.manageGames();
        this.playGame();
    }
}
