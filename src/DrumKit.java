
// Copyright Wintriss Technical Schools 2013

import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrumKit extends MouseAdapter {

	JLabel drumLabelWithImage;
	JLabel drumLabelWithImage2;
	JLabel drumLabelWithImage3;

	public static void main(String[] args) throws MalformedURLException  {
		new DrumKit().getGoing();
	}

	private void getGoing() throws MalformedURLException {
		// 1. Make a JFrame variable and initialize it using "new JFrame()"
		JFrame frame = new JFrame();

		// 2. Make the frame visible
		frame.setVisible(true);
		// 3. Set the size of the frame
		frame.setSize(650, 664);
		// 4. Set the title of the frame
		frame.setTitle("Drum Kit");
		// 5. Make a JPanel and initialize it.
		JPanel panel = new JPanel();
		// 6. Add the panel to the frame. (The panel is invisible.)
		frame.add(panel);
		// 7. Download an image of a drum from the Internet. Drop it into your
		// Eclipse project under "default package".
		// 8. Put the name of your image in a String variable.
		String drumImageString = "drum.jpg";
		String drumImageString2 = "drum2.png";
		String drumImageString3 = "drum3.png";

		// 9. Edit the next line to use your String variable
		drumLabelWithImage = createLabelImage(drumImageString);
		drumLabelWithImage2 = createLabelImage(drumImageString2);
		drumLabelWithImage3 = createLabelImage(drumImageString3);

		// 10. Add the image to the panel
		panel.add(drumLabelWithImage);
		panel.add(drumLabelWithImage2);
		panel.add(drumLabelWithImage3);;
		
		// 11. Set the layout of the panel to "new GridLayout()"
		panel.setLayout(new GridLayout());
		// 12. call the pack() method on the frame
		frame.pack();
		// 13. add a mouse listener to drumLabelWithImage.
		drumLabelWithImage.addMouseListener(this);
		drumLabelWithImage2.addMouseListener(this);
		drumLabelWithImage3.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel drumClicked = (JLabel) e.getSource();
		
		// 15. Download a drum sound and drop it into your "default
		// package".
		// You can find it on freesound.org. To download it, log in as
		// leagueofamazing/code4life.
		
		// 16. If they clicked on the drumImage...
		if (drumClicked == drumLabelWithImage)
			playSound ("cat-rats-drum.wav");
		else if (drumClicked == drumLabelWithImage2)
			playSound("drum2.wav");
		else {
			playSound("drum3.wav");
		}
		

		// 17. ...use the playSound method to play a drum sound.

		// 18. Add more images to make a drumkit. Remember to add a
		// mouse
		// listener to each one.
	}

	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

}
