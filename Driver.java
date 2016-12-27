//Jose Mora
//12-16-15
//CatchGame
//Have a nice break!
import java.awt.*;
import javax.swing.*;

public class Driver {
	
	public static void main(String[] args) {
	JFrame frame = new JFrame("It's Here!");
	CatchGame panel = new CatchGame();
	ControlPanel panel2 = new ControlPanel(panel);
	
    frame.setSize(new Dimension(500, 600));
	frame.getContentPane().add(panel, "Center");
	frame.getContentPane().add(panel2, "South");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setResizable(false);
	}	
}
