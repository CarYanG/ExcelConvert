package com.njudb.layout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.njudb.action.ImportFileAction;
import com.njudb.action.ToExcelAction;
public class MainGUI{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JPanel headpanel;
	private JPanel bodypanel;
	private JPanel footpanel;
	
	public static  JLabel filepath=new JLabel("",JLabel.LEFT);  
	public static String column1;
	public static String column2;
	public static String column3;
	public static String column4;
	public static String column5;
	public static String column6;
	
	public MainGUI(){
		prepareGUI();
	}
	
	public void prepareGUI(){
		  mainFrame = new JFrame("Excel文件转换");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new BorderLayout());
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headpanel = new JPanel();
	    //  headpanel.setBackground(Color.cyan);  
	      bodypanel = new JPanel();
	      bodypanel.setLayout(new FlowLayout());
	    //  bodypanel.setBackground(Color.green);
	      footpanel = new JPanel();
	     // footpanel.setBackground(Color.GRAY);
	      mainFrame.add(headpanel,BorderLayout.NORTH);
	      mainFrame.add(bodypanel,BorderLayout.CENTER);
	      mainFrame.add(footpanel,BorderLayout.SOUTH);
	      mainFrame.setVisible(true);  

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		try {  
            UIManager.setLookAndFeel(new SubstanceLookAndFeel());  
            JFrame.setDefaultLookAndFeelDecorated(true);  
            JDialog.setDefaultLookAndFeelDecorated(true);  
           SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());  
          SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());  
          SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());  
//          SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());  
//          SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());  
//            SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());  
//            SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitePainter());  
        } catch (Exception e) {  
            System.err.println("Something went wrong!");  
        }  
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
		    FlowLayout flowLayout = new FlowLayout();
		    flowLayout.setHgap(10);              
		    flowLayout.setVgap(10);
		   
			JPanel panel1 = new JPanel();
		    JLabel firstLabel=new JLabel("选择导入excel文件:",JLabel.LEFT);
	      //ImageIcon icon = createImageIcon("/resources/java_icon.png","Java");
	      JButton fileButton = new JButton("导入文件");        
	     // fileButton.setHorizontalTextPosition(SwingConstants.RIGHT);   
	      fileButton.addActionListener(new ImportFileAction());
//		  secondLabel.setOpaque(true);
//		  secondLabel.setBackground(Color.GRAY);
//		  secondLabel.setForeground(Color.WHITE)
	     // panel1.setBackground(Color.gray);
	     // panel1.setSize(300,150);
	      panel1.setLayout(flowLayout);
	      panel1.add(firstLabel);
	      panel1.add(fileButton);
	      headpanel.add(panel1);

		  JPanel panel2 = new JPanel();
		  JLabel prefix1=new JLabel("选择文件中的第",JLabel.LEFT);
		  JLabel prefix2=new JLabel("选择文件中的第",JLabel.LEFT);
		  JLabel prefix3=new JLabel("选择文件中的第",JLabel.LEFT);
		  JLabel prefix4=new JLabel("选择文件中的第",JLabel.LEFT);
		  JLabel prefix5=new JLabel("选择文件中的第",JLabel.LEFT);
		  JLabel prefix6=new JLabel("选择文件中的第",JLabel.LEFT);
		  
		  final JTextField inputColumn1 = new JTextField(3);
		  final JTextField inputColumn2 = new JTextField(3);
		  final JTextField inputColumn3 = new JTextField(3);
		  final JTextField inputColumn4 = new JTextField(3);
		  final JTextField inputColumn5 = new JTextField(3);
		  final JTextField inputColumn6 = new JTextField(3);
		  
		  JLabel suffix1=new JLabel("列作为部门编号（BMBH）");
		  JLabel suffix2=new JLabel("列作为项目编号（XMBH）");
		  JLabel suffix3=new JLabel("列作为额度编号（EDBH）");
		  JLabel suffix4=new JLabel("列作为录入日期（LURQ）");
		  JLabel suffix5=new JLabel("列作为摘要（ZY）" );
		  JLabel suffix6=new JLabel("列作为额度金额（EDJE）");
		  
		  GridBagLayout gridBagLayout = new GridBagLayout();

	      panel2.setLayout(gridBagLayout);        
	      GridBagConstraints gbc = new GridBagConstraints();
		  
	      //panel1.setBackground(Color.darkGray);
	     // panel2.setSize(200,200);
	      panel2.setLayout(gridBagLayout);
	      GridBagConstraints gbcs = new GridBagConstraints();
	      
	      gbcs.fill = GridBagConstraints.HORIZONTAL;
	      gbcs.gridx = 0;
	      gbcs.gridy = 0;
	      panel2.add(prefix1,gbcs);
	      gbcs.gridx = 1;
	      gbcs.gridy = 0;
	      panel2.add(inputColumn1,gbcs);
	      gbcs.gridx = 2;
	      gbcs.gridy = 0;
	      panel2.add(suffix1,gbcs);
	      
	      gbcs.fill = GridBagConstraints.HORIZONTAL;
	      gbcs.ipady = 5;   
	      gbcs.gridx = 0;
	      gbcs.gridy = 1;
	      panel2.add(prefix2,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 1;
	      gbcs.gridy = 1;
	      panel2.add(inputColumn2,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 2;
	      gbcs.gridy = 1;
	      panel2.add(suffix2,gbcs);
	      
	      gbcs.fill = GridBagConstraints.HORIZONTAL;
	      gbcs.ipady = 5;   
	      gbcs.gridx = 0;
	      gbcs.gridy = 2;
	      panel2.add(prefix3,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 1;
	      gbcs.gridy = 2;
	      panel2.add(inputColumn3,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 2;
	      gbcs.gridy = 2;
	      panel2.add(suffix3,gbcs);
	      
	      gbcs.fill = GridBagConstraints.HORIZONTAL;
	      gbcs.ipady = 5;   
	      gbcs.gridx = 0;
	      gbcs.gridy = 3;
	      panel2.add(prefix4,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 1;
	      gbcs.gridy = 3;
	      panel2.add(inputColumn4,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 2;
	      gbcs.gridy = 3;
	      panel2.add(suffix4,gbcs);
	      
	      gbcs.fill = GridBagConstraints.HORIZONTAL;
	      gbcs.ipady = 5;   
	      gbcs.gridx = 0;
	      gbcs.gridy = 4;
	      panel2.add(prefix5,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 1;
	      gbcs.gridy = 4;
	      panel2.add(inputColumn5,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 2;
	      gbcs.gridy = 4;
	      panel2.add(suffix5,gbcs);
	      
	      gbcs.fill = GridBagConstraints.HORIZONTAL;
	      gbcs.ipady = 5;   
	      gbcs.gridx = 0;
	      gbcs.gridy = 5;
	      panel2.add(prefix6,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 1;
	      gbcs.gridy = 5;
	      panel2.add(inputColumn6,gbcs);
	      gbcs.ipady = 5; 
	      gbcs.gridx = 2;
	      gbcs.gridy = 5;
	      panel2.add(suffix6,gbcs);
	      
	      gbcs.fill = GridBagConstraints.HORIZONTAL;
	      gbcs.ipady = 5;   
	      gbcs.gridx = 0;
	      gbcs.gridy = 6;
	      gbcs.gridwidth=3;
	      panel2.add(filepath,gbcs);
	      bodypanel.add(panel2);
	      
	      
	      JPanel panel3 = new JPanel();
	      panel3.setLayout(gridBagLayout);
	      JButton toExcel = new JButton("生成Excel"); 
	      
	      column1=inputColumn1.getText();
	      column2=inputColumn2.getText();
	      column3=inputColumn3.getText();
	      column4=inputColumn4.getText();
	      column5=inputColumn5.getText();
	      column6=inputColumn6.getText();
	      toExcel.addActionListener(new ToExcelAction());
	      
	      JButton toDBF = new JButton("生成DBF"); 
	      
	      toDBF.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		    		 
		    		}
		      });
	      JTextArea txt=new JTextArea();
	      txt.setText("注意事项:\r\n1.excel文件中的列数从0开始计数");
	      gbcs.fill = GridBagConstraints.HORIZONTAL;
	      gbcs.gridx = 0;
	      gbcs.gridy = 0;
	      panel3.add(toExcel,gbcs);
	      gbcs.ipady = 10; 
	      gbcs.gridx = 0;
	      gbcs.gridy = 1;
	      panel3.add(toDBF,gbcs);
	      
	      gbcs.fill = GridBagConstraints.HORIZONTAL;
	      gbcs.ipady = 10; 
	      gbcs.gridx = 0;
	      gbcs.gridy = 2;
	      gbcs.gridwidth = 2;
	      panel3.add(txt,gbcs);     
	      footpanel.add(panel3);
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