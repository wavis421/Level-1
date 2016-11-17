import java.applet.AudioClip;
import java.io.IOException;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class CowTimer {
	/*
	 * This is an advanced recipe. There may be more than one line of code for
	 * each instruction. Work in seconds when testing, then change to minutes
	 */
	public CowTimer() {
		System.out.println("Cow timer with no parameters");
	}

	public CowTimer(int minutes) {
		this.minutes = minutes;
		System.out.println("Cow timer constructor, " + minutes + " minutes");
	}

	public static void main(String[] args) throws InterruptedException {

		/* 1. Make a CowTimer, set the time and start it. */
		CowTimer cow = new CowTimer(10);
		// cow.setTime(10);
		cow.start();
		System.out.println("Goodbye...");
	}

	private int minutes;

	public void setTime(int minutes) {
		this.minutes = minutes;
		System.out.println("Cow set to " + minutes + " minutes.");
	}

	public void start() throws InterruptedException {
		/*
		 * 2. Count down the minutes, print the current minute then sleep for 60
		 * seconds using Thread.sleep(int milliseconds).
		 */
		for (int i = minutes; i > 0; i--) {
			System.out.println("Current minute = " + i);
			Thread.sleep(1000);
		}

		/*
		 * 3. When the timer is finished, use the playSound method to play a moo
		 * sound. You can download one from freesound.org, then drag it into
		 * your default package. Tell the students (by speaking) it's time to
		 * walk.
		 */
		// speak ("time for walk");
		JOptionPane.showMessageDialog(null, "Timer expired!!");

	}

	private void playSound(String fileName) {

		AudioClip sound = JApplet

				.newAudioClip(getClass().getResource(fileName));

		sound.play();

	}

	private void speak(String stuffToSay) {

		try {

			Runtime.getRuntime().exec("say " + stuffToSay).waitFor();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
