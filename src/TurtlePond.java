import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.TurtlePanel;

public class TurtlePond implements KeyEventDispatcher {

	// 1. Set a location for the food
	int cookieX = 500;
	int cookieY = 50;

	// 2. Choose the speed you want the Tortoise to go at
	int speed = 5;

	void setup() {

		// 3. Add an intro message to tell the user what to do
		JOptionPane.showMessageDialog(null,
				"Move the turtle with the arrow keys to find it's food.\nYou'll get warmer the closer you get.\n\nHurry or she'll die of hunger!");
		// 4. For debugging purposes, show the food
		//showCookie();
	}

	public JLabel loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	private void goUp() {
		Tortoise.move(speed);
	}

	private void goDown() {
		Tortoise.move(-speed);
		System.out.println("down");
	}

	private void goLeft() {
		// 5. make the tortoise move left (3 lines of code)
		Tortoise.turn(-90);
		Tortoise.move(speed);
		Tortoise.turn(90);
	}

	private void goRight() {
		// 6. make the tortoise move right
		Tortoise.turn(90);
		Tortoise.move(speed);
		Tortoise.turn(-90);
	}

	private void checkForFood() throws Exception {
		int tortoiseLocationX = Tortoise.getX();
		int tortoiseLocationY = Tortoise.getY();

		// 7. If the Tortoise is within 100 pixels of the food, set the
		// background color to yellow
		if (Math.abs(tortoiseLocationX - cookieX) < 100 && Math.abs(tortoiseLocationY - cookieY) < 100)
			setBackgroundColor(Color.yellow);

		// 8. If the Tortoise is within 50 pixels of the food, set the
		// background color to orange
		if (Math.abs(tortoiseLocationX - cookieX) < 50 && Math.abs(tortoiseLocationY - cookieY) < 50)
			setBackgroundColor(Color.orange);

		// 9. If the Tortoise is within 20 pixels of the food, set the
		// background color to red
		if (Math.abs(tortoiseLocationX - cookieX) < 20 && Math.abs(tortoiseLocationY - cookieY) < 20)
			setBackgroundColor(Color.red);

		// 10. If tortoise is within 5 pixels of the cookie, make a pop-up to
		// tell them they found it
		if (Math.abs(tortoiseLocationX - cookieX) < 5 && Math.abs(tortoiseLocationY - cookieY) < 5)
			JOptionPane.showMessageDialog(null, "you found it!");

		// 11. If the Tortoise crosses it's own path, move them back to the
		// beginning
		if (wasHereBefore(tortoiseLocationX, tortoiseLocationY)) {
			Tortoise.penUp();
			Tortoise.setX((int) getFirstLocation().getX());
			Tortoise.setY((int) getFirstLocation().getY());
			Tortoise.penDown();
		}

		// 12. If more than 20 seconds have elapsed, tell them the turtle died
		// of hunger
		if (getTimeElapsed() > 60) {
			JOptionPane.showMessageDialog(null, "hungry turtle now dead");
			System.exit(0);
		}
	}

	private long getTimeElapsed() {
		Date currentTime = new Date();
		return (currentTime.getTime() - startTime.getTime()) / 1000;
	}

	void setBackgroundColor(Color color) {
		Tortoise.getBackgroundWindow().setBackground(color);
	}

	private void showCookie() {
		Tortoise.getBackgroundWindow().addPaintable(new Paintable() {
			public void paint(Graphics2D g, JPanel caller) {
				g.drawOval(cookieX, cookieY, 10, 10);
			}
		});
	}

	private boolean wasHereBefore(int xPosition, int yPosition) {
		if (previousLocations.contains(new Point(xPosition, yPosition)))
			return true;
		else
			return false;
	}

	private Point getFirstLocation() {
		return previousLocations.get(0);
	}

	/***********************
	 * don't worry about the stuff under here
	 ******************/

	TurtlePanel window = Tortoise.getBackgroundWindow();
	Date startTime = new Date();

	public static void main(String[] args) {
		TurtlePond feeder = new TurtlePond();
		feeder.controlTheTortoise();
		feeder.setup();
	}

	private void controlTheTortoise() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		Tortoise.show();
		Tortoise.setPenColor(Colors.Purples.DarkMagenta);
		Tortoise.getBackgroundWindow().setBackground(Colors.Grays.SlateGray);
		Tortoise.setSpeed(10);
	}

	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {

			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				goRight();
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				goLeft();
			if (e.getKeyCode() == KeyEvent.VK_UP)
				goUp();
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				goDown();

			try {
				checkForFood();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			savePosition(Tortoise.getX(), Tortoise.getY());
		}
		return false;
	}

	ArrayList<Point> previousLocations = new ArrayList<Point>();

	private void savePosition(int xPosition, int yPosition) {
		previousLocations.add(new Point(xPosition, yPosition));
	}
}
