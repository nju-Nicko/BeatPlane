package GameUI;

public class RepaintThread extends Thread {

	public boolean whether_stop = false;
	public static int counter = 0;
	public static int stone_counter = 0;
	public static int enemy_counter = 0;

	public void run() {
		while (!whether_stop) {
			if (!GameFrame.gf.whether_pause) {
				GameFrame.gf.panel_5.repaint();
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
