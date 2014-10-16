package GameUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import GameObject.PlayerPlane;
import GameObject.Position;

public class LosePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LosePanel() {
		setOpaque(false);
		setSize(300, 200);
		setLayout(null);
		setBorder(new Border() {

			@Override
			public void paintBorder(Component c, Graphics g, int x, int y,
					int width, int height) {
				// TODO Auto-generated method stub
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke(3));
				g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
			}

			@Override
			public Insets getBorderInsets(Component c) {
				// TODO Auto-generated method stub
				return new Insets(1, 1, 1, 1);
			}

			@Override
			public boolean isBorderOpaque() {
				// TODO Auto-generated method stub
				return true;
			}

		});

		JLabel score = new JLabel("成绩：");
		score.setFont(new Font("华文行楷", Font.PLAIN, 18));
		score.setForeground(Color.DARK_GRAY);
		score.setBounds(10, 10, 60, 30);
		add(score);

		JLabel fenshu = new JLabel(GameFrame.gf.grade.grade + "");
		fenshu.setFont(new Font("华文行楷", Font.PLAIN, 18));
		fenshu.setForeground(Color.DARK_GRAY);
		fenshu.setBounds(100, 10, 60, 30);
		add(fenshu);

		final JLabel restart = new JLabel("     重新开始");
		restart.setFont(new Font("华文行楷", Font.PLAIN, 18));
		restart.setForeground(Color.DARK_GRAY);
		restart.setBounds(100, 70, 120, 40);
		restart.setBorder(new Border() {

			@Override
			public void paintBorder(Component c, Graphics g, int x, int y,
					int width, int height) {
				// TODO Auto-generated method stub
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke(3));
				g.drawRoundRect(0, 0, restart.getWidth() - 1,
						restart.getHeight() - 1, 10, 10);
			}

			@Override
			public Insets getBorderInsets(Component c) {
				// TODO Auto-generated method stub
				return new Insets(1, 1, 1, 1);
			}

			@Override
			public boolean isBorderOpaque() {
				// TODO Auto-generated method stub
				return true;
			}

		});
		restart.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				GameFrame.gf.c5.play();
				GameFrame.gf.panel.remove(GameFrame.gf.panel_5);
				GameFrame.gf.panel_5 = new GamePanel();
				GameFrame.gf.panel_5.setBounds(5, 25,
						GameFrame.gf.panel.getWidth() - 10,
						GameFrame.gf.panel.getHeight() - 40);
				GameFrame.gf.panel_5.setLayout(null);
				GameFrame.gf.panel.add(GameFrame.gf.panel_5);

				GameFrame.gf.playerplane = new PlayerPlane(new Position(
						GameFrame.gf.panel_5.getWidth() / 2 - 25,
						GameFrame.gf.panel_5.getHeight() - 80), 0);

				GameFrame.gf.grade = new GradePanel();
				GameFrame.gf.grade.setLocation(10, 15);
				GameFrame.gf.panel_5.add(GameFrame.gf.grade);

				GameFrame.gf.pause = new JLabel();
				GameFrame.gf.pause.setIcon(new ImageIcon(GameFrame.class
						.getResource("/image/pause.png")));
				GameFrame.gf.pause.setBounds(
						GameFrame.gf.panel_5.getWidth() - 50, 10, 40, 40);
				GameFrame.gf.pause.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						if (!GameFrame.gf.whether_pause&&GameFrame.gf.playerplane.alive==true) {
							GameFrame.gf.c5.play();
							GameFrame.gf.whether_pause = true;

							final JLabel quit = new JLabel("     退出游戏");
							quit.setFont(new Font("华文行楷", Font.PLAIN, 18));
							quit.setForeground(Color.DARK_GRAY);
							quit.setBounds(230, 320, 120, 40);
							quit.setBorder(new Border() {

								@Override
								public void paintBorder(Component c,
										Graphics g, int x, int y, int width,
										int height) {
									// TODO Auto-generated method stub
									Graphics2D g2 = (Graphics2D) g;
									g2.setColor(Color.black);
									g2.setStroke(new BasicStroke(3));
									g.drawRoundRect(0, 0, quit.getWidth() - 1,
											quit.getHeight() - 1, 10, 10);
								}

								@Override
								public Insets getBorderInsets(Component c) {
									// TODO Auto-generated method stub
									return new Insets(1, 1, 1, 1);
								}

								@Override
								public boolean isBorderOpaque() {
									// TODO Auto-generated method stub
									return true;
								}

							});
							quit.addMouseListener(new MouseListener() {

								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									GameFrame.gf.frame.dispose();
									GameFrame.gf.repaint.whether_stop = true;
									GameFrame.gf.c5.play();
								}

								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									quit.setCursor(new Cursor(
											Cursor.HAND_CURSOR));
									GameFrame.gf.c4.play();
								}

								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									quit.setCursor(new Cursor(
											Cursor.DEFAULT_CURSOR));
								}

							});
							GameFrame.gf.panel_5.add(quit);

							final JLabel goon = new JLabel("     继续游戏");
							goon.setFont(new Font("华文行楷", Font.PLAIN, 18));
							goon.setForeground(Color.DARK_GRAY);
							goon.setBounds(230, 270, 120, 40);
							goon.setBorder(new Border() {

								@Override
								public void paintBorder(Component c,
										Graphics g, int x, int y, int width,
										int height) {
									// TODO Auto-generated method stub
									Graphics2D g2 = (Graphics2D) g;
									g2.setColor(Color.black);
									g2.setStroke(new BasicStroke(3));
									g.drawRoundRect(0, 0, goon.getWidth() - 1,
											goon.getHeight() - 1, 10, 10);
								}

								@Override
								public Insets getBorderInsets(Component c) {
									// TODO Auto-generated method stub
									return new Insets(1, 1, 1, 1);
								}

								@Override
								public boolean isBorderOpaque() {
									// TODO Auto-generated method stub
									return true;
								}

							});
							goon.addMouseListener(new MouseListener() {

								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									GameFrame.gf.whether_pause = false;
									GameFrame.gf.panel_5.remove(goon);
									GameFrame.gf.panel_5.remove(quit);
									GameFrame.gf.c5.play();
								}

								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									goon.setCursor(new Cursor(
											Cursor.HAND_CURSOR));
									GameFrame.gf.c4.play();
								}

								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									goon.setCursor(new Cursor(
											Cursor.DEFAULT_CURSOR));
								}

							});
							GameFrame.gf.panel_5.add(goon);

							GameFrame.gf.panel.repaint();
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						GameFrame.gf.frame.setCursor(new Cursor(
								Cursor.HAND_CURSOR));
						GameFrame.gf.c4.play();
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						GameFrame.gf.frame.setCursor(new Cursor(
								Cursor.DEFAULT_CURSOR));
					}

				});
				GameFrame.gf.panel_5.add(GameFrame.gf.pause);

				GameFrame.gf.panel.repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				GameFrame.gf.c4.play();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		add(restart);

		final JLabel quit = new JLabel("     退出游戏");
		quit.setFont(new Font("华文行楷", Font.PLAIN, 18));
		quit.setForeground(Color.DARK_GRAY);
		quit.setBounds(100, 120, 120, 40);
		quit.setBorder(new Border() {

			@Override
			public void paintBorder(Component c, Graphics g, int x, int y,
					int width, int height) {
				// TODO Auto-generated method stub
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke(3));
				g.drawRoundRect(0, 0, quit.getWidth() - 1,
						quit.getHeight() - 1, 10, 10);
			}

			@Override
			public Insets getBorderInsets(Component c) {
				// TODO Auto-generated method stub
				return new Insets(1, 1, 1, 1);
			}

			@Override
			public boolean isBorderOpaque() {
				// TODO Auto-generated method stub
				return true;
			}

		});
		quit.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				GameFrame.gf.frame.dispose();
				GameFrame.gf.repaint.whether_stop = true;
				GameFrame.gf.c5.play();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				GameFrame.gf.c4.play();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		add(quit);
	}

	public void paintComponent(Graphics g) {
		g.setColor(new Color(193, 202, 199));
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
	}

}
