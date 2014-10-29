// David McKay
// 29 August 2014
// Coding for the greater good and trying to make my own text editor
// (Does not support color text | also will be adding an area that is
//  easier for rapid GUI prototypes)
package guigrouplayoutbuilder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FunctionModule extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|

	private JTextArea constructorArea;
	private JTextArea accessorArea;
	private JTextArea mutatorArea;
	private JTextArea implementationArea;
   
   final public Dimension textAreaDimension = new Dimension( 475, 100);
   
	//--------------------------------------------------------------------------|

	public FunctionModule( ){

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
      
      //Constructor:
		JLabel constructorLabel = new JLabel( "Constructor:" );
		constructorArea = new JTextArea( );
      constructorArea.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
		JScrollPane scrollConstructorArea = new JScrollPane( constructorArea );
      scrollConstructorArea.setMaximumSize( textAreaDimension );
      scrollConstructorArea.setMinimumSize( textAreaDimension );
      
      //Accessor:
      JLabel accessorLabel = new JLabel( "Accessor:" );
		accessorArea = new JTextArea( );
      accessorArea.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
		JScrollPane scrollAccessorArea = new JScrollPane( accessorArea );
      scrollAccessorArea.setMaximumSize( textAreaDimension );
      scrollAccessorArea.setMinimumSize( textAreaDimension );
      
      //Mutator:
      JLabel mutatorLabel = new JLabel( "Mutator:" );
		mutatorArea = new JTextArea( );
      mutatorArea.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
		JScrollPane scrollMutatorArea = new JScrollPane( mutatorArea ); 
      scrollMutatorArea.setMaximumSize( textAreaDimension );
      scrollMutatorArea.setMinimumSize( textAreaDimension );
      
      //Implementation:
      JLabel implementationLabel = new JLabel( "Implementation:" );
		implementationArea = new JTextArea( );
      implementationArea.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
      JScrollPane scrollImplementationArea = new JScrollPane( implementationArea );
      scrollImplementationArea.setMaximumSize( textAreaDimension );
      scrollImplementationArea.setMinimumSize( textAreaDimension );
      
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
		      .addComponent( constructorLabel )
		      .addComponent( accessorLabel )
		      .addComponent( mutatorLabel )
		      .addComponent( implementationLabel ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( scrollConstructorArea )
		      .addComponent( scrollAccessorArea )
		      .addComponent( scrollMutatorArea )
		      .addComponent( scrollImplementationArea ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( constructorLabel)
		      .addComponent( scrollConstructorArea ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( accessorLabel )
		      .addComponent( scrollAccessorArea ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( mutatorLabel )
		      .addComponent( scrollMutatorArea ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( implementationLabel )
		      .addComponent( scrollImplementationArea ));

		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}
   
   /**
   * This method will just get the Text Area and give it to what ever requires it.
   * Can't Police the world.
   */
   public String getConstructor(){
      return( constructorArea.getText() );
   }
   
   public void insertConstructor( String constructorStr ){
      constructorArea.insert( constructorStr, constructorArea.getCaretPosition() );
   }
   
   /**
   * This method will just get the Text Area and give it to what ever requires it.
   * Can't Police the world.
   */
   public String getAccessor(){
      return( accessorArea.getText() );
   }
   
   public void insertAccessor( String accessorStr ){
      accessorArea.insert( accessorStr, accessorArea.getCaretPosition() );
   }
   
   /**
   * This method will just get the Text Area and give it to what ever requires it.
   * Can't Police the world.
   */
   public String getMutator(){
      return( mutatorArea.getText() );
   }
   
   public void insertMutator( String mutatorStr ){
      mutatorArea.insert( mutatorStr, mutatorArea.getCaretPosition() );
   }
   
   /**
   * This method will just get the Text Area and give it to what ever requires it.
   * Can't Police the world.
   */
   public String getImplementation(){
      return( implementationArea.getText() );
   }
   
   public void insertImplementation( String implementationStr ){
      implementationArea.insert( implementationStr, implementationArea.getCaretPosition() );
   }
   
}