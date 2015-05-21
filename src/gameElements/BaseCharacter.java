package gameElements;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class BaseCharacter {

	// TODO: documentation of variables
	private static final boolean DEBUG = true;
    private static final String TAG = "PegasusGame";
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
	protected List<Weapon> weapons;

	public String fightLog = "";

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
		weapons = new ArrayList<Weapon>();
		fightLog = "";
	}

	public String getStatus() {
		String s = "Armors Worn: " + armorWorn + ", Armors Left: " + totalArmor
				+ ", Energy: " + energy;
		return s;
	}

	public boolean isAlive() {
		return (armorWorn >= 0);
	}

	@Override
    public String toString() {
		return name + " Armor: " + totalArmor + " Level: " + level;
	}

	public Move gather() {
		Move move = new Move(this, Move.GATHER);

		attackPwr = 0;
		defendPwr = 0;
		energy = energy + 2;
		if (DEBUG) {
			Log.d(TAG, name + " gathers!");
		}
		fightLog += name + " gathers!" + "\n";

		return move;
	}

	public Move defense() {
		Move move = new Move(this, Move.DEFENSE);

		attackPwr = 0;
		defendPwr = 10;
		if (DEBUG) {
			Log.d(TAG, name + " defends!");
		}
		fightLog += name + " defends!" + "\n";

		return move;
	}

	public Move wearArmor() {
		Move move = new Move(this, Move.ARMOR);

		attackPwr = 0;
		defendPwr = 10;
		if (totalArmor > 0) {
			if (!weaponReady) {
				weaponReady = true;
			}
			armorWorn++;
			totalArmor--;

			if (DEBUG) {
				Log.d(TAG, name + " wears one piece of armor!");
			}
			fightLog += name + " wears one piece of armor!" + "\n";

		} else {
			if (DEBUG) {
				Log.d(TAG, "No more armor! " + name + " defends!");
			}
			fightLog += "No more armor! " + name + " defends!" + "\n";
		}

		return move;

	}

	public Move attack(Skill s) {
		Move move = new Move(this, s);

		if (energy < s.getCost()) {
			Log.d(TAG, "Not enough energy!");
			attackPwr = 0;
			defendPwr = 10;
		} else {
			energy = energy - s.getCost();
			attackPwr = s.getAtt();
			defendPwr = s.getDef();
		}

		if (DEBUG) {
			Log.d(TAG, "Attack! " + s.getName());
		}
        fightLog += "Attack! " + s.getName() + "\n";

		return move;

	}

	public Move attack(Weapon w) {
		Move move = new Move(this, w);

		if (!weaponReady) {
			Log.d(TAG, "Weapon not ready!");
	        fightLog += "Weapon not ready!" + "\n";
			attackPwr = 0;
			defendPwr = 10;
		} else {
			attackPwr = w.getAtt();
			defendPwr = w.getDef();
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
		    String skills = "";
			if (s.size() > 0) {
				System.out.print("Available skills: ");
				for (int i = 0; i < s.size() - 1; i++) {
				    skills += s.get(i).getName() + ", ";
				}
				skills += s.get(s.size() - 1).getName();
			} else {
				skills += "No available skills";
			}
			Log.d(TAG, skills);
			Log.d(TAG, "\n");
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
			Log.d(TAG, this.name + " loses " + loss + " armors!");
		}
        fightLog += this.name + " loses " + loss + " armors!" + "\n";
	}

	public String getName() {
		return name;
	}

	public int getEnergy() {
		return energy;
	}

	public void clearLog() {
	    fightLog = "";
	}
}
