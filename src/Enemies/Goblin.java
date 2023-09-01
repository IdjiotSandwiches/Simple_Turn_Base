package Enemies;

import Player.*;

public class Goblin extends Enemies{

	public Goblin() {
		super("Goblin", 150, 5, 1, 0);
		// TODO Auto-generated constructor stub
	}

	private void basicAttack(Player player) {
		player.attacked(super.getAttackValue());
		System.out.println(super.getEnemiesClass() + " using Basic Attack!");
	}
	
	private void stabSkill(Player player) {
		// Increase attackValue
		super.setAttackValue(getAttackValue() * 2);
		System.out.println(super.getEnemiesClass() + " using Stab Skill!");
				
		// Attacking
		player.attacked(getAttackValue());
				
		// Decrease manaValue
		super.setManaAfterSkill(super.getMana() - 5);
				
		// Decrease attackValue after using skill
		super.setAttackValue(getAttackValue() / 2);
	}
	
	public void goblinAttack(Player player) {
		
		if(super.getMana() >= 5)
			stabSkill(player);
		else
			basicAttack(player);
		
		super.setMana(1);
	}
	
}
