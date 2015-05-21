package Character;

public class Move {

	public static final String GATHER = "Gather";
	public static final String DEFENSE = "Defense";
	public static final String ARMOR = "Wear Armor";
	public static final String ATTACK_SKILL = "Use Skill";
	public static final String ATTACK_WEAPON = "Use Weapon";
	public static final String SPECIAL = "Special";

	protected String name = "";

	private BaseCharacter character = null;

	protected int att;

	protected int def;

	public Move(BaseCharacter ch, String n, int a, int d) {
		character = ch;
		name = n;
		att = a;
		def = d;
	}

	public BaseCharacter getCharacter() {
		return character;
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
