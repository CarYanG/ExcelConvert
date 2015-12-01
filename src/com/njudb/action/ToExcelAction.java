package com.njudb.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.njudb.layout.BodyPanel;
import com.njudb.layout.MainGUI;

public class ToExcelAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// 还未选择导入文件，就要生成新文件，没有鸡哪有蛋
		if (BodyPanel.filepath.getText() == "" || BodyPanel.filepath.equals(null)) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "未导入文件", "错误", JOptionPane.INFORMATION_MESSAGE);
		} else {
			String inputFilePath = BodyPanel.filepath.getText().substring(5);
			System.out.println(inputFilePath);
			File file = new File(inputFilePath);// 根据文件名创建一个文件对象
			Workbook wb = null;
			try {
				wb = Workbook.getWorkbook(file);// 从文件流中取得Excel工作区对象
			} catch (BiffException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Sheet sheet = wb.getSheet(0); // 从工作区中取得页，取得这个对象的时候既可以用名称来获得，也可以用序号。
			String outPut = "";
			outPut = outPut + "第一个sheet的名称为：" + sheet.getName();
			System.out.println(outPut);
			outPut = "第一个sheet共有：" + sheet.getRows() + "行" + sheet.getColumns() + "列<br>";
			System.out.println(outPut);
			outPut = "具体内容如下：";
			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					outPut = outPut + cell.getContents() + " ";
				}
				outPut = outPut + "<br>";
			}

		}

	}

}
