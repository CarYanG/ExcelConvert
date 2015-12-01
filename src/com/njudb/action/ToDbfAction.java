package com.njudb.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.njudb.layout.BodyPanel;
import com.njudb.layout.MainGUI;

public class ToDbfAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// 还未选择导入文件，就要生成新文件，没有鸡哪有蛋
		if (BodyPanel.filepath.getText() == "" || BodyPanel.filepath.equals(null)) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "未导入文件", "错误", JOptionPane.INFORMATION_MESSAGE);
		}

		else {

		}
	}

}
