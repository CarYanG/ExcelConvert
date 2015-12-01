package com.njudb.layout;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.njudb.action.ImportFileAction;
import com.njudb.action.ToDbfAction;
import com.njudb.action.ToExcelAction;

public class FootPanel extends JPanel {

	private JPanel panel =new JPanel();

	public FootPanel() {
		prepareGUI();
	}

	public void prepareGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		panel.setLayout(gridBagLayout);
		GridBagConstraints gbcs = new GridBagConstraints();
		
		JButton toExcel = new JButton("����Excel");
		toExcel.addActionListener(new ToExcelAction());

		JButton toDBF = new JButton("����DBF");
		toDBF.addActionListener(new ToDbfAction());
		
		JTextArea txt = new JTextArea();
		txt.setText("ע������:\r\n1.excel�ļ��е�������0��ʼ����");
		
		gbcs.fill = GridBagConstraints.HORIZONTAL;
		gbcs.gridx = 0;
		gbcs.gridy = 0;
		panel.add(toExcel, gbcs);
		
		gbcs.ipadx = 10;
		gbcs.gridx = 1;
		gbcs.gridy = 0;
		panel.add(toDBF, gbcs);

		gbcs.fill = GridBagConstraints.HORIZONTAL;
		gbcs.ipady = 10;
		gbcs.gridx = 0;
		gbcs.gridy = 2;
		gbcs.gridwidth = 2;
		panel.add(txt, gbcs);
		
		this.add(panel);
	}
}