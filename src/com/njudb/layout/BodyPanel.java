package com.njudb.layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BodyPanel extends JPanel {

	private JPanel panel = new JPanel();
	public static JLabel filepath = new JLabel("", JLabel.LEFT);
	public static String column1;
	public static String column2;
	public static String column3;
	public static String column4;
	public static String column5;
	public static String column6;
	
	public  static JTextField inputColumn1;
	public  static JTextField inputColumn2;
	public  static JTextField inputColumn3;
	public  static JTextField inputColumn4;
	public  static JTextField inputColumn5;
	public  static JTextField inputColumn6;
	

	public BodyPanel() {
		prepareGUI();
	}

	public void prepareGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		panel.setLayout(gridBagLayout);
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel prefix1 = new JLabel("选择文件中的第", JLabel.LEFT);
		JLabel prefix2 = new JLabel("选择文件中的第", JLabel.LEFT);
		JLabel prefix3 = new JLabel("选择文件中的第", JLabel.LEFT);
		JLabel prefix4 = new JLabel("选择文件中的第", JLabel.LEFT);
		JLabel prefix5 = new JLabel("选择文件中的第", JLabel.LEFT);
		JLabel prefix6 = new JLabel("选择文件中的第", JLabel.LEFT);

		  inputColumn1 = new JTextField(3);
		  inputColumn2 = new JTextField(3);
		  inputColumn3 = new JTextField(3);
		  inputColumn4 = new JTextField(3);
		  inputColumn5 = new JTextField(3);
		  inputColumn6 = new JTextField(3);

		JLabel suffix1 = new JLabel("列作为部门编号（BMBH）");
		JLabel suffix2 = new JLabel("列作为项目编号（XMBH）");
		JLabel suffix3 = new JLabel("列作为额度编号（EDBH）");
		JLabel suffix4 = new JLabel("列作为录入日期（LURQ）");
		JLabel suffix5 = new JLabel("列作为摘要（ZY）");
		JLabel suffix6 = new JLabel("列作为额度金额（EDJE）");

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(prefix1, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(inputColumn1, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(suffix1, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(prefix2, gbc);
		gbc.ipady = 5;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(inputColumn2, gbc);
		gbc.ipady = 5;
		gbc.gridx = 2;
		gbc.gridy = 1;
		panel.add(suffix2, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 5;
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(prefix3, gbc);
		gbc.ipady = 5;
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(inputColumn3, gbc);
		gbc.ipady = 5;
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(suffix3, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 5;
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(prefix4, gbc);
		gbc.ipady = 5;
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(inputColumn4, gbc);
		gbc.ipady = 5;
		gbc.gridx = 2;
		gbc.gridy = 3;
		panel.add(suffix4, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 5;
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(prefix5, gbc);
		gbc.ipady = 5;
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(inputColumn5, gbc);
		gbc.ipady = 5;
		gbc.gridx = 2;
		gbc.gridy = 4;
		panel.add(suffix5, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 5;
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(prefix6, gbc);
		gbc.ipady = 5;
		gbc.gridx = 1;
		gbc.gridy = 5;
		panel.add(inputColumn6, gbc);
		gbc.ipady = 5;
		gbc.gridx = 2;
		gbc.gridy = 5;
		panel.add(suffix6, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 5;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		panel.add(filepath, gbc);
		this.add(panel);
	}
}