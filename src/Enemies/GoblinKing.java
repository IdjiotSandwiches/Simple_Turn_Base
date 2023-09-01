package Enemies;

import Player.*;

public class GoblinKing extends Enemies {

	public GoblinKing() {
		super("Goblin King", 400, 15, 3, 0);
		// TODO Auto-generated constructor stub
	}

	private void basicAttack(Player player) {
		player.attacked(super.getAttackValue());
		System.out.println(super.getEnemiesClass() + " using Basic Attack!");
	}
	
	private void slamAttackSkill(Player player) {
		// Increase attackValue
		super.setAttackValue(getAttackValue() * 3);
		System.out.println(super.getEnemiesClass() + " using Slam Attack!");
				
		// Attacking
		player.attacked(getAttackValue());
				
		// Decrease manaValue
		super.setManaAfterSkill(super.getMana() - 10);
				
		// Decrease attackValue after using skill
		super.setAttackValue(getAttackValue() / 3);
	}
	
	public void goblinKingAttack(Player player) {
		
		if(super.getMana() == 10)
			slamAttackSkill(player);
		else
			basicAttack(player);
		
		super.setMana(1);
	}
	
	
	
}
