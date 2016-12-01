



import java.net.MalformedURLException;
import java.net.URL;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AnimalJumping {
	 public static void main(String[] args) throws MalformedURLException {


	        /* We want to show an animation of an animal sucking at jumping inside a JFrame.
	         * Once you have chosen from http://animalssuckingatjumping.tumblr.com/, right click and "Copy Image URL" or “Copy Image Address”
	         * Your program must:
	         * 		- show the animation in full without any user interaction. You don’t need a JPanel since it’s only one JComponent.
	         * 		- show the animation in the center of the screen. Clue: frame.setLocationRelativeTo(null)
	         * 		- have a title such as "Gerbil Fail"
	         */


		 	String urlOfAnimalSuckingAtJumping = "http://66.media.tumblr.com/fb876f3b0bd087d90343e2af61f28b8c/tumblr_nlgpkxfK8P1s612eao1_500.gif";
	       
		 	JFrame frame = new JFrame ("Jump failed!!");
		 	frame.add(createImage(urlOfAnimalSuckingAtJumping));
		 	frame.setLocationRelativeTo(null);
		 	frame.setSize(432,  242);
		 	frame.setVisible(true);
	    }
	 
	 static JLabel createImage(String imageURL) throws MalformedURLException {
		 	URL url = new URL(imageURL);
	        Icon icon = new ImageIcon(url);
	        return new JLabel(icon);
	 }
}




