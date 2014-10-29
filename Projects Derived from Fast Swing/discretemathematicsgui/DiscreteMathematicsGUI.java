package discretemathematicsgui;
//Author: David McKay
//Date: 8/15/2014

//Designed for making Discretemathematics Symbol to be entered fast and simple.
//Not much too it, just point and click to insert the Symbols at the end.

//GUI trying out how the JComponents on how they work out together and 
// over lapping some areas or not to get a better feel; For Windowed Style Programming.

import java.awt.*;
import javax.swing.*;

public class DiscreteMathematicsGUI{

   public static void main( String[] args){
      
      JFrame runGUI = new JFrame();
      JTextArea displayArea = new JTextArea();
      displayArea.setFont(new Font("New Times Roman", Font.PLAIN, 12));
      
      JPanel holdSymbol = new JPanel();
      
      DiscreteMathematicsDisplayArea dmArea = new DiscreteMathematicsDisplayArea( displayArea );
      DiscreteMathematicsSymbols dmSymbol = new DiscreteMathematicsSymbols( displayArea );
      holdSymbol.add( dmSymbol );
      
      JSplitPane splitPane = new JSplitPane( JSplitPane.VERTICAL_SPLIT, holdSymbol, dmArea );      
      JScrollPane holdSplit = new JScrollPane( splitPane );
      
      runGUI.add( holdSplit );
      runGUI.setSize( 625, 725 );
      runGUI.setTitle( "Discrete Mathematics Fast Symbols." );
      runGUI.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      runGUI.setVisible( true );
   }
}