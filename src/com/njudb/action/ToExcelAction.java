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

		// ��δѡ�����ļ�����Ҫ�������ļ���û�м����е�
		if (BodyPanel.filepath.getText() == "" || BodyPanel.filepath.equals(null)) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "δ�����ļ�", "����", JOptionPane.INFORMATION_MESSAGE);
		} else {
			String inputFilePath = BodyPanel.filepath.getText().substring(5);
			System.out.println(inputFilePath);
			File file = new File(inputFilePath);// �����ļ�������һ���ļ�����
			Workbook wb = null;
			try {
				wb = Workbook.getWorkbook(file);// ���ļ�����ȡ��Excel����������
			} catch (BiffException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Sheet sheet = wb.getSheet(0); // �ӹ�������ȡ��ҳ��ȡ����������ʱ��ȿ�������������ã�Ҳ��������š�
			String outPut = "";
			outPut = outPut + "��һ��sheet������Ϊ��" + sheet.getName();
			System.out.println(outPut);
			outPut = "��һ��sheet���У�" + sheet.getRows() + "��" + sheet.getColumns() + "��<br>";
			System.out.println(outPut);
			outPut = "�����������£�";
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
