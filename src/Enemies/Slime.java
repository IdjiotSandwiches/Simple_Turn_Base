package Enemies;

import Player.*;

public class Slime extends Enemies{

	public Slime() {
		super("Slime", 300, 10, 2, 0);
		// TODO Auto-generated constructor stub
	}

	private void basicAttack(Player player) {
		player.attacked(super.getAttackValue());
		System.out.println(super.getEnemiesClass() + " using Basic Attack!");
	}
	
	private void bubbleSkill(Player player) {
		// Increase attackValue
		super.setAttackValue(getAttackValue() * 2);
		System.out.println(super.getEnemiesClass() + " using Bubble Skill!");
				
		// Attacking
		player.attacked(getAttackValue());
				
		// Decrease manaValue
		super.setManaAfterSkill(super.getMana() - 5);
				
		// Decrease attackValue after using skill
		super.setAttackValue(getAttackValue() / 2);
	}
	
	public void slimeAttack(Player player) {
		
		if(super.getMana() >= 5)
			bubbleSkill(player);
		else
			basicAttack(player);
		
		super.setMana(1);
	}
	
	
}
