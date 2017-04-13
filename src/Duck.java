public class Duck {
	String myColor;
	String myFavFood;
	
	public void go () {
		System.out.println("Go duck go!!");
	}
	
	public Duck (String color, String favoriteFood) {
		myColor = color;
		myFavFood = favoriteFood;
		System.out.println("Duck constructor was called for the " + color + " duck that loves to eat " + favoriteFood + "!");
	}
	
	public void quack () {
		System.out.println("Quack-quack says the " + myColor + " duck.");
	}
	
	public void eat () {
		System.out.println("Munch-munch on " + myFavFood);
	}
}
