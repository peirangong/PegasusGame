package gameElements;

public class PegasusSeiya extends BaseCharacter {

	private Weapon w = new Weapon("Golden Arrow", 9, 9, false);

	public PegasusSeiya() {
		super();
		totalArmor = 1;
		armorWorn = 0;
		level = NOVICE;
		name = "Pegasus Seiya";

		// TODO: skill name
		skills.add(new Skill("Pegasus Meteor Fist", 2, 2, 2));
		skills.add(new Skill("Pegasus Comet Fist", 4, 4, 4));
		skills.add(new Skill("Pegasus Rolling Crush", 6, 6, 6));
		skills.add(new Skill("Cosmo Explosion", 10, 10, 10));
	}

}
