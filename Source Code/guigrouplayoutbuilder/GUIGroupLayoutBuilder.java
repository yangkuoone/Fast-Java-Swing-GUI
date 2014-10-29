//Author: David McKay
//Date: 8/29/2014
package guigrouplayoutbuilder;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author David
 */
public class GUIGroupLayoutBuilder {

    public static void main( String[] args ){
      
      // (1)
      // New Module           - This will hold the 2 Objects below if required.
      
      // (2)
      // CreateClassModule    - Will allow a Program to create new class fast and 
      //                         simple with proper designated areas.
      
      // (3)
      // DisplayOutputModule  - Will allow a Program to insert text directly to the
      //                         Display, but it should be done through the CreateClassModule; and
      //                         it should use all the functions within it to create a Java Class.
      
      // (3)
      // Display area: output
      JTextArea display = new JTextArea( );
      display.setFont( new Font("Lucida Console" , Font.PLAIN, 12) );
      DisplayOutputModule mainDisplay = new DisplayOutputModule( display );
      
      // (2)
      // Create Class: new class
      CreateClassModule newClass = new CreateClassModule( display );
      JPanel newClassPanel = new JPanel();
      newClassPanel.add( newClass );
      JScrollPane scrollNewClass = new JScrollPane( newClassPanel );
      
      // (1)
      GroupLayoutModule groupClass = new GroupLayoutModule( newClass );
      
      // (Final - Stage)
      // Tabbed Pane: Add Each Module
      JTabbedPane tabbedPane = new JTabbedPane( );
      tabbedPane.add( "Create Group Layout", groupClass );
      tabbedPane.add( "Create New Class", scrollNewClass );
      tabbedPane.add( "Output", mainDisplay );
      
         
      // Setting up the JFrame to house the Application:
      //-------------------------------------------------------------------------------------------------| 
      JFrame runGUI = new JFrame( );
      runGUI.add( tabbedPane );
      runGUI.setSize( 650, 980 );
      runGUI.setTitle( "Text Editor Designed for David ;)" );
      runGUI.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      runGUI.setVisible( true );
      //-------------------------------------------------------------------------------------------------|
   }
}