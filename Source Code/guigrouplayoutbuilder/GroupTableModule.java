//Author: David McKay
//Date: 9/4/2014
package guigrouplayoutbuilder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GroupTableModule extends JPanel{

	//Instance Variables:( Automated )
	//--------------------------------------------------------------------------|

	private JTable _dataTable;
	
	//--------------------------------------------------------------------------|

	public GroupTableModule( ){

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

		_dataTable = new JTable( 20, 20 );
      
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
		      .addComponent( _dataTable ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( _dataTable ));

		//-----------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}
   
   //Look at the one we created to save time. - delete this comment afterwards.
   public String processTable( ){
      String outputStr = "";
      
      //Vertical Rows: (Columns) //Horizontal Group
      outputStr += getColumns();
      
      //Horizontal Rows: (Rows) //Vertical Group
      outputStr += getRows();
   
      return( outputStr );
   }
   
   private String getRows(){
      
      String outputStr = "";
      
      for(int row = 0; row < _dataTable.getRowCount(); row++){
         
         //Check if there are any vGroup on this Row
         if( checkRow( row, _dataTable.getRowCount() ) )
            outputStr += "\t\tvGroup.addGroup(layout.createParallelGroup()";
         
         for(int column = 0; column < _dataTable.getColumnCount(); column++){
            if( !(_dataTable.getValueAt( row, column) == null) && !(_dataTable.getValueAt( row, column).equals( "" )) ){
               outputStr += "\n\t\t      .addComponent( " + _dataTable.getValueAt( row, column) + " )";
            }      
         }
         
         //Check if there are any vGroup on this Row
         if( checkRow( row, _dataTable.getRowCount() ) )
         outputStr += ");\n\n";
      }
      
      return( outputStr );
   }
   
   private boolean checkRow( int row, int columnMax ){
      
      for( int i = 0; i < columnMax; i++){
         if( !(_dataTable.getValueAt( row, i) == null) && !(_dataTable.getValueAt( row, i).equals( "" )) )
            return( true );
      } 
      
      return( false );
   }
   
   private String getColumns(){
      
      String outputStr = "";
      
      for(int column = 0; column < _dataTable.getColumnCount(); column++){
         
         //Check if there are any hGroup on this Column
         if( checkColumn( _dataTable.getRowCount(), column  ) )
            outputStr += "\t\thGroup.addGroup(layout.createParallelGroup()";
      
         for(int row = 0; row < _dataTable.getRowCount(); row++){
            if( !(_dataTable.getValueAt( row, column) == null) && !(_dataTable.getValueAt( row, column).equals( "" ) )){
               outputStr += "\n\t\t      .addComponent( " + _dataTable.getValueAt( row, column) + " )";
            }
         }
         
         //Check if there are any hGroup on this Column
         if( checkColumn( _dataTable.getRowCount(), column  ) )
            outputStr += ");\n\n";
      }   
       
      return( outputStr );
   }
   
   private boolean checkColumn( int rowMax, int column ){
      
      for( int i = 0; i < rowMax; i++){
         if( !(_dataTable.getValueAt( i, column) == null) && !(_dataTable.getValueAt( i, column).equals( "" )) )
            return( true );
      } 
      
      return( false );
   }
}