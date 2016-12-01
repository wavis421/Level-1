import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor implements KeyListener {
	char currentLetter = generateRandomLetter();
	JLabel label;
	
	public static void main(String[] args) {
		new TypingTutor();
	}

	public TypingTutor () {

		JFrame frame = new JFrame("Typing Tutor");
		label = new JLabel(String.valueOf(currentLetter));
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		frame.addKeyListener(this);
		frame.add(label);
		frame.pack();
		frame.setVisible(true);	
	}
	
	static char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		currentLetter = arg0.getKeyChar();
		label.setText(String.valueOf(currentLetter));
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
