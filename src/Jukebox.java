
// Copyright The League of Amazing Programmers, 2015
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox extends MouseAdapter implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());
	}

	static Song currentSong;

	public void run() {

		// 3. Find an mp3 on your computer or on the Internet.
		// 4. Create a Song
		//currentSong = new Song("C:\\Users\\Wendy\\Downloads\\Memory.mp3.crdownload");
		currentSong = new Song("Memory.mp3");

		// 5. Play the Song
		System.out.println("Playing song " + currentSong.toString());
		currentSong.play();

		/*
		 * 6. Create a user interface for your Jukebox so that the user can to choose
		 * which song to play. You can use can use a different button for each song, or
		 * a picture of the album cover. When the button or album cover is clicked, stop
		 * the currently playing song, and play the one that was selected.
		 * 
		 */
		new Jukebox().createUI();
	}

	JLabel barbaraLabel;
	JLabel guitarLabel;

	private void createUI() {
		JFrame jFrame = new JFrame();
		jFrame.setVisible(true);
		JPanel jPanel = new JPanel();
		jFrame.add(jPanel);
		barbaraLabel = loadImage("barbara.jpg");
		guitarLabel = loadImage("guitar.jpg");
		jPanel.add(barbaraLabel);
		jPanel.add(guitarLabel);
		jFrame.pack();
		barbaraLabel.addMouseListener(this);
		guitarLabel.addMouseListener(this);

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		currentSong.stop();
		if (e.getSource() == barbaraLabel) {
			currentSong = new Song("Memory.mp3");

			// 5. Play the Song
			currentSong.play();
		}
		else if (e.getSource() == guitarLabel) {
			currentSong = new Song("guitar.mp3");
			currentSong.play();
		}
	}
}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}
