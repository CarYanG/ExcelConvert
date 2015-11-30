package com.njudb.layout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;

public class MainPanel extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FlowLayout layout;
	
	public MainPanel(){
		layout = new FlowLayout();
		setLayout(layout);
		add(new JButton("Test"));
		add(new JButton("Button"));
		add(new JButton("Click"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		try {  
            UIManager.setLookAndFeel(new SubstanceLookAndFeel());  
            JFrame.setDefaultLookAndFeelDecorated(true);  
            JDialog.setDefaultLookAndFeelDecorated(true);  
           SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());  
          SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());  
          SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());  
//          SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());  
//          SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());  
//            SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());  
//            SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitePainter());  
        } catch (Exception e) {  
            System.err.println("Something went wrong!");  
        }  
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainPanel();
            }
        }); 
	}
}