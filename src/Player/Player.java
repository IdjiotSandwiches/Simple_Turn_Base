package Player;

public abstract class Player {
	private int defaultHealth;
	private String playerClass;
	private int health;
	private int attackValue;
	private int level;
	private int mana;
	
	public Player(String playerClass, int health, int attackValue, int level, int mana) {
		super();
		this.defaultHealth = health;
		this.playerClass = playerClass;
		this.health = health;
		this.attackValue = attackValue;
		this.level = level;
		this.mana = mana;
	}

	public String getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackValue() {
		return attackValue;
	}

	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		if(this.mana >= 10)
			this.mana = 10;
		else
			this.mana += mana;
	}
	
	public void setManaAfterSkill(int mana) {
		this.mana = mana;
	}
	
	public void attacked(int attackedValue) {
		if(this.health < 0)
			this.health = 0;
		else if(this.health < attackedValue)
			this.health = 0;
		else
			this.health -= attackedValue;
		
		System.out.println(this.playerClass + " got attacked! " + this.playerClass + " Health = " + health);
	}
	
	public int getDefaultHealth() {
		return defaultHealth;
	}

	public void setDefaultHealth(int levelUpHealth) {
		this.defaultHealth += levelUpHealth;
		this.health = this.defaultHealth;
	}
	
}
