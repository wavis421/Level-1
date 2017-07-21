import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CutenessTV implements ActionListener {

	public static void main(String[] args) {
		new CutenessTV().createUI();
		TestClass test = new TestClass();
		System.out.println(test.getNumCats());
	}

	JFrame frame = new JFrame("Cuteness TV");
	JPanel panel = new JPanel();
	JButton ducksButton = new JButton();
	JButton frogButton = new JButton();

	private void createUI() {

		frame.add(panel);
		frame.setVisible(true);
		ducksButton.setText("Ducks");
		frogButton.setText("Frog");
		ducksButton.addActionListener(this);
		frogButton.addActionListener(this);
		panel.add(ducksButton);
		panel.add(frogButton);
		frame.pack();
	}

	void showDucks() {
		playVideo("Drirjl5K9Yk");
	}

	void showFrog() {
		playVideo("aSjCb-FfxhI");
	}

	void showFluffyUnicorns() {
		playVideo("qRC4Vk6kisY");
	}

	void playVideo(String videoID) {

		try {

			URI uri = new URI("https://www.youtube.com/watch?v=" + videoID + "?autoplay=1");

			java.awt.Desktop.getDesktop().browse(uri);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton)arg0.getSource();
		if (buttonPressed == ducksButton) {
			System.out.println("Duck button pressed");
			showDucks();
		}
		else if (buttonPressed == frogButton) {
			System.out.println("Frog button pressed");
			showFrog();
		}
	}
}
