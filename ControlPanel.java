import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel{

	private CatchGame panel;
	static JRadioButton easy, medium, hard, button;
	private static final int EASY_MODE = 1500, MED_MODE = 1000, HARD_MODE = 500;
	 public static boolean buttonIsSelected = false;
	
	public ControlPanel(CatchGame panel) {
		this.panel = panel;
		
		ControlPanel.ButtonListener listener = new ControlPanel.ButtonListener();
		ButtonGroup buttons = new ButtonGroup();
		easy = new JRadioButton("Easy");
		easy.addActionListener(listener);
		add(easy);
		buttons.add(easy);
		medium = new JRadioButton("Medium");
		medium.addActionListener(listener);
		add(medium);
		buttons.add(medium);
		hard = new JRadioButton("Hard");
		hard.addActionListener(listener);
		add(hard);
		buttons.add(hard);
		button = new JRadioButton("Break");
		add(button);
		buttons.add(button);
		button.addActionListener(listener);
		}
	
	public class ButtonListener implements ActionListener {
		private ButtonListener() {}
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			if (source == easy) {
				panel.setDelay(EASY_MODE);
				buttonIsSelected = false;
			} else if (source == medium) {
				panel.setDelay(MED_MODE);
				buttonIsSelected = false;
			} else if (source == hard) {
				panel.setDelay(HARD_MODE);
				buttonIsSelected = false;
			} else if (source == button) {
				buttonIsSelected = true;
			}
		}
	}
}
