
public class PersonRunner {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("Wendy");
		p2.setSuperPower("Levetates");

		System.out.println("P2 = " + p2 + ", superpower = " + p2.getSuperPower() + ", count = " + p2.getPersonCount());
		System.out.println("Using static method: " + Person.getPersonCount());
	}
}
