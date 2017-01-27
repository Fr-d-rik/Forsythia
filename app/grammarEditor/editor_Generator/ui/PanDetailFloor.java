package org.fleen.forsythia.app.grammarEditor.editor_Generator.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.fleen.forsythia.app.grammarEditor.GE;

public class PanDetailFloor extends JPanel{
  
  private static final long serialVersionUID=-1484832312439244645L;
  
  public JTextField txtjigtag;

  public PanDetailFloor(){
    
    setBackground(new Color(255, 204, 255));
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    
    Component horizontalStrut = Box.createHorizontalStrut(8);
    add(horizontalStrut);
    
    JLabel lbljigtag = new JLabel("DetailFloor=");
    add(lbljigtag);
    lbljigtag.setFont(new Font("Dialog", Font.BOLD, 14));
    
    Component horizontalStrut_3 = Box.createHorizontalStrut(8);
    add(horizontalStrut_3);
    
    txtjigtag = new JTextField("12.34",8);
    add(txtjigtag);
    txtjigtag.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 18));
    txtjigtag.setBorder(null);
    
    Component horizontalStrut_1 = Box.createHorizontalStrut(8);
    add(horizontalStrut_1);
    txtjigtag.addKeyListener(new KeyAdapter(){
      public void keyReleased(KeyEvent e){
        GE.ge.editor_generator.setDetailFloor(txtjigtag.getText());}});
    
  }
}
