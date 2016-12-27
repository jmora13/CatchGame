import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class CatchGame extends JPanel {
	private int xPos, yPos, wait = 1500;
	private int hitCount = 0;
	private int length = 100, width = 500, height = 600;
	private Timer timer;
	Random r;
	
	public CatchGame() {
		r = new Random();
		xPos = r.nextInt(width - length);
		yPos = r.nextInt(height - length);
		timer = new Timer(wait, new CatchGame.TimerListener());
		timer.start();
		addMouseListener(new CatchGame.ClickListener());
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		setBackground(Color.black);
		
		page.setColor(Color.GREEN);
		page.fill3DRect(xPos, yPos, 50, 50, true);
		page.setColor(Color.ORANGE);
		page.setFont(new Font("Century Gothic", 0 , 40));
		page.drawString("Hit Count: " + hitCount, 150, 50);

		if (ControlPanel.buttonIsSelected == true ) {
		page.setColor(Color.BLUE);
		page.setFont(new Font("Serif", 0 , 50));
		page.drawString("Have A Nice", 80, 150);
		page.drawString("Winter Break!", 70, 200);
		page.drawString("¯\\_(ツ)_/¯", 130, 250);
		}
	}
	
	public boolean hit(Point p) {
		double hitX = p.getX();
		double hitY = p.getY();
		if (hitX >= xPos && hitY >= yPos) {
			return true;
		}
		return false;
	}
	
	public void setDelay(int wait) {
		this.wait = wait;
		timer.setDelay(wait);
	}
	
	private class ClickListener extends MouseAdapter {
		private ClickListener() {}
		
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();
			if(CatchGame.this.hit(p)) {
				CatchGame.this.hitCount++;
				CatchGame.this.repaint();
			}
		}
	}
	
	private class TimerListener implements ActionListener {
		private TimerListener() {} 
		public void actionPerformed(ActionEvent event) {
			xPos = r.nextInt(width - length);
			yPos = r.nextInt(height - length);
			repaint();
			}
		}
	}
