// David McKay
// 29 August 2014
// Coding for the greater good and trying to make my own text editor
// (Does not support color text | also will be adding an area that is
//  easier for rapid GUI prototypes)
package guigrouplayoutbuilder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClassNameModule extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|

	private JTextField classNameField;
	private JTextField extendsField;
	private JTextField implementsField;
   
   final public Dimension textAreaDimension = new Dimension( 496, 25);
   
	//--------------------------------------------------------------------------|

	public ClassNameModule( ){

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

		JLabel classNameLabel = new JLabel( "Name:" );
		classNameField = new JTextField( );
      classNameField.setMaximumSize( textAreaDimension );
      classNameField.setMinimumSize( textAreaDimension );
      classNameField.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
		JLabel extendsLabel = new JLabel( "Extends:" );
		extendsField = new JTextField( );
      extendsField.setMaximumSize( textAreaDimension );
      extendsField.setMinimumSize( textAreaDimension );
      extendsField.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
      JLabel implementsLabel = new JLabel( "Implements:" );
		implementsField = new JTextField( );
      implementsField.setMaximumSize( textAreaDimension );
      implementsField.setMinimumSize( textAreaDimension );
      implementsField.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
		//-----------------------------------------------------------------------|

		//Setting the Components in the Group to make a Line: 1 2 ... (Automated)
		//-----------------------------------------------------------------------|

		//Setup the Group Connections Here.
		//Hint: When Implementing it goes like this.

		//	hGrp	hGrp	hGrp	hGrp
		//	1  2	3	4	   verticalGroup
		//	5	6	7	8	   verticalGroup
		//	9	10	11	12	   verticalGroup

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( classNameLabel )
		      .addComponent( extendsLabel )
		      .addComponent( implementsLabel ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( classNameField )
		      .addComponent( extendsField )
		      .addComponent( implementsField ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( classNameLabel )
		      .addComponent( classNameField ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( extendsLabel )
		      .addComponent( extendsField ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( implementsLabel )
		      .addComponent( implementsField ));

		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}
   
   /**
   * This method will format the entered fields into the desired output.
   */
   @Override
   public String toString(){
      String outputStr = "public class ";
      
      outputStr += classNameField.getText();
      
      if( !extendsField.getText().equals( "" ) )
         outputStr += " extends " + extendsField.getText();
           
      if( !implementsField.getText().equals( "" ) )
         outputStr += " implements " + implementsField.getText();
         
      outputStr += "{\n";
      
      return( outputStr );
   }
   
   public String getName( ){
      return( classNameField.getText() );
   }
   
   public void setName( String nameStr ){
      classNameField.setText( nameStr );
   }
   
   public String getExtends( ){
      return( extendsField.getText() );
   }
   
   public void setExtends( String extendsStr ){
      extendsField.setText( extendsStr );
   }
   
   public String getImplements( ){
      return( implementsField.getText() );
   }
   
   public void setImplements( String implementsStr ){
      implementsField.setText( implementsStr );
   }
}