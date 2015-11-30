package com.njudb.layout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

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
	private JPanel headpanel;
	private JPanel bodypanel;
//	private JPanel footpanel;
	

//	private JLabel resultLabel;
	
	
	
	public MainGUI(){
		prepareGUI();
	}
	
	public void prepareGUI(){
		  mainFrame = new JFrame("Excel文件转换");
	      mainFrame.setSize(400,600);
	      mainFrame.setLayout(new BorderLayout());
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
//	      firstLabel = new JLabel("", JLabel.LEFT);
//	      secondLabel = new JLabel("",JLabel.LEFT);  
//	      resultLabel = new JLabel("",JLabel.LEFT);    

	      headpanel = new JPanel();
	      headpanel.setLayout(new FlowLayout());
	      headpanel.setBackground(Color.cyan);
	      
	      
	      bodypanel = new JPanel();
	      bodypanel.setLayout(new FlowLayout());
	      bodypanel.setBackground(Color.green);
//	      footpanel = new JPanel();
//	      footpanel.setLayout(new FlowLayout());
	      mainFrame.add(headpanel,BorderLayout.NORTH);
	      mainFrame.add(bodypanel,BorderLayout.CENTER);
//	      mainFrame.add(footpanel);
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
	//用来显示button中的图片
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
		    FlowLayout layout = new FlowLayout();
		      layout.setHgap(10);              
		      layout.setVgap(10);
		      
		   JLabel firstLabel=new JLabel("选择导入excel文件:",JLabel.LEFT);
		  //resources folder should be inside SWING folder.
	      //ImageIcon icon = createImageIcon("/resources/java_icon.png","Java");
	      JButton fileButton = new JButton("导入文件");        
	     // fileButton.setHorizontalTextPosition(SwingConstants.RIGHT);   

	      fileButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
//	            resultLabel.setText("Ok Button clicked.");
	         }          
	      });
	  
//		  secondLabel.setOpaque(true);
//		  secondLabel.setBackground(Color.GRAY);
//		  secondLabel.setForeground(Color.WHITE)
	      JPanel panel1 = new JPanel();
	      panel1.setBackground(Color.gray);
	     // panel1.setSize(300,150);
	      panel1.setLayout(layout);
	      panel1.add(firstLabel);
	      panel1.add(fileButton);
	      headpanel.add(panel1);
		  
		  
	      
	      
		  //JLabel secondLabel=new JLabel("设置:",JLabel.LEFT);
		  JPanel panel2 = new JPanel();
		  JLabel prefix=new JLabel("选择文件中的第",JLabel.LEFT);
		  final JTextField inputColumn1 = new JTextField(3);
		  final JTextField inputColumn2 = new JTextField(3);
		  final JTextField inputColumn3 = new JTextField(3);
		  final JTextField inputColumn4 = new JTextField(3);
		  final JTextField inputColumn5 = new JTextField(3);
		  final JTextField inputColumn6 = new JTextField(3);
		  
		  JLabel suffix1=new JLabel("列作为部门编号（BMBH）",JLabel.RIGHT);
		  JLabel suffix2=new JLabel("列作为项目编号（XMBH）",JLabel.RIGHT);
		  JLabel suffix3=new JLabel("列作为额度编号（EDBH）",JLabel.RIGHT);
		  JLabel suffix4=new JLabel("列作为录入日期（LURQ）",JLabel.RIGHT);
		  JLabel suffix5=new JLabel("列作为摘       要（ZY）", JLabel.RIGHT);
		  JLabel suffix6=new JLabel("列作为额度金额（EDJE）",JLabel.RIGHT);
		  
		  GridLayout gridLayout=new GridLayout(1,3);
		  
	      //panel1.setBackground(Color.darkGray);
	     // panel2.setSize(200,200);
	      panel2.setLayout(gridLayout);
	      
	      
	      panel2.add(prefix);
	      panel2.add(inputColumn1);
	      panel2.add(suffix1);
	      
//	      panel2.add(prefix);
//	      panel2.add(inputColumn2);
//	      panel2.add(suffix2);
	      
	     
	      
	      bodypanel.add(panel2);
	      
		  
		  
//		  secondLabel.setText("选择数据");      
//		  resultLabel.setText("");      
		  //panel2.add(secondLabel);
	      //panel3.add(resultLabel);
	      //mainFrame.pack();
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