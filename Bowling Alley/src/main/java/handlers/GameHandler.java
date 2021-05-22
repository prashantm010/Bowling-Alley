package handlers;
import models.Game;
import models.Lane;
import models.Player;
import models.Round;
import storage.GameQueue;
import storage.LaneQueue;

public class GameHandler implements CompleteGame {
    private static final int MaxRounds = 10;
    private int currentRound;
    private Game game;
    private Alley alley;
    public static final int maxSets = 2;
    public static final int maxFinalSets = 3;



    public GameHandler(Alley alley, Game game) {
        this.game = game;
        this.alley = alley;
    }

    public void startGame(){
        this.currentRound = 0;
        this.startRound();
    }

    private void startRound(){
//        System.out.println("Round " + currentRound);
        RoundHandler roundHandler;
        if (currentRound == MaxRounds-1) {
            roundHandler = new RoundHandler(this, new Round(this.currentRound, game.getLane(), game.getTeam()), maxFinalSets);
        } else{
            roundHandler = new RoundHandler(this, new Round(this.currentRound, game.getLane(), game.getTeam()), maxSets);
        }
        roundHandler.startRound();
    }

    public void changeRound(){
        if (currentRound < MaxRounds-1) {
            this.currentRound++;
            startRound();
        } else{
            completeGame();
            this.alley.changeGame();
        }
    }

    public void completeGame(){
        Player player = getWinner();
        if (player != null) {
            System.out.println("----------------Winner Winner Chicken Dinner--------------");
            System.out.println(player.getName() + ' ' + player.getScore() + " Team " + game.getTeam());
        }
        Lane lane = game.getLane();
        LaneQueue.getInstance().updateLane(lane);
        GameQueue.getInstance().updateGame(game);
    }

    private Player getWinner(){
        int maxScore = -1;
        for (Player player: game.getTeam().getPlayerList()){
            if (player.getScore() > maxScore){
                return player;
            }
        }
        return null;
    }
}
