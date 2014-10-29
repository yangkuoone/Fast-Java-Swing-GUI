// David McKay
// 30 August 2014
// Coding for the greater good and trying to make my own text editor
// (Does not support color text | also will be adding an area that is
//  easier for rapid GUI prototypes)
package guigrouplayoutbuilder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImportModule extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|

	private JTextArea importArea;
   
   final public Dimension textAreaDimension = new Dimension( 526, 50);
   
	//--------------------------------------------------------------------------|

	public ImportModule( ){

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

		JLabel importLabel = new JLabel( "Import:" );
		importArea = new JTextArea( );
      importArea.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
      JScrollPane scrollImportArea = new JScrollPane( importArea );
      scrollImportArea.setMaximumSize( textAreaDimension );
      scrollImportArea.setMinimumSize( textAreaDimension );
      
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
		      .addComponent( importLabel ));
      
      hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( scrollImportArea ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( importLabel )
            .addComponent( scrollImportArea ));

		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}
   
   public String getImport( ){
      return( importArea.getText() );
   }
   
   public void insertImport( String importStr ){
      importArea.insert( importStr, importArea.getCaretPosition() );
   }
}