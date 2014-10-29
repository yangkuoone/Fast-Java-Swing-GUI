// David McKay
// 29 August 2014
// Coding for the greater good and trying to make my own text editor
// (Does not support color text | also will be adding an area that is
//  easier for rapid GUI prototypes)

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CreateClassModule extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|
   
   private ImportModule importPanel;
	private ClassNameModule classPanel;
	private VariableModule variablePanel;
   private FunctionModule functionPanel;
   private JButton processDefaultConstructor;
   private JButton processEntireClass;
   
   private JTextArea _display;
   private ActionListener defaultConstructorAction;
   private ActionListener entireClassAction;  
	//--------------------------------------------------------------------------|

	public CreateClassModule( JTextArea display ){

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
      
      JLabel importLabel = new JLabel( "Import Information:" );
      importPanel = new ImportModule( );
      
      JLabel classLabel = new JLabel( "Class Information:" );
		classPanel = new ClassNameModule( );
		
      JLabel variableLabel = new JLabel( "Variable Information:" );
		variablePanel = new VariableModule( );
      
      JLabel functionLabel = new JLabel( "Function Information:" );
      functionPanel = new FunctionModule( );
      
      processDefaultConstructor = new JButton( "Create Default Constructor" );
      processDefaultConstructor.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      processDefaultConstructor.setToolTipText( "Press this button to process a default constructor. (Only when you are done with all the variables)" );
      
      processEntireClass = new JButton( "Create Class" );
      processEntireClass.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      processEntireClass.setToolTipText( "Press this button to process the entire class, when you are done." );
      
      defaultConstructorAction = new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton){
               insertConstructor( processDefaultConstructor() );
            }
         }
      };
      
      processDefaultConstructor.addActionListener( defaultConstructorAction );
      
      entireClassAction = new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton){
               
               _display.insert( processEntireClass(), _display.getCaretPosition() );
               _display.requestFocusInWindow();
            }
         }
      };
      
      processEntireClass.addActionListener( entireClassAction );
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
            .addComponent( importLabel )
            .addComponent( importPanel )
            .addComponent( classLabel )
		      .addComponent( classPanel )
            .addComponent( variableLabel )
		      .addComponent( variablePanel )
            .addComponent( processDefaultConstructor )
		      .addComponent( functionLabel )
            .addComponent( functionPanel )
            .addComponent( processEntireClass ));
      
      vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( importLabel ));
            
      vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( importPanel ));
                  
      vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( classLabel ));
      
		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( classPanel ));
      
      vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( variableLabel ));
      
		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( variablePanel ));
      
      vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( processDefaultConstructor ));
      
      vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( functionLabel ));
      
		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( functionPanel ));
      
      vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( processEntireClass ));
            
		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}
   
   // Import:
   public String getImport( ){
      return( importPanel.getImport() );
   }
   
   public void insertImport( String importStr ){
      importPanel.insertImport( importStr );
   }
   
   // Class Header:
   public String getClassHeader( ){
      return( classPanel.toString() );
   }
   
   public void setName( String nameStr ){
      classPanel.setName( nameStr );
   }
   
   public void setExtends( String extendsStr ){
      classPanel.setExtends( extendsStr );
   }
   
   public void setImplements( String implementsStr ){
      classPanel.setImplements( implementsStr );
   }
   
   // Class Variable:
   public String getInstanceVariables( ){
      return( variablePanel.getInstanceVariables() );
   }
   
   public void insertInstanceVariables( String instanceVariablesStr ){
      variablePanel.insertIntanceVariables( instanceVariablesStr );
   }
   
   public String getInitializingInstanceVariables( ){
      return( variablePanel.getInitializingInstanceVariables() );
   }
    
   public String getConstantVariables( ){
      return( variablePanel.getConstantVariables() );
   }
   
   public void insertConstantVariables( String insertConstantVariablesStr ){
      variablePanel.insertConstantVariables( insertConstantVariablesStr );
   }
   
   // Class Functions:
   public String getConstructor( ){
      return( functionPanel.getConstructor() );
   }
   
   public void insertConstructor( String insertConstructorStr){
      functionPanel.insertConstructor( insertConstructorStr );
   }
   
   public String getAccessor( ){
      return( functionPanel.getAccessor() );
   }
   
   public void insertAccessor( String insertAccessorStr ){
      functionPanel.insertAccessor( insertAccessorStr );
   }
   
   public String getMutator( ){
      return( functionPanel.getMutator() );
   }
   
   public void insertMutator( String insertMutatorStr){
      functionPanel.insertMutator( insertMutatorStr );
   }
   
   public String getImplementation( ){
      return( functionPanel.getImplementation() );
   }
   
   public void insertImplementation( String insertImplementationStr ){
      functionPanel.insertImplementation( insertImplementationStr );
   }
   
   // Action:
   public String processDefaultConstructor( ){
      String outputStr = "\n";
      Scanner keyboard = new Scanner( getClassHeader() );
      
      //public
      if(keyboard.hasNext())
         outputStr += '\t' + keyboard.next();
      
      //class
      if(keyboard.hasNext())
         keyboard.next();
      
      //name      
      if(keyboard.hasNext())
         outputStr += ' ' + keyboard.next();
         
      if(!outputStr.contains( "{" ))   
         outputStr += "( ){";
         
      outputStr += '\n' + getInitializingInstanceVariables();
      outputStr += "\n\t}\n";
      
      return( outputStr );
   }
   
   public String processEntireClass( ){
      String outputStr = getImport( ) + '\n';
      
      String commentLine1Tab = "//---------------------------------------------------------------------------|";
      
      outputStr += getClassHeader();
      
      outputStr += "\n\t// Instance Variables:\n";
      outputStr += '\t' + commentLine1Tab + '\n';
      outputStr += getInstanceVariables();
      outputStr += "\n\n\t" + commentLine1Tab;
            
      outputStr += "\n\n\t// Class CONSTANTS:\n";
      outputStr += '\t' + commentLine1Tab + '\n';
      outputStr += getConstantVariables();
      outputStr += "\n\n\t" + commentLine1Tab;
      
      outputStr += "\n\n\t// Constructor:\n";
      outputStr += '\t' + commentLine1Tab + '\n';
      outputStr += getConstructor();
      outputStr += "\n\t" + commentLine1Tab;
      
      outputStr += "\n\n\t// Accessor:\n";
      outputStr += '\t' + commentLine1Tab + '\n';
      outputStr += getAccessor();
      outputStr += "\n\t" + commentLine1Tab;
      
      outputStr += "\n\n\t// Mutator:\n";
      outputStr += '\t' + commentLine1Tab + '\n';
      outputStr += getMutator();
      outputStr += "\n\t" + commentLine1Tab;
      
      outputStr += "\n\n\t// Private Implementation:\n";
      outputStr += '\t' + commentLine1Tab + '\n';
      outputStr += getImplementation();
      outputStr += "\n\t" + commentLine1Tab + '\n';
      
      outputStr += '}';
      
      return( outputStr );
   }
}