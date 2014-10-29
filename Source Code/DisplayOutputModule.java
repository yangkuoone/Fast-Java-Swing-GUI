//Author: David McKay
//Date: 9/3/2014
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DisplayOutputModule extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|

	private JTextArea _display;
	private JButton clearButton;
   
   private ActionListener clearAction;
	//--------------------------------------------------------------------------|

	public DisplayOutputModule( JTextArea display ){

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

		_display = display;
      JScrollPane scrollDisplay = new JScrollPane( _display );
		clearButton = new JButton( "Clear the Text." );
      
      clearAction = new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton){
               
               clearText();
               _display.requestFocusInWindow();
               
            }
         }
      };
      
      clearButton.addActionListener( clearAction );
      
		//-----------------------------------------------------------------------|

		//Setting the Components in the Group to make a Line: 1 2 ... (Automated)
		//-----------------------------------------------------------------------|

		//Setup the Group Connections Here.
		//Hint: When Implementing it goes like this.

		//	hGrp	hGrp	hGrp	hGrp
		//	1	2	3	4	   verticalGroup
		//	5	6	7	8	   verticalGroup
		//	9	10	11	12	   verticalGroup

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( scrollDisplay )
		      .addComponent( clearButton ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( scrollDisplay ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( clearButton ));

		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}
   
   public void clearText( ){
      _display.setText( "" );
   }
   
   public void setText( String text ){
      _display.setText( text );
   }

   public void insertText( String text ){
      _display.insert( text, _display.getCaretPosition() );
   }
}