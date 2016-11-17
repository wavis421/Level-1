
public class Person {
	private String name;
	private String superPower;
	private static int personCount = 0;
	
	public Person () {
		this.name = "Who are you?";
		personCount++;
	}
	public Person(String name) {
		this.name = name;
		personCount++;
	}
	
	public static int getPersonCount() {
		return personCount;
	}
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuperPower() {
		return superPower;
	}
	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}
}
