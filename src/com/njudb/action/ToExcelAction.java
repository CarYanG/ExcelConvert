package com.njudb.action;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.njudb.layout.BodyPanel;
import com.njudb.layout.MainGUI;
import com.njudb.tools.ExcelOperater;

public class ToExcelAction implements ActionListener {

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
             File dirFile = null;
             if(JFileChooser.APPROVE_OPTION == result) {
            	 dirFile = jfc.getSelectedFile();  
            	 System.out.println("Ŀ¼λ�ã�"+dirFile.getAbsolutePath());
                 if(!dirFile.isDirectory()) {  
                     JOptionPane.showMessageDialog(null, "��ѡ���Ŀ¼������");  
                     return ;  
                 }  
             }
             
			String inputFilePath = BodyPanel.filepath.getText().substring(5);
			System.out.println("�����ļ�����·��:"+inputFilePath);
			
			String outputFilePath= dirFile.getAbsolutePath()+"test.xls";
			System.out.println("����ļ�����·��:"+outputFilePath);

			
//			ExcelOperater eo=new ExcelOperater();
//			
//			eo.readAndWriteExcel(inputFilePath, outputFilePath);
			
			try {
				Desktop.getDesktop().open(new java.io.File(new File(inputFilePath).getAbsolutePath()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}

		}

	}

}
