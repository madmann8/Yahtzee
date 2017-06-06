package gui;
import javax.swing.*;
import model.*;
/**
 * Created by lukemann on 5/26/17.
 */
public class ScoreboardGui {
   private Scoreboard board;
   public ScoreboardGui(Scoreboard myBoard)
   {
       board = myBoard;
   }
   public void configure(ScoreboardPanel panel)
   {
       JTable upper = panel.getUpperBoard();
       JTable lower = panel.getLowerBoard();
       
       upper.setValueAt((Integer)3, 2, 1);
   }
   
}
