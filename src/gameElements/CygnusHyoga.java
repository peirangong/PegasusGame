package gameElements;

public class CygnusHyoga extends BaseCharacter {

	private Weapon w = new Weapon("Ice ring", 0, 10, true);

	public CygnusHyoga() {
		super();
		totalArmor = 2;
		armorWorn = 0;
		level = NOVICE;
		name = "Cygnus Hyoga";

		// TODO: skill name
		skills.add(new Skill("Diamond Microdust", 1, 1, 1));
		skills.add(new Skill("Diamond Stardust", 2, 2, 2));
		skills.add(new Skill("Absolute Zero", 4, 4, 4));
		skills.add(new Skill("Cosmo Explosion", 10, 10, 10));
		skills.add(new Skill("Aurora Sword", 12, 12, 12));
		skills.add(new Skill("Aurora Thunder", 16, 16, 16));
		skills.add(new Skill("Aurora Execution", 24, 24, 24));
	}
}