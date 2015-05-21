package gameElements;

public class Skill {

	private String name;
	private int att;
	private int def;
	private int cost;

	public Skill(String n, int a, int d, int c) {
		name = n;
		att = a;
		def = d;
		cost = c;
	}

	public void useSkill() {
		// TODO: finish
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

	public int getCost() {
		return cost;
	}

}
