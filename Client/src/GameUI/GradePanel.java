package GameUI;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GradePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int grade = 0;

	public GradePanel() {
		setSize(120, 30);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		removeAll();

		StringBuffer sb = new StringBuffer(grade + "");
		JLabel l = new JLabel(new String(sb));
		l.setBounds(0, 0, getWidth(), getHeight());
		l.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		add(l);
	}

}
