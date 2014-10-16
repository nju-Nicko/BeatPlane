package GameUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import GameObject.PlayerPlane;
import GameObject.Position;

public class GameFrame {

	public JFrame frame;
	public PlayerPlane playerplane;
	public JPanel panel, panel_5;
	public int deta = 5;
	public RepaintThread repaint;
	GradePanel grade;
	public JLabel pause;
	private Color border_color = new Color(100, 100, 100);
	private int frameFirstX, frameFirstY;
	public static GameFrame gf;
	public boolean whether_pause = false;
	public AudioClip c1 = Applet.newAudioClip(GamePanel.class
			.getResource("/sound/b-explosion.wav"));
	public AudioClip c2 = Applet.newAudioClip(GamePanel.class
			.getResource("/sound/explosion.wav"));
	public AudioClip c3 = Applet.newAudioClip(GamePanel.class
			.getResource("/sound/shot.wav"));
	public AudioClip c4=Applet.newAudioClip(GamePanel.class
			.getResource("/sound/button.wav"));
	public AudioClip c5=Applet.newAudioClip(GamePanel.class
			.getResource("/sound/done.wav"));

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public static void main(String[] args) {
		gf = new GameFrame();
		gf.frame.setVisible(true);
	}

	public GameFrame() {
		initialize();
		repaint = new RepaintThread();
		repaint.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(320, 15, 580, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon(GameFrame.class
				.getResource("/image/playerplane.png")).getImage());
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				String key_text = KeyEvent.getKeyText(e.getKeyCode());
				switch (key_text) {
				case "A":
					if (playerplane.position.x >= 10 && playerplane.alive
							&& !whether_pause) {
						playerplane.position.x -= deta;
					}
					break;
				case "S":
					if (playerplane.position.y <= panel_5.getHeight() - 90
							&& playerplane.alive && !whether_pause) {
						playerplane.position.y += deta;
					}
					break;
				case "D":
					if (playerplane.position.x <= panel_5.getWidth() - 78
							&& playerplane.alive && !whether_pause) {
						playerplane.position.x += deta;
					}
					break;
				case "W":
					if (playerplane.position.y >= 10 && playerplane.alive
							&& !whether_pause) {
						playerplane.position.y -= deta;
					}
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		frame.addMouseListener(new MouseListener() {
			public void mouseExited(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				frameFirstX = e.getX();
				frameFirstY = e.getY();
			}
		});
		frame.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {

			}

			public void mouseDragged(MouseEvent e) {
				int detX = e.getX() - frameFirstX;
				int detY = e.getY() - frameFirstY;
				frame.setBounds(frame.getX() + detX, frame.getY() + detY,
						frame.getWidth(), frame.getHeight());
			}
		});

		panel = new JPanel();
		panel.setBounds(0, 0, 580, 700);
		panel.setBackground(new Color(0, 0, 0, 0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 580, 25);
		panel_1.setBackground(border_color);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, panel.getHeight() - 15, panel.getWidth(), 15);
		panel_2.setBackground(border_color);
		panel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, panel_1.getHeight(), 5, panel.getHeight() - 40);
		panel_3.setBackground(border_color);
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(panel.getWidth() - 5, panel_1.getHeight(), 5,
				panel.getHeight() - 40);
		panel_4.setBackground(border_color);
		panel.add(panel_4);

		panel_5 = new GamePanel();
		panel_5.setBounds(5, 25, panel.getWidth() - 10, panel.getHeight() - 40);
		panel_5.setLayout(null);
		panel.add(panel_5);

		final JLabel close = new JLabel("×");
		close.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		close.setForeground(Color.white);
		close.setBounds(panel_1.getWidth() - 25, 0, 25, 25);
		close.addMouseListener(new MouseListener() {

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
				frame.dispose();
				repaint.whether_stop = true;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
				close.setForeground(Color.cyan);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				close.setForeground(Color.white);
			}

		});
		panel_1.add(close);

		grade = new GradePanel();
		grade.setLocation(10, 15);
		panel_5.add(grade);

		pause = new JLabel();
		pause.setIcon(new ImageIcon(GameFrame.class
				.getResource("/image/pause.png")));
		pause.setBounds(panel_5.getWidth() - 50, 10, 40, 40);
		pause.addMouseListener(new MouseListener() {

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
				if (!whether_pause&&playerplane.alive==true) {
					GameFrame.gf.c5.play();
					whether_pause = true;

					final JLabel quit = new JLabel("     退出游戏");
					quit.setFont(new Font("华文行楷", Font.PLAIN, 18));
					quit.setForeground(Color.DARK_GRAY);
					quit.setBounds(230, 320, 120, 40);
					quit.setBorder(new Border() {

						@Override
						public void paintBorder(Component c, Graphics g, int x,
								int y, int width, int height) {
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
							quit.setCursor(new Cursor(Cursor.HAND_CURSOR));
							GameFrame.gf.c4.play();
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							quit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						}

					});
					panel_5.add(quit);

					final JLabel goon = new JLabel("     继续游戏");
					goon.setFont(new Font("华文行楷", Font.PLAIN, 18));
					goon.setForeground(Color.DARK_GRAY);
					goon.setBounds(230, 270, 120, 40);
					goon.setBorder(new Border() {

						@Override
						public void paintBorder(Component c, Graphics g, int x,
								int y, int width, int height) {
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
							whether_pause = false;
							panel_5.remove(goon);
							panel_5.remove(quit);
							GameFrame.gf.c5.play();
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							goon.setCursor(new Cursor(Cursor.HAND_CURSOR));
							GameFrame.gf.c4.play();
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							goon.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						}

					});
					panel_5.add(goon);

					panel.repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
				GameFrame.gf.c4.play();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		panel_5.add(pause);

		game_init();
	}

	public void game_init() {
		playerplane = new PlayerPlane(new Position(panel_5.getWidth() / 2 - 25,
				panel_5.getHeight() - 80), 0);
	}

}
