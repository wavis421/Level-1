import java.awt.Frame;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BodyPartQuiz {

	// Get 3 celebrity photos from the internet, save them to your computer, and
	// fill
	// in their paths here. To get the path, right click on the image, and copy
	// its Location.
	String firstImage = "C:/Users/Wendy/workspace/Level 1/cat1.jpg";
	String secondImage = "C:/Users/Wendy/workspace/Level 1/cat2.jpg";
	String thirdImage = "C:/Users/Wendy/workspace/Level 1/cat3.jpg";

	Frame window = new Frame();

	private void startQuiz() {
		// Set the size of the window so that you can only see part of the
		// image.

		// Make an int variable to hold the score.
		int score = 0;

		for (int i = 0; i < 4; i++) {
			window.setSize(100, 100);
			// Ask the user who this person is and store their answer
			String answer = JOptionPane.showInputDialog("Who is this?");
			// If they got the answer right:
			// -- Tell them they are correct.
			// -- Increase the score by 1

			// Otherwise:
			// -- Tell them they are wrong
			if (answer.equals("cat1"))
				score++;
			
			// Use the method below to show the next image
			showNextImage();
		}
		JOptionPane.showMessageDialog(null, "Your score is " + score);
		// Show the score
		// .... repeat for all your images.....
	}

	public void showNextImage() {
		window.removeAll();
		window.add(getNextImage());
		window.pack();
	}

	public static void main(String[] args) {
		BodyPartQuiz quiz = new BodyPartQuiz();
		quiz.initializeGui();
		quiz.startQuiz();
	}

	private void initializeGui() {
		initializeImageList();
		imageIterator = imageList.iterator();
		window.setVisible(true);
		showNextImage();
	}

	private JLabel loadImage(String fileName) {
		Icon icon = new ImageIcon(fileName);
		JLabel image = new JLabel(icon);
		return image;
	}

	ArrayList<JLabel> imageList = new ArrayList<JLabel>();
	Iterator<JLabel> imageIterator;

	private void initializeImageList() {
		JLabel imageLabel = loadImage(firstImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(secondImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(thirdImage);
		imageList.add(imageLabel);
	}

	private JLabel getNextImage() {
		if (imageIterator.hasNext())
			return imageIterator.next();
		window.dispose();
		return new JLabel();
	}
}
