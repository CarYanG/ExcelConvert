package com.njudb.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.njudb.action.ImportFileAction;

public class HeadPanel extends JPanel {
		
	private JPanel panel=new JPanel();
	public HeadPanel(){
		prepareGUI();
	}
	
	public void prepareGUI(){
		 FlowLayout flowLayout = new FlowLayout();
		 flowLayout.setHgap(10);              
		 flowLayout.setVgap(10);
		 panel.setLayout(flowLayout);
		 JLabel firstLabel=new JLabel("选择导入excel文件:",JLabel.LEFT);
	      //ImageIcon icon = createImageIcon("/resources/java_icon.png","Java");
	     JButton fileButton = new JButton("导入文件");        
	     // fileButton.setHorizontalTextPosition(SwingConstants.RIGHT);   
	     fileButton.addActionListener(new ImportFileAction());
	     panel.add(firstLabel);
	     panel.add(fileButton);
		 this.add(panel);
	}
}
