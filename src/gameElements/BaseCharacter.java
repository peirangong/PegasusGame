package Character;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Character.Weapon.SpecialWeapon;

public class BaseCharacter {

	// TODO: documentation of variables
	private static final boolean DEBUG = true;

	protected int totalArmor;
	protected int armorWorn;
	protected int level;
	protected String name;
	protected int energy;
	// protected boolean defend;
	protected boolean weaponReady;
	protected int attackPwr;
	protected int defendPwr;

	protected List<Skill> skills;
	protected LinkedList<Weapon> weapons;

	public static final int NOVICE = 1;
	public static final int MEDIUM = 2;
	public static final int EXPERT = 3;

	public BaseCharacter() {
		totalArmor = 0;
		armorWorn = 0;
		level = NOVICE;
		name = "Default Character";
		energy = 0;
		weaponReady = false;
		attackPwr = 0;
		defendPwr = 0;

		skills = new ArrayList<Skill>();
		weapons = new LinkedList<Weapon>();
	}

	public String getStatus() {
		String s = name + " - Armors Worn: " + armorWorn + ", Armors Left: "
				+ totalArmor + ", Energy: " + energy;
		return s;
	}

	public boolean isAlive() {
		return (armorWorn >= 0);
	}

	public String toString() {
		return name + " Armor: " + totalArmor + " Level: " + level;
	}

	public Move gather() {

		attackPwr = 0;
		defendPwr = 0;
		energy = energy + 2;
		Move move = new Move(this, Move.GATHER, attackPwr, defendPwr);
		if (DEBUG) {
			System.out.println(name + " gathers!");
		}

		return move;
	}

	public Move defense() {
		attackPwr = 0;
		defendPwr = 10;
		Move move = new Move(this, Move.DEFENSE, attackPwr, defendPwr);
		if (DEBUG) {
			System.out.println(name + " defends!");
		}

		return move;
	}

	public Move wearArmor() {
		Move move;
		attackPwr = 0;
		defendPwr = 10;

		if (totalArmor > 0) {
			if (!weaponReady) {
				weaponReady = true;
			}
			armorWorn++;
			totalArmor--;
			move = new Move(this, Move.ARMOR, attackPwr, defendPwr);

			if (DEBUG) {
				System.out.println(name + " wears one piece of armor!");
			}

		} else {
			move = new Move(this, Move.ARMOR, attackPwr, defendPwr);

			if (DEBUG) {
				System.out.println("No more armor! " + name + " defends!");
			}
		}

		return move;
	}

	public Skill attack(Skill s) {
		Skill move;

		if (energy < s.getCost()) {
			System.out.println("Not enough energy!");
			attackPwr = 0;
			defendPwr = 10;
			move = new Skill(this, Move.DEFENSE, attackPwr, defendPwr, 0);
		} else {
			energy = energy - s.getCost();
			attackPwr = s.getAtt();
			defendPwr = s.getDef();
			move = new Skill(this, s.getName(), attackPwr, defendPwr,
					s.getCost());
			if (DEBUG) {
				System.out.println("Attack! " + s.getName());
			}
		}

		return move;

	}

	public Weapon attack(LinkedList<Weapon> weaponList, int loc) {
		Weapon w = weaponList.get(loc);
		Weapon move;
		if (!weaponReady) {
			System.out.println("Weapon is not ready!");
			attackPwr = 0;
			defendPwr = 10;
			move = new Weapon(this, Move.DEFENSE, attackPwr, defendPwr,
					SpecialWeapon.Regular);
		} else {
			attackPwr = w.getAtt();
			defendPwr = w.getDef();
			if (DEBUG) {
				System.out.println("Attack! " + w.getName());
			}
			weaponList.remove(loc);
			move = new Weapon(this, w.getName(), attackPwr, defendPwr,
					w.getSpecial());
		}

		return move;
	}

	public List<Skill> getAvailableSkills() {
		List<Skill> s = new ArrayList<Skill>();
		for (int i = 0; i < skills.size(); i++) {
			if (skills.get(i).getCost() <= energy) {
				s.add(skills.get(i));
			}
		}

		if (DEBUG) {
			if (s.size() > 0) {
				System.out.print("Available skills: ");
				for (int i = 0; i < s.size() - 1; i++) {
					System.out.print(s.get(i).getName() + ", ");
				}
				System.out.print(s.get(s.size() - 1).getName());
			} else {
				System.out.print("No available skills");
			}
			System.out.println();
		}

		return s;
	}

	public int getAttackPower() {
		return attackPwr;
	}

	public int getDefendPower() {
		return defendPwr;
	}

	public void lossArmor(int loss) {
		armorWorn = armorWorn - loss;
		if (DEBUG) {
			System.out.println(this.name + " loses " + loss + " armors!");
		}
	}

	public String getName() {
		return name;
	}

	public int getEnergy() {
		return energy;
	}

	public LinkedList<Weapon> getWeapons() {
		if (!weaponReady) {
			return new LinkedList<Weapon>();
		}
		return weapons;
	}

	public void increaseWeapon(Weapon w) {
		weapons.add(w);
		if (DEBUG) {
			System.out.println(this.name + " captures " + w.getName());
		}
	}

	public void increaseEnergy() {
		energy = energy + 2;
		if (DEBUG) {
			System.out.println(this.name + " captures energy!");
		}
	}

	public void increaseArmor() {
		totalArmor++;
		if (DEBUG) {
			System.out.println(this.name + " captures armor!");
		}
	}
}
