package com.njudb.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.njudb.action.ImportFileAction;
import com.njudb.action.ToExcelAction;

public class MainGUI {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	private JFrame mainFrame;

	public MainGUI() {
		prepareGUI();
	}

	public void prepareGUI() {
		mainFrame = new JFrame("ExcelÎÄ¼þ×ª»»");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainFrame.add(new HeadPanel(), BorderLayout.NORTH);
		mainFrame.add(new BodyPanel(), BorderLayout.CENTER);
		mainFrame.add(new FootPanel(), BorderLayout.SOUTH);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
			SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
			SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
			// SubstanceLookAndFeel.setCurrentWatermark(new
			// SubstanceBubblesWatermark());
			// SubstanceLookAndFeel.setCurrentBorderPainter(new
			// StandardBorderPainter());
			// SubstanceLookAndFeel.setCurrentGradientPainter(new
			// StandardGradientPainter());
			// SubstanceLookAndFeel.setCurrentTitlePainter(new
			// FlatTitePainter());
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}

	private void show() {
		// createImageIcon("/resources/java_icon.png","Java");
		// // fileButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		//// secondLabel.setOpaque(true);
		// // panel1.setSize(300,150);
		// mainFrame.pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainGUI mainGUI = new MainGUI();
			}
		});
	}
}