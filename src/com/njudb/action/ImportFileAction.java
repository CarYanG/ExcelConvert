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
		// jfc.showDialog(new JLabel(), "选择文件");
		int returnVal = jfc.showOpenDialog(null);// 得到用户点击的确定还是取消
		if (returnVal == JFileChooser.APPROVE_OPTION) {// 如果用户点击的确定
			if (jfc.getSelectedFile().isDirectory()) {
				System.out.println("文件夹:" + jfc.getSelectedFile().getAbsolutePath());
			} else if (jfc.getSelectedFile().isFile()) {
				System.out.println("文件:" + jfc.getSelectedFile().getAbsolutePath());
			}
			System.out.println(jfc.getSelectedFile().getName());
			BodyPanel.filepath.setText("选择文件:" + jfc.getSelectedFile().getAbsolutePath());
		}
	}

}
