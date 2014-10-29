//Author: David McKay
//Date: 9/4/2014
package guigrouplayoutbuilder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GroupLayoutModule extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|
   
   private JLabel classLabel;
   private JTextField classField;
	private JLabel instanceLabel;
	private GroupInstanceModule instanceModule;
	private JLabel tableLabel;
	private GroupTableModule tableModule;
	private JButton transferData;
   
   private CreateClassModule _classModule;
   
   private ActionListener transferAction;
	//--------------------------------------------------------------------------|

	public GroupLayoutModule( CreateClassModule classModule ){

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
      
      _classModule = classModule;
      
		classLabel = new JLabel( "Class Name:" );
      classField = new JTextField( );
      classField.setMaximumSize( new Dimension( 600, 16));
      classField.setMinimumSize( new Dimension( 600, 16));
      
      classField.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      instanceLabel = new JLabel( "Instance Variables:" );
		instanceModule = new GroupInstanceModule( );
      tableLabel = new JLabel( "Enter the Variable Names:" );
		tableModule = new GroupTableModule( );
		transferData = new JButton( "Transfer Data" );
      
      transferAction = new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton){
               
               //Import: (Done)
               _classModule.insertImport( "import java.awt.*;\nimport java.awt.event.*;\nimport javax.swing.*;\n" );
               
               //Name and Extends: (Done)
               _classModule.setName( classField.getText() );
               _classModule.setExtends( "JPanel" );
               
               //Instance Area: (Done)
               _classModule.insertInstanceVariables( instanceModule.getInstanceArea() );
              
               //Constant Area: (Done)
               _classModule.insertConstantVariables( "Dimension textFieldDimension = new Dimension( 435, 16 );\nDimension textAreaDimension = new Dimension( 435, 100);\n\nFont textFieldFont = new Font(\"Lucida Console\" , Font.PLAIN, 12);\nFont textAreaFont = new Font(\"Lucida Console\" , Font.PLAIN, 12);" );
               
               // Default Constructor: (Done)
               _classModule.insertConstructor( getDefaultConstructor() );
              
               // Create Functions Based off of the Objects: (Accessor, Mutator, Implementation)
                  // Make a Function that retrieves the Instance Variables and decide to make the
                  //  following functions listed above ( ).
                  
               //Just use this inside the function to keep it simple.
               processAccessor( instanceModule.getInstanceArea() );
               processMutator( instanceModule.getInstanceArea() );
               _classModule.insertImplementation( "\n\tpublic static void main(String[] args){" + 
                                                  "\n\t\tJFrame runGUI = new JFrame( );" +
                                                  "\n\t\tJScrollPane scroll" + classField.getText() + " = new JScrollPane(" + " new " + classField.getText() + "( ) );" +
                                                  "\n\t\trunGUI.add( scroll" + classField.getText()+ " );" + 
                                                  "\n\t\trunGUI.setSize( 810, 980 );" + 
                                                  "\n\t\trunGUI.setTitle( \"Testing the Automated " + classField.getText() + ".\" );" + 
                                                  "\n\t\trunGUI.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );" +
                                                  "\n\t\trunGUI.setVisible( true );" + 
                                                  "\n\t}\n" );
               
            }
         }
      };
      
      transferData.addActionListener( transferAction );
      
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
                      .addComponent( classLabel )
                      .addComponent( classField )
		      .addComponent( instanceLabel )
		      .addComponent( instanceModule )
		      .addComponent( tableLabel )
		      .addComponent( tableModule )
		      .addComponent( transferData ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( classLabel ));
            
		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( classField ));
            
		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( instanceLabel ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( instanceModule ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( tableLabel ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( tableModule ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( transferData ));

		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}
   
   private String getDefaultConstructor( ){
      String outputStr = "\n\t";
      String temp = _classModule.getClassHeader();
      
      Scanner keyboard = new Scanner( temp );
      
      //Header: public Foo( ){
      //----------------------------------------------------------------------|
      //Getting public
      if(keyboard.hasNext() ){
         temp = keyboard.next();
         
         if(keyboard.hasNext())
            keyboard.next(); //Throw away "class".
      }
      //Getting class name
      if(keyboard.hasNext() ){
         temp += " " + keyboard.next();
      }
      // formatting the header:
      if( !( temp.contains( "( )" ) || temp.contains( "()" )) ){
         temp += "( )";
      }
      if(!temp.contains( "{" ))   
         temp += '{';
      
      //Header is formatted:
      outputStr += temp;
      //----------------------------------------------------------------------|
      
      //Layout Initialize:
      outputStr += BEFORE_INITIALIZING;
      
      //Getting the Initialization of the Instance Variables:
      outputStr += _classModule.getInitializingInstanceVariables();
      
      outputStr += "\n";
      
      outputStr += processCustomInstance( instanceModule.getInstanceArea() );
      
      //Layout Finish:
      outputStr += BEFORE_COMPONENT;
      
      //Getting the Layout: (Heart of the Application)
      outputStr += tableModule.processTable();
      
      outputStr += COMPLETE;
      
      outputStr += "\n\t}\n";
      
      return( outputStr );
   }
   
   final private static String BEFORE_INITIALIZING =
		"\n\n\t\t//Setting the layout:\n\t\t" +
   	"GroupLayout layout = new GroupLayout(this);\n\t\t" +
		"setLayout(layout);\n\n\t\t" +
   	"//Initializing Group Layout:\n\t\t" +
		"//--------------------------------------------------------------------------|\n\t\t" +
		"// Turn on automatically adding gaps between components\n\t\t" +
		"layout.setAutoCreateGaps(true);\n\n\t\t" +
		"// Turn on automatically creating gaps between components that touch\n\t\t" +
		"// the edge of the container and the container.\n\t\t" +
		"layout.setAutoCreateContainerGaps(true);\n\n\t\t" +
		"// Create a sequential group for the horizontal axis.\n\t\t" +
		"GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();\n\n\t\t" +
		"// Create a sequential group for the vertical axis.\n\t\t" +
		"GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();\n\n\t\t" +
   	"//--------------------------------------------------------------------------|\n\n\t\t" +
   	"//Initializing Object:( Automated )\n\t\t" +
		"//--------------------------------------------------------------------------|\n";
   
   final private static String BEFORE_COMPONENT =
      "\n\t\t//--------------------------------------------------------------------------|\n\n\t\t" +
		"//Setting the Components in the Group to make a Line: 1 2 ... (Automated)\n\t\t" +
		"//--------------------------------------------------------------------------|\n\n\t\t" +
		"//Setup the Group Connections Here.\n\t\t" +
		"//Hint: When Implementing it goes like this.\n\n\t\t" +
		"//	hGrp	hGrp	hGrp	hGrp\n\t\t" +
		"//	1	2	3	4	   verticalGroup\n\t\t" +
		"//	5	6	7	8	   verticalGroup\n\t\t" +
		"//	9	10	11	12	   verticalGroup\n\n";
   
   final private static String COMPLETE =
      "\t\t//--------------------------------------------------------------------------|\n\n\t\t" +
   	"layout.setHorizontalGroup(hGroup);\n\t\t" +
   	"layout.setVerticalGroup(vGroup);";
   
   private void processAccessor( String instanceVariables ){
      //first Object | second obj
      String outputStr = "";
      Scanner line = new Scanner( instanceVariables );
      
      while( line.hasNextLine() ){
         outputStr += formatAccessor( line.nextLine() );
      }
      
      _classModule.insertAccessor( outputStr );
   }
   
   private void processMutator( String instanceVariables ){
      //first Object | second obj
      String outputStr = "";
      Scanner line = new Scanner( instanceVariables );
      
      while( line.hasNextLine() ){          
         outputStr += formatMutator( line.nextLine() );
      }
      _classModule.insertMutator( outputStr );
   }
   
   private String processCustomInstance( String instanceVariables ){
      //first Object | second obj
      String outputStr = "";
      Scanner line = new Scanner( instanceVariables );
      
      while( line.hasNextLine() ){          
         outputStr += formatCustomInstance( line.nextLine() );
      }
      
      return( outputStr );
   }
   
   //Support Classes: JTextField, JTextArea
   private String formatAccessor( String objectStr ){
      Scanner consumeToken = new Scanner( objectStr );
      String objectType = null;
      String objectName = null;
      String outputStr = "";
      
      if(consumeToken.hasNext()){
         objectType = consumeToken.next();
         if(consumeToken.hasNext()){
            objectName = consumeToken.next();
         }
         
         //If supported format it, else return "".
         if(objectType.equals( "JTextField" ) || objectType.equals( "JTextArea" )){
            
               outputStr += "\n\tpublic String get" + objectName.toUpperCase().charAt(0) + objectName.substring(1) +"( ){\n\n\t\treturn( " + 
                  objectName + ".getText() );\n\t}\n" ;
         }else{
            return( "" );
         }
      }
      return( outputStr );
   }
   
   //Support Classes: JTextField, JTextArea
   private String formatMutator( String objectStr ){
      Scanner consumeToken = new Scanner( objectStr );
      String objectType = null;
      String objectName = null;
      String outputStr = "";
      
      if(consumeToken.hasNext()){
         objectType = consumeToken.next();
         if(consumeToken.hasNext()){
            objectName = consumeToken.next();
         }
      
         //If supported format it, else return "".
         if(objectType.equals( "JTextField" ) || objectType.equals( "JTextArea" )){ 
            if( objectType.equals( "JTextField" ) ){
               outputStr += "\n\tpublic void set" + objectName.toUpperCase().charAt(0) + objectName.substring(1) +"( String text ){\n\t\t" + objectName+ ".setText( text );\n\t}\n";
               
            }else if( objectType.equals( "JTextArea" ) ){
               outputStr += "\n\tpublic void insert" + objectName.toUpperCase().charAt(0) + objectName.substring(1) + "( String text ){\n\t\t" + objectName + ".insert( text, " + objectName + ".getCaretPosition() );\n\t}\n";
               outputStr += "\n\tpublic void set" + objectName.toUpperCase().charAt(0) + objectName.substring(1) + "( String text ){\n\t\t" + objectName + ".setText( text );\n\t}\n";
            }
         }else{
            return( "" );
         }
      }
      
      return( outputStr );
   }
   
   //Support Classes: JTextField, JTextArea
   private String formatCustomInstance( String objectStr ){
      Scanner consumeToken = new Scanner( objectStr );
      String objectType = null;
      String objectName = null;
      String outputStr = "";
      
      if(consumeToken.hasNext()){
         objectType = consumeToken.next();
         if(consumeToken.hasNext()){
            objectName = consumeToken.next();
         }
      
         //If supported format it, else return "".
         if(objectType.equals( "JTextField" ) || objectType.equals( "JTextArea" ) || objectType.equals( "JScrollPane" )){ 
            if( objectType.equals( "JTextField" ) ){
               outputStr += "\n\t\t" + objectName + ".setMaximumSize( textFieldDimension );";
               outputStr += "\n\t\t" + objectName + ".setMinimumSize( textFieldDimension );";
               outputStr += "\n\t\t" + objectName + ".setFont( textFieldFont );\n";
               
            }else if( objectType.equals( "JTextArea" ) ){
               outputStr += "\n\t\t" + objectName + ".setMaximumSize( textAreaDimension );";
               outputStr += "\n\t\t" + objectName + ".setMinimumSize( textAreaDimension );";
               outputStr += "\n\t\t" + objectName + ".setFont( textAreaFont );\n";
            
            }else if( objectType.equals( "JScrollPane" ) ){
                outputStr += "\n\t\t" + objectName + ".setMaximumSize( textAreaDimension );";
                outputStr += "\n\t\t" + objectName + ".setMinimumSize( textAreaDimension );\n";
            
            }
         }else{
            return( "" );
         }
      }
      
      return( outputStr );
   }
}