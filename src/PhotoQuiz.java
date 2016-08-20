
// Copyright Wintriss Technical Schools 2013

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public static void main(String[] args) throws Exception {

		JFrame quizWindow = new JFrame();

		quizWindow.setVisible(true);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// �Copy Image URL�)
		String myCatPic = "http://hdwallpaperia.com/wp-content/uploads/2013/12/Cute-Kitten-Wallpaper-Free.jpg";

		// 2. create a variable of type "Component" that will hold your image
		Component catComponent;

		// 3. use the "createImage()" method below to initialize your Component
		catComponent = createImage(myCatPic);

		// 4. add the image to the quiz window
		quizWindow.add(catComponent);

		// 5. call the pack() method on the quiz window
		quizWindow.pack();

		// 6. ask a question that relates to the image
		String answer = JOptionPane.showInputDialog("Is this a cute cat?");

		// 7. print "CORRECT" if the user gave the right answer
		if (answer.equals("yes"))
		{
			JOptionPane.showMessageDialog(null,  "I agree!!!!");
		}

		// 8. print "INCORRECT" if the answer is wrong

		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quizWindow.remove(catComponent);

		// 10. find another image and create it (might take more than one line
		// of code)
		myCatPic = "http://www.fabuloussavers.com/new_wallpaper/Impossiblycutekitten-catswallpaper-freecomputerdesktopwallpaper_1024.jpg";
		catComponent = createImage (myCatPic);
		quizWindow.add(catComponent);
		quizWindow.pack();
		
		answer = JOptionPane.showInputDialog("Do you love this cute cat?");
		if (answer.equals("yes"))
		{
			JOptionPane.showMessageDialog(null,  "I so agree!!!!");
		}
		
		quizWindow.remove(catComponent);
		quizWindow.pack();

		// 11. add the second image to the quiz window

		// 12. pack the quiz window

		// 13. ask another question

		// 14+ check answer, say if correct or incorrect, etc.

	}


	private static Component createImage(String imageUrl) throws MalformedURLException {

		URL url = new URL(imageUrl);

		Icon icon = new ImageIcon(url);

		JLabel imageLabel = new JLabel(icon);

		return imageLabel;

	}

	/* OPTIONAL */

	// *14. add scoring to your quiz

	// *15. make something happen when mouse enters image
	// (catComponent.addMouseMotionListener())

}
