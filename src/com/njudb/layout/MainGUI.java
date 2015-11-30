package com.njudb.layout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;

public class MainGUI{

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
//	FlowLayout layout;
	private JFrame mainFrame;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JLabel firstLabel;
	private JLabel secondLabel;
	private JLabel resultLabel;
	
	
	
	public MainGUI(){
		prepareGUI();
	}
	
	public void prepareGUI(){
		  mainFrame = new JFrame("Excel文件转换");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      firstLabel = new JLabel("", JLabel.LEFT);
	      
	      secondLabel = new JLabel("",JLabel.LEFT);    
	      secondLabel.setSize(350,100);
	      
	      resultLabel = new JLabel("",JLabel.LEFT);    

	      panel1 = new JPanel();
	      panel1.setLayout(new GridLayout(1,2));
	      
	      panel2 = new JPanel();
	      panel2.setLayout(new GridLayout(7,2));
	      
	      panel3 = new JPanel();
	      panel3.setLayout(new GridLayout(1,2));
	      
	      mainFrame.add(firstLabel);
	      mainFrame.add(secondLabel);
          mainFrame.add(resultLabel);
	      mainFrame.add(panel1);
	      mainFrame.add(panel2);
	      mainFrame.add(panel3);
	      mainFrame.setVisible(true);  
	      
	      
//		layout = new FlowLayout();
//		setLayout(layout);
//		add(new JButton("Test"));
//		add(new JButton("Button"));
//		add(new JButton("Click"));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();
//		setVisible(true);
		
//		try {  
//            UIManager.setLookAndFeel(new SubstanceLookAndFeel());  
//            JFrame.setDefaultLookAndFeelDecorated(true);  
//            JDialog.setDefaultLookAndFeelDecorated(true);  
//           SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());  
//          SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());  
//          SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());  
//          SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());  
//          SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());  
//            SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());  
//            SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitePainter());  
//        } catch (Exception e) {  
//            System.err.println("Something went wrong!");  
//        }  
	}
	 private static ImageIcon createImageIcon(String path, 
		      String description) {
		      java.net.URL imgURL = SwingControlDemo.class.getResource(path);
		      if (imgURL != null) {
		         return new ImageIcon(imgURL, description);
		      } else {            
		         System.err.println("Couldn't find file: " + path);
		         return null;
		      }
		   }   
	 private void show(){
		  firstLabel.setText("选择导入excel文件");      
		  secondLabel.setText("选择数据");      
		  resultLabel.setText("");      

	     
//		  secondLabel.setOpaque(true);
//		  secondLabel.setBackground(Color.GRAY);
//		  secondLabel.setForeground(Color.WHITE);
		  panel1.add(firstLabel);
		  panel2.add(secondLabel);
	      panel3.add(resultLabel);

	      mainFrame.setVisible(true);  
	   }
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MainGUI  mainGUI=   new MainGUI();
            	mainGUI.show();
                
            }
        }); 
	}
}