import java.awt.Color;
import java.util.Random;

import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;

public class Houses {
	public static void main(String[] args) {
		Tortoise.setSpeed(10);
		Tortoise.penUp();

		Tortoise.getBackgroundWindow().setColor(Color.black);
		Tortoise.setX(10);
		Tortoise.setY(430);
		Tortoise.penDown();

		for (int i = 0; i < 10; i++) {
			drawHouse(new Random().nextInt(200) + 50, PenColors.getRandomColor());
		}
	}

	private static void drawHouse(int height, Color color) {
		if (height > 150)
			drawSquareHouse (height, color);
		else
			drawPointyHouse(height, color);
	}


	private static void drawPointyHouse(int height, Color color) {
		Tortoise.setPenColor(color);
		Tortoise.setAngle(0);
		Tortoise.move(height);
		Tortoise.turn(45);
		Tortoise.move(20);
		Tortoise.turn(90);
		Tortoise.move(20);
		Tortoise.setAngle(180);
		Tortoise.move(height);
		Tortoise.setPenColor(Color.green);
		Tortoise.setAngle(90);
		Tortoise.move(10);
	}
	
	private static void drawSquareHouse(int height, Color color) {
		Tortoise.setPenColor(color);
		Tortoise.setAngle(0);
		Tortoise.move(height);
		Tortoise.setAngle(90);
		Tortoise.move(40);
		Tortoise.setAngle(180);
		Tortoise.move(height);
		Tortoise.setPenColor(Color.green);
		Tortoise.setAngle(90);
		Tortoise.move(10);
	}
}
