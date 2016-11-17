import java.awt.Color;

public class Runner {
	public static void main(String[] args) {
		Duck duck = new Duck ("yellow", "Pizza");
		duck.eat();
		duck.quack();
		
		/* Do the following things without changing the Cat class */
		// 1. Make the Cat meow
		Cat cat1 = new Cat("Jewel");
		cat1.meow();

		// 2. Get the Cat to print it's name
		cat1.printName();
		
		// 3. Kill the Cat!
		for (int i = 0; i < 12; i++)
			cat1.kill();
	}
}
