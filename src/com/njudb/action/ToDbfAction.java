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

		// ��δѡ�����ļ�����Ҫ�������ļ���û�м����е�
		if (BodyPanel.filepath.getText() == "" || BodyPanel.filepath.equals(null)) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "δ�����ļ�", "����", JOptionPane.INFORMATION_MESSAGE);
		}

		else {

		}
	}

}
