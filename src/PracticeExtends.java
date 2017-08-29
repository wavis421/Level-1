import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PracticeExtends extends MouseAdapter {
	public static void main(String[] args) {
		new PracticeExtends();
	}

	public PracticeExtends() {
		JFrame frame = new JFrame();
		JButton button = new JButton("Click me");

		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();

		button.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked!");

	}
}
