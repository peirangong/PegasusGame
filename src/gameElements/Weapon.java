package gameElements;

/** The weapon(s) that came from the armor. */
public class Weapon {
	private String name;
	private int att;
	private int def;
	private boolean special;

	public Weapon(String n, int a, int d, boolean s) {
		name = n;
		att = a;
		def = d;
		special = s;
	}

	public String getName() {
		return name;
	}

	public int getAtt() {
		return att;
	}

	public int getDef() {
		return def;
	}
}
