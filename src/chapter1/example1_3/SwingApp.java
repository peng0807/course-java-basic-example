package chapter1.example1_3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingApp {

	private JFrame frmswing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApp window = new SwingApp();
					window.frmswing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmswing = new JFrame();
		frmswing.setTitle("\u7B2C\u4E00\u4E2ASwing\u7A0B\u5E8F");
		frmswing.setBounds(100, 100, 343, 198);
		frmswing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmswing.getContentPane().setLayout(null);
		
		JButton btn1 = new JButton("\u70B9\u51FB\u6211");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "HelloWorld");
			}
		});
		btn1.setBounds(102, 70, 93, 23);
		frmswing.getContentPane().add(btn1);
	}

}
