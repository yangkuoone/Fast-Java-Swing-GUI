package discretemathematicsgui;
//Author: David McKay
//Date: 8/15/2014

//Designed for making Discretemathematics Symbol to be entered fast and simple.
//Not much too it, just point and click to insert the Symbols at the end.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiscreteMathematicsSymbols extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|
   
	private JButton[] symbolAt;
   
   private JTextArea _display;

	//--------------------------------------------------------------------------|

	public DiscreteMathematicsSymbols( JTextArea display ){

		//Setting the layout:
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);

		//Initializing Group Layout:
		//-----------------------------------------------------------------------|
		// Turn on automatically adding gaps between components
		layout.setAutoCreateGaps(true);

		// Turn on automatically creating gaps between components that touch
		// the edge of the container and the container.
		layout.setAutoCreateContainerGaps(true);

		// Create a sequential group for the horizontal axis.
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

		// Create a sequential group for the vertical axis.
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

		//-----------------------------------------------------------------------|

		//Initializing Object:( Automated )
		//-----------------------------------------------------------------------|

		JLabel logicLabel = new JLabel( "Logic Symbols:" );
		JLabel setTheoryLabel = new JLabel( "Set Theory Symbols:" );
		JLabel mathLabel = new JLabel( "Math Symbols:" );
		JLabel specialSetsLabel = new JLabel( "Special Sets Symbols:" );
      
		symbolAt = new JButton[30];
      _display = display;
      
      //Logic Symbols:
      symbolAt[0] = new JButton( "\u00AC" ); //Not Symbol
      symbolAt[1] = new JButton( "\u2228" ); //Or Symbol
      symbolAt[2] = new JButton( "\u2227" ); //And Symbol
      
      symbolAt[3] = new JButton( "\u2192" ); //if-then Symbol
      symbolAt[4] = new JButton( "\u2261" ); //logically equivalent Symbol
      symbolAt[5] = new JButton( "\u220B" ); //Such that Symbol
      
      symbolAt[6] = new JButton( "\u2200" ); //For all Symbol
      symbolAt[7] = new JButton( "\u2203" ); //There exist Symbol
      symbolAt[8] = new JButton( "\u2234" ); //Therefore Symbol
      
      //Set Theory Symbols:
      symbolAt[9] = new JButton( "\u2208" ); // element of Symbol
      symbolAt[10] = new JButton( "\u2209" ); // not an element of Symbol
      symbolAt[11] = new JButton( "\u2286" ); // subset of Symbol
      
      symbolAt[12] = new JButton( "\u2282" ); // proper subset of Symbol
      symbolAt[13] = new JButton( "\u222A" ); // union Symbol
      symbolAt[14] = new JButton( "\u2229" ); // intersection Symbol
      
      symbolAt[15] = new JButton( "\u2205" ); // empty set Symbol
      symbolAt[16] = new JButton( "\u2223" ); // Absolute Bar Symbol
      symbolAt[17] = new JButton( "\u220E" ); // End of Proof Symbol
      
      //Math Symbols:
      symbolAt[18] = new JButton( "\u2260" ); // Not Equal Symbol
      symbolAt[19] = new JButton( "\u2264" ); // Less than or equal Symbol
      symbolAt[20] = new JButton( "\u2265" ); // Greater than or equal Symbol
      
      symbolAt[21] = new JButton( "\u2248" ); // approximately Symbol
      symbolAt[22] = new JButton( "\u00B1" ); // plus or minus Symbol
      
      //Special Sets Symbols:
      symbolAt[23] = new JButton( "\u2115" ); // Natural Number Symbol
      symbolAt[24] = new JButton( "\u2124" ); // Set of Integers Symbol
      symbolAt[25] = new JButton( "\u211A" ); // Rational Number Symbol
      
      symbolAt[26] = new JButton( "A" ); // Algebraic Number Symbol
      symbolAt[27] = new JButton( "\u211D" ); // Real Number Symbol
      symbolAt[28] = new JButton( "\u2102" ); // Complex Number Symbol
      
      symbolAt[29] = new JButton( "\u2119" ); // Prime Number Symbol
      
      //Adding ActionListener for action: (Will be used with teh Buttons)
      ActionListener action = new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton){
               JButton temp = (JButton)e.getSource();
               
               _display.insert( temp.getText(), _display.getCaretPosition() );
               _display.requestFocusInWindow();
            }
         }
      };
                  
      //Chaning the Font Size and adding the Action Listener: (action)
      for(int i = 0; i < symbolAt.length; i++){
         symbolAt[i].setFont(new Font("New Times Roman", Font.PLAIN, 12));
         symbolAt[i].addActionListener(action);
      }
      
		//-----------------------------------------------------------------------|

		//Setting the Components in the Group to make a Line: 1 2 ... (Automated)
		//-----------------------------------------------------------------------|

		//Setup the Group Connections Here.
		//Hint: When Implementing it goes like this.

		//	hGrp	hGrp	hGrp	hGrp
		//	1	   2	   3	   4	   verticalGroup
		//	5	   6	   7	   8	   verticalGroup
		//	9	   10	   11	   12	   verticalGroup

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( logicLabel )
		      .addComponent( setTheoryLabel ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[0] )
		      .addComponent( symbolAt[3] )
		      .addComponent( symbolAt[6] )
		      .addComponent( symbolAt[9] )
		      .addComponent( symbolAt[12] )
		      .addComponent( symbolAt[15] ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[1] )
		      .addComponent( symbolAt[4] )
		      .addComponent( symbolAt[7] )
		      .addComponent( symbolAt[10] )
		      .addComponent( symbolAt[13] )
		      .addComponent( symbolAt[16] ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[2] )
		      .addComponent( symbolAt[5] )
		      .addComponent( symbolAt[8] )
		      .addComponent( symbolAt[11] )
		      .addComponent( symbolAt[14] )
		      .addComponent( symbolAt[17] ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( mathLabel )
		      .addComponent( specialSetsLabel ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[18] )
		      .addComponent( symbolAt[21] )
		      .addComponent( symbolAt[23] )
		      .addComponent( symbolAt[26] )
		      .addComponent( symbolAt[29] ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[19] )
		      .addComponent( symbolAt[22] )
		      .addComponent( symbolAt[24] )
		      .addComponent( symbolAt[27] ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[20] )
		      .addComponent( symbolAt[25] )
		      .addComponent( symbolAt[28] ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( logicLabel )
		      .addComponent( symbolAt[0] )
		      .addComponent( symbolAt[1] )
		      .addComponent( symbolAt[2] )
		      .addComponent( mathLabel )
		      .addComponent( symbolAt[18] )
		      .addComponent( symbolAt[19] )
		      .addComponent( symbolAt[20] ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[3] )
		      .addComponent( symbolAt[4] )
		      .addComponent( symbolAt[5] )
		      .addComponent( symbolAt[21] )
		      .addComponent( symbolAt[22] ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[6] )
		      .addComponent( symbolAt[7] )
		      .addComponent( symbolAt[8] ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( setTheoryLabel )
		      .addComponent( symbolAt[9] )
		      .addComponent( symbolAt[10] )
		      .addComponent( symbolAt[11] )
		      .addComponent( specialSetsLabel )
		      .addComponent( symbolAt[23] )
		      .addComponent( symbolAt[24] )
		      .addComponent( symbolAt[25] ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[12] )
		      .addComponent( symbolAt[13] )
		      .addComponent( symbolAt[14] )
		      .addComponent( symbolAt[26] )
		      .addComponent( symbolAt[27] )
		      .addComponent( symbolAt[28] ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( symbolAt[15] )
		      .addComponent( symbolAt[16] )
		      .addComponent( symbolAt[17] )
		      .addComponent( symbolAt[29] ));

		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}
}