package handlers;
import exceptions.InvalidPlayer;
import manager.GameManager;
import models.Player;
import models.Set;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class PlayerHandler {
    private Set set;
    private HashMap<UUID, Player> playerList;
    private SetHandler setHandler;

    public PlayerHandler(SetHandler setHandler, Set set) {
        this.setHandler = setHandler;
        this.set = set;
        this.playerList = new HashMap<>();
    }

    public int playGame(int pins){
        if (!checkPlayersAvailable(set.getPlayer())){
            this.setHandler.getHandler().getHandler().completeGame();
        }
        if (!isValidPlayer(set.getPlayer())){
            throw new InvalidPlayer();
        }
        int score = takeChance(pins);
        updateScore(score);
        this.playerList.put(set.getPlayer().getId(), set.getPlayer());
        return score;
    }

    private boolean checkPlayersAvailable(Player player){
        return player != null;
    }

    private void updateScore(int score){
        set.getPlayer().UpdateScore(score);
    }

    private int takeChance(int maxPins){
        return takeDownPins(maxPins);
    }

    private boolean isValidPlayer(Player player){
        return !playerList.containsKey(player.getId());
    }

    private int takeDownPins(int max){
        return new Random().nextInt(max+1);
    }
}
