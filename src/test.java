import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.File;

public class test extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		new ConfigFrame("�����ļ�");
	}
}

class ConfigFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public ConfigFrame(String title) {
		//���ô�������
		final int width = 300;
		final int height = 200;
		final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final int left = (screen.width - width) / 2;
		final int top = (screen.height - height) / 2;
		this.setLocation(left, top);
		this.setSize(width, height);
		this.setTitle(title);

		//������
		JPanel panel = new JPanel();
		this.add(panel);
		JButton openBtn = new JButton("��");
		JButton saveBtn = new JButton("����");
		panel.add(openBtn);
		panel.add(saveBtn);

		final JFileChooser chooser = new JFileChooser("."); //�ڵ�ǰĿ¼�£������ļ�ѡ����

		JpgFileFilter jpgFilter = new JpgFileFilter(); //jpg������
		GifFileFilter gifFilter = new GifFileFilter(); //gif������
		chooser.addChoosableFileFilter(jpgFilter); //����jpg�ļ�������
		chooser.addChoosableFileFilter(gifFilter); //����gif�ļ�������

		chooser.setFileFilter(jpgFilter); //����Ĭ�ϵ��ļ������������������,�������ӵ��ļ�������ΪĬ�Ϲ�����

		openBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = chooser.showOpenDialog(null); //��ʾ����

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String filepath = chooser.getSelectedFile().getPath();
					String filename = chooser.getSelectedFile().getName();

					System.out.println("path:" + filepath);
					System.out.println("name:" + filename);
				}

			}
		});

		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser.setSelectedFile(new File("picture.jpg")); //���ñ���ʱ�ģ�Ĭ���ļ���			

				int returnVal = chooser.showSaveDialog(ConfigFrame.this); //��ʾ�����ļ�����

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String filepath = chooser.getSelectedFile().getPath();
					String filename = chooser.getSelectedFile().getName();
				}

			}
		});

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class JpgFileFilter extends FileFilter {
	public String getDescription() {
		return "*.jpg";
	}

	public boolean accept(File file) {
		String name = file.getName();
		return name.toLowerCase().endsWith(".jpg");
	}
}

class GifFileFilter extends FileFilter {
	public String getDescription() {
		return "*.gif";
	}

	public boolean accept(File file) {
		String name = file.getName();
		return name.toLowerCase().endsWith(".gif");
	}
}
