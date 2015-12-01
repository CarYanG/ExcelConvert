package com.njudb.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.njudb.layout.BodyPanel;
import com.njudb.layout.MainGUI;

public class ImportFileAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "xls", "xlsx");
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setFileFilter(filter);
		// jfc.showDialog(new JLabel(), "ѡ���ļ�");
		int returnVal = jfc.showOpenDialog(null);// �õ��û������ȷ������ȡ��
		if (returnVal == JFileChooser.APPROVE_OPTION) {// ����û������ȷ��
			if (jfc.getSelectedFile().isDirectory()) {
				System.out.println("�ļ���:" + jfc.getSelectedFile().getAbsolutePath());
			} else if (jfc.getSelectedFile().isFile()) {
				System.out.println("�ļ�:" + jfc.getSelectedFile().getAbsolutePath());
			}
			System.out.println(jfc.getSelectedFile().getName());
			BodyPanel.filepath.setText("ѡ���ļ�:" + jfc.getSelectedFile().getAbsolutePath());
		}
	}

}
