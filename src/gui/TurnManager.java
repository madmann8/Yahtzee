package gui;

/**
 * Created by lukemann on 6/2/17.
 */
public class TurnManager {

    public static TurnManager singleton = new TurnManager(0);

    private int players = 0;




    public TurnManager(int players) {
        this.players = players;

    }

    public int getNextIndex() {
        return 2;
    }
}
