import java.util.ArrayList;
import java.util.Collections;

public class MeetMyFamily {
	ArrayList<FamilyMember> famList = new ArrayList<FamilyMember>();

	public MeetMyFamily() {
	}
	
	public void addFamilyMember (String newMember, int age) {
		famList.add(new FamilyMember(newMember, age));
	}
	
	public void showFamilyMembers () {
		Collections.sort(famList);
		
		System.out.println("My family members are: ");
		for (FamilyMember f : famList) {
			System.out.println("   " + f.getName() + ", age " + f.getAge());
		}
	}
}
