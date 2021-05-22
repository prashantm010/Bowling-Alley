package handlers;

import models.Set;


public class SetHandler {
    private Set set;
    private int maxSets;
    public int totalPins;
    private RoundHandler roundHandler;

    public SetHandler(RoundHandler roundHandler, Set set, int totalPins, int maxSets) {
        this.roundHandler = roundHandler;
        this.set = set;
        this.maxSets = maxSets;
        this.totalPins = totalPins;
    }

    public RoundHandler getHandler(){
        return roundHandler;
    }

    public void handleSet(){
        PlayerHandler playerHandler = new PlayerHandler(this, set);
        int score = playerHandler.playGame(totalPins);
//        System.out.println("Player "+ set.getPlayer());
        if (set.getPlayer().getScore() == 10 || set.getSet() == maxSets-1) {
            nextPlayer();
        } else {
            totalPins = totalPins - score;
            this.roundHandler.changeSet(totalPins);
        }
    }

    public void nextPlayer(){
        this.roundHandler.changePlayer();
    }
}
