package gameElements;

public class Move {

	public static final String GATHER = "Gather";
	public static final String DEFENSE = "Defense";
	public static final String ARMOR = "Wear Armor";
	public static final String ATTACK_SKILL = "Use Skill";
	public static final String ATTACK_WEAPON = "Use Weapon";
	public static final String SPECIAL = "Special";

	private boolean gather = false;
	private boolean defense = false;
	private boolean armor = false;
	private boolean attackSkill = false;
	private boolean attackWeapon = false;
	private boolean special = false;

	private String move = "";

	private Skill skill = null;

	private Weapon weapon = null;

	private BaseCharacter character = null;

	public Move(BaseCharacter ch, String m) {
		character = ch;
		move = m;
		if (m == GATHER) {
			gather = true;
		} else if (m == DEFENSE) {
			defense = true;
		} else if (m == ARMOR) {
			armor = true;
		} else if (m == SPECIAL) {
			special = true;
		} else {
			gather = false;
			defense = false;
			armor = false;
			attackSkill = false;
			attackWeapon = false;
			special = false;
		}
	}

	public Move(BaseCharacter ch, Skill s) {
		character = ch;
		attackSkill = true;
		skill = s;
	}

	public Move(BaseCharacter ch, Weapon w) {
		character = ch;
		attackWeapon = true;
		weapon = w;
	}

	public BaseCharacter getCharacter() {
		return character;
	}

	public String getMove() {
		return move;
	}

	public static boolean Analyze(Move A, Move B) {
		// TODO Auto-generated method stub
		int AtoB = A.getCharacter().getAttackPower()
				- B.getCharacter().getDefendPower();
		int BtoA = B.getCharacter().getAttackPower()
				- A.getCharacter().getDefendPower();
		if (BtoA > 0) {
			// B attacks A
			int lossArmor = (int) (BtoA / 10) + 1;
			A.getCharacter().lossArmor(lossArmor);
		} else if (AtoB > 0) {
			// A attacks B
			int lossArmor = (int) (AtoB / 10) + 1;
			B.getCharacter().lossArmor(lossArmor);
		}

		if (!A.getCharacter().isAlive() || !B.getCharacter().isAlive()) {
			return true;
		} else {
			return false;
		}
	}
}
