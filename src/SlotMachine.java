import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SlotMachine extends JPanel implements ActionListener{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	private JFrame window;
	
	private JButton spinButton;
	
	private BufferedImage orangeImage;
	private BufferedImage bananaImage;
	private BufferedImage cherryImage;
	private BufferedImage leftImage;
	private BufferedImage centerImage;
	private BufferedImage rightImage;
	
	private Timer reelTimer;
	
	public static void main(String[] args) {
		new SlotMachine();
	}
	
	public SlotMachine(){
		
		try{
			orangeImage = ImageIO.read(this.getClass().getResourceAsStream("orange.jpg"));
			bananaImage = ImageIO.read(this.getClass().getResourceAsStream("banana.jpg"));
			cherryImage = ImageIO.read(this.getClass().getResourceAsStream("cherry.jpg"));
			
			leftImage = orangeImage;
			centerImage = bananaImage;
			rightImage = cherryImage;
			
		}catch(Exception e){
			System.err.println("ERROR: There was an error loading your image.");
			System.err.println("Please make sure that the file is named correctly.");
		}
		
		window = new JFrame("WIN BIG!!");
		window.add(this);
		
		spinButton = new JButton("SPIN");
		add(spinButton);
		spinButton.addActionListener(this);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setSize(WIDTH, HEIGHT);	
	}
	
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(leftImage, 10, 250, 160, 160, null);
		g.drawImage(centerImage, 170, 250, 160, 160, null);
		g.drawImage(rightImage, 330, 250, 160, 160, null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == spinButton){
			reelTimer = new Timer(100, new TimerUpdate());
			reelTimer.start();
		}
		
	}
	
	private class TimerUpdate implements ActionListener{
		
		private final long reel1Time = 2000;
		private final long reel2Time = 4000;
		private final long reel3Time = 6000;
		
		private long startTime = -1;
		
		private int wheelOneInt = 0;
		private int wheelTwoInt = 0;
		private int wheelThreeInt = 0;
		
		Random random = new Random();
		
		public void actionPerformed(ActionEvent e) {
			wheelOneInt = random.nextInt(3);
			wheelTwoInt = random.nextInt(3);
			wheelThreeInt = random.nextInt(3);
			
			if(startTime == -1){
				startTime = System.currentTimeMillis();
			}
			
			if(System.currentTimeMillis() - startTime <= reel1Time){
				 leftImage = getImage(wheelOneInt);
			}
			
			if(System.currentTimeMillis() - startTime <= reel2Time){
				centerImage = getImage(wheelTwoInt);
			}
			
			if(System.currentTimeMillis() - startTime <= reel3Time){
				rightImage = getImage(wheelThreeInt);
			}else{
				reelTimer.stop();
			}
			
			
			repaint();
		}
		
		private BufferedImage getImage(int i){
			switch(i){
			case 0: return orangeImage;
			case 1: return bananaImage;
			case 2: return cherryImage;
			default: return cherryImage;
			}
		}
	}
}

