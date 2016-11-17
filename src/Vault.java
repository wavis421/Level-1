import java.util.Random;

public class Vault {
	private int secretCode = new Random().nextInt(1000000) + 1;
	
	public boolean tryCode(int guess) {
		if (guess == secretCode) 
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Vault vault = new Vault();
		JamesBond bond = new JamesBond();
		int code = bond.findCode(vault);
		
		if (code == -1)
			System.out.println("Code not broken!");
		else
			System.out.println("Code is " + code);
	}
}
