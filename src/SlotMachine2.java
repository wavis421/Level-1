import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SlotMachine2 extends JPanel implements ActionListener {
	public static void main(String[] args) {
		new SlotMachine2();
	}

	private BufferedImage orangeImage;
	private BufferedImage bananaImage;
	private BufferedImage cherryImage;
	
	private BufferedImage leftImage;
	private BufferedImage centerImage;
	private BufferedImage rightImage;
	
	public SlotMachine2() {
		try {
			orangeImage = ImageIO.read(this.getClass().getResourceAsStream("orange2.jpg"));
			bananaImage = ImageIO.read(this.getClass().getResourceAsStream("banana.jpg"));
			cherryImage = ImageIO.read(this.getClass().getResourceAsStream("cherry.jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		leftImage = orangeImage;
		centerImage = bananaImage;
		rightImage = cherryImage;
		
		JFrame frame = new JFrame();
		frame.add(this);
		JButton spinButton = new JButton("Spin");
		add(spinButton);
		spinButton.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	private BufferedImage getRandomImage() {
		 int r = new Random().nextInt(3);
		 if (r == 0)
			 return bananaImage;
		 else if (r == 1) 
			 return orangeImage;
		 else
			 return cherryImage;
	}
	
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(leftImage, 10, 250, 160, 160, null);
		g.drawImage(centerImage, 170, 250, 160, 160, null);
		g.drawImage(rightImage, 330, 250, 160, 160, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		leftImage = getRandomImage();
		centerImage = getRandomImage();
		rightImage = getRandomImage();
		
		repaint();
	}
}
