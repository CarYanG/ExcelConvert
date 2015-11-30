import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingLayoutDemo {
   private JFrame mainFrame;
  
   private JPanel controlPanel;

   public SwingLayoutDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      SwingLayoutDemo swingLayoutDemo = new SwingLayoutDemo();  
      swingLayoutDemo.showFlowLayoutDemo();       
   }
      
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));


      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
	        System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);  
   }

   private void showFlowLayoutDemo(){

      JPanel panel = new JPanel();
      panel.setBackground(Color.darkGray);
      panel.setSize(200,200);
      FlowLayout layout = new FlowLayout();
      layout.setHgap(10);              
      layout.setVgap(10);
      panel.setLayout(layout);        
      panel.add(new JButton("OK"));
      panel.add(new JButton("Cancel"));       

      controlPanel.add(panel);

      mainFrame.setVisible(true);  
   }
}