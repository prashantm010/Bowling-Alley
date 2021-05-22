package handlers;
import models.Player;
import models.Round;
import models.Set;


public class RoundHandler {
    private Round round;
    private int currentPlayer = 0;
    private int currentSet = 0;
    public int totalPins = 10;
    private GameHandler gameHandler;
    private int maxSets;

    public RoundHandler(GameHandler gameHandler, Round round, int maxSets) {
        this.gameHandler = gameHandler;
        this.round = round;
        this.maxSets = maxSets;
    }

    public GameHandler getHandler(){
        return gameHandler;
    }

    public void startRound(){
//        System.out.println( "Set " + currentSet);
        Player player = round.getTeam().getPlayerList().get(currentPlayer);
        SetHandler setHandler = new SetHandler(this, new Set(this.currentSet, player, round.getLane()), totalPins, maxSets);
        setHandler.handleSet();
    }

    public void changeSet(int totalPins){
        if (currentSet < maxSets) {
            this.currentSet++;
            this.totalPins = totalPins;
            startRound();
        }
    }

    public void changePlayer() {
        this.totalPins = 10;
        if (this.currentPlayer < round.getTeam().getPlayerList().size()-1) {
            this.currentPlayer++;
            this.currentSet = 0;
            this.startRound();
        } else{
            this.gameHandler.changeRound();
        }
    }
}
