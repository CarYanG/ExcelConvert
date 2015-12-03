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

		// 还未选择导入文件，就要生成新文件，没有鸡哪有蛋
		if (BodyPanel.filepath.getText() == "" || BodyPanel.filepath.equals(null)) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "未导入文件", "错误", JOptionPane.INFORMATION_MESSAGE);
		} 
		else {
			
			 JFileChooser jfc = new JFileChooser();  
             jfc.setDialogTitle("请选择要导出目录");  
             jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
             int result = jfc.showOpenDialog(null);  
             File dirFile = null;
             if(JFileChooser.APPROVE_OPTION == result) {
            	 dirFile = jfc.getSelectedFile();  
            	 System.out.println("目录位置："+dirFile.getAbsolutePath());
                 if(!dirFile.isDirectory()) {  
                     JOptionPane.showMessageDialog(null, "你选择的目录不存在");  
                     return ;  
                 }  
             }
             
			String inputFilePath = BodyPanel.filepath.getText().substring(5);
			System.out.println("输入文件绝对路径:"+inputFilePath);
			
			String outputFilePath= dirFile.getAbsolutePath()+"test.xls";
			System.out.println("输出文件绝对路径:"+outputFilePath);

			
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
