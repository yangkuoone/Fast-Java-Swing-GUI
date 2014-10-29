// David McKay
// 29 August 2014
// Coding for the greater good and trying to make my own text editor
// (Does not support color text | also will be adding an area that is
//  easier for rapid GUI prototypes)
package guigrouplayoutbuilder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class VariableModule extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|

	private JTextArea instanceArea;
	private JTextArea constantArea;
   
   final public static Dimension textAreaDimension = new Dimension( 435, 100);
   
	//--------------------------------------------------------------------------|

	public VariableModule( ){

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
      
      //Instance:
		JLabel instanceLabel = new JLabel( "Instance Variables:" );
		instanceArea = new JTextArea( );
      instanceArea.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
      JScrollPane scrollInstanceArea = new JScrollPane( instanceArea );
      scrollInstanceArea.setMaximumSize( textAreaDimension );
      scrollInstanceArea.setMinimumSize( textAreaDimension );
      
      //Constant:
		JLabel constantLabel = new JLabel( "CONSTANTS Variables:" );
		constantArea = new JTextArea( );
      constantArea.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      
      JScrollPane scrollConstantArea = new JScrollPane( constantArea );
      scrollConstantArea.setMaximumSize( textAreaDimension );
      scrollConstantArea.setMinimumSize( textAreaDimension );
      
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
		      .addComponent( instanceLabel )
		      .addComponent( constantLabel ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( scrollInstanceArea )
		      .addComponent( scrollConstantArea ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( instanceLabel )
		      .addComponent( scrollInstanceArea ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( constantLabel )
		      .addComponent( scrollConstantArea ));

		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}
   
   /**
   * This method will format the text to be the instance variable location.
   */
   public String getInstanceVariables(){
      String outputStr = "";
      Scanner keyboard = new Scanner( instanceArea.getText() );
      Scanner line = null;
      String temp = null;
      
      while( keyboard.hasNextLine() ){
         temp = keyboard.nextLine();
         
         if( !temp.equals( "" )){
            if( !temp.contains( ";" ) ){
               temp += ";";
            }
            
            line = new Scanner( temp );
            
            //Object: Object
            if(line.hasNext())
               outputStr += "\n\tprivate " + line.next();
            
            //Variable: obj
            if(line.hasNext()){
               
               temp = line.next();
               
               if( !temp.contains( ";" ) ){
                  temp += ";";
               }
               
               outputStr += ' ' + temp;
               
            }
         }else{
            outputStr += "\n";
         }
      }
      
      return( outputStr );
   }
   
   /**
   * This method will format the text to be the initializing instance variable
   * location.
   */
   public String getInitializingInstanceVariables(){
      String outputStr = "";
      Scanner keyboard = new Scanner( instanceArea.getText() );
      Scanner line = null;
      String temp = null;
      
      while( keyboard.hasNextLine() ){
         temp = keyboard.nextLine();
         
         if( !temp.equals( "" ) ){
            if( !temp.contains(";") ){
               temp += ";";
            }
            
            line = new Scanner( temp );
            
            //Thorw away the Object: Object
            if(line.hasNext())
               line.next();
            
            //Variable: obj
            if(line.hasNext())
               outputStr += "\n\t\t" + line.next();
            
            //Rest: = Object( "valid constructor" )
            if(line.hasNext())
               outputStr += line.nextLine();
         }else{
            outputStr += "\n";
         }
      }
      
      return( outputStr );
   }
   
   /**
   * This method will format the text to be the CONSTANTS location.
   */
   public String getConstantVariables(){
      String outputStr = "";
      Scanner keyboard = new Scanner( constantArea.getText() );
      String temp = null;
      
      while( keyboard.hasNextLine() ){
      
         temp = keyboard.nextLine();
         if( !temp.equals( "" )){
            if( temp.contains( ";" ) ){
               outputStr += "\n\tfinal public static " + temp;
            }else{
               outputStr += "\n\tfinal public static " + temp + ';';
            }
         }else{
             outputStr += "\n";
         }
         
      }
      
      return( outputStr );
   }
   
   public void insertIntanceVariables( String instanceVariablesStr ){
      instanceArea.insert( instanceVariablesStr, instanceArea.getCaretPosition() );
   }
   
   public void insertConstantVariables( String constantVariablesStr ){
      constantArea.insert( constantVariablesStr, constantArea.getCaretPosition() );
   }
}