
public class JamesBond {
	public int findCode(Vault vault) {
		for (int i = 1; i < 1000000; i++) {
			if (vault.tryCode(i))
				return i;
		}
		return -1;
	}
}
