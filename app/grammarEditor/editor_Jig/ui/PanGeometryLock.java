package org.fleen.forsythia.app.grammarEditor.editor_Jig.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.fleen.forsythia.app.grammarEditor.GE;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PanGeometryLock extends JPanel{
  
  public JButton btngeometrylock;

  public PanGeometryLock(){
    
    setBackground(new Color(204, 153, 255));
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    
    Box verticalBox = Box.createVerticalBox();
    add(verticalBox);
    
    Box horizontalboxtop = Box.createHorizontalBox();
    verticalBox.add(horizontalboxtop);
    
    Component rigidArea = Box.createRigidArea(new Dimension(44, 4));
    horizontalboxtop.add(rigidArea);
    
    Box horizontalboxmid = Box.createHorizontalBox();
    verticalBox.add(horizontalboxmid);
    
    Component horizontalStrut = Box.createHorizontalStrut(4);
    horizontalboxmid.add(horizontalStrut);
    
    btngeometrylock = new JButton("GEOMETRY UNLOCKED");
    btngeometrylock.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e){
        GE.editor_jig.toggleGeometryLock();}});
    btngeometrylock.setFont(new Font("Dialog", Font.BOLD, 12));
    horizontalboxmid.add(btngeometrylock);
    
    Component horizontalStrut_3 = Box.createHorizontalStrut(4);
    horizontalboxmid.add(horizontalStrut_3);
    
    Box horizontalboxbottom = Box.createHorizontalBox();
    verticalBox.add(horizontalboxbottom);
    
    Component rigidArea_1 = Box.createRigidArea(new Dimension(44, 4));
    horizontalboxbottom.add(rigidArea_1);
    
  }
}