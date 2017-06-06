package Main;

import gui.*;
import model.*;
import java.io.IOException;

/**
 * Created by lukemann on 5/24/17.
` */
public class Main {
    public static void main(String[] args) throws IOException {
        GameFrame gameframe = new GameFrame();
        DiceBarPanel BarPanel = new DiceBarPanel();
        ScoreboardPanel board = new ScoreboardPanel();
        
        gameframe.setDiceBarPanel(BarPanel);
        gameframe.setScoreBoardPanel(board);
        gameframe.pack();
        gameframe.setVisible(true);
    }
}
