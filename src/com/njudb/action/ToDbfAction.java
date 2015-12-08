package com.njudb.action;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.njudb.layout.BodyPanel;
import com.njudb.layout.MainGUI;
import com.njudb.tools.DbfOperater;

public class ToDbfAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		// ��δѡ�����ļ�����Ҫ�������ļ���û�м����е�
		if (BodyPanel.filepath.getText() == "" || BodyPanel.filepath.equals(null)) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "δ�����ļ�", "����", JOptionPane.INFORMATION_MESSAGE);
		} 
		else {
			 JFileChooser jfc = new JFileChooser();  
             jfc.setDialogTitle("��ѡ��Ҫ����Ŀ¼");  
             jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
             int result = jfc.showOpenDialog(null);  
            
             if(JFileChooser.APPROVE_OPTION == result) {
            	 File dirFile = jfc.getSelectedFile();
            	 System.out.println("Ŀ¼λ�ã�"+dirFile.getAbsolutePath());
                 if(!dirFile.isDirectory()) {  
                     JOptionPane.showMessageDialog(null, "��ѡ���Ŀ¼������");  
                     return ;  
                 }  
                 
             	String inputFilePath = BodyPanel.filepath.getText().substring(5);
    			System.out.println("�����ļ�����·��:"+inputFilePath);
    			
    			
    			//����ļ�����·����ѡ������·��+excel_result_6λ�����
    			int rand = new Random().nextInt(999999);
    			DecimalFormat df = new DecimalFormat("#000000");
    			String outputFilePath= dirFile.getAbsolutePath()+"excel_result_"+df.format(rand)+ ".dbf";
    			System.out.println("����ļ�����·��:"+outputFilePath);
    			
    			
    			BodyPanel.column1=BodyPanel.inputColumn1.getText();
    			BodyPanel.column2=BodyPanel.inputColumn2.getText();
    			BodyPanel.column3=BodyPanel.inputColumn3.getText();
    			BodyPanel.column4=BodyPanel.inputColumn4.getText();
    			BodyPanel.column5=BodyPanel.inputColumn5.getText();
    			BodyPanel.column6=BodyPanel.inputColumn6.getText();
    			
    			String columns[]={BodyPanel.column1,BodyPanel.column2,BodyPanel.column3,BodyPanel.column4,
    					BodyPanel.column5,BodyPanel.column6};
    			
    			for (String eachcolumns : columns){
    				System.out.println("������"+eachcolumns);
    				//��Ӷ����������֤��������ʽ
    			}
    			
    			DbfOperater dbfoperater=new DbfOperater();
    			
    			dbfoperater.readAndWriteDbf(inputFilePath, outputFilePath, columns);
    			
    			try {
    				Desktop.getDesktop().open(new java.io.File(dirFile.getAbsolutePath()));
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    				
    			}
             }
             
		

		}

	}

}
