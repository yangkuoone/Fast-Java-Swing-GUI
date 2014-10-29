package discretemathematicsgui;
//Author: David McKay
//Date: 8/15/2014

//Designed for making Discretemathematics Symbol to be entered fast and simple.
//Not much too it, just point and click to insert the Symbols at the end.

import java.awt.*;
import javax.swing.*;

public class DiscreteMathematicsDisplayArea extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|

	private JTextArea _textArea;

	//--------------------------------------------------------------------------|

	public DiscreteMathematicsDisplayArea( JTextArea textArea ){

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

		_textArea = textArea;
		JScrollPane textAreaScroll = new JScrollPane( _textArea );

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
		      .addComponent( textAreaScroll ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( textAreaScroll ));

		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}

}