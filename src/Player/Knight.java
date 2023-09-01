package Player;

import java.util.Scanner;

import Enemies.*;

public class Knight extends Player {

	private String skillName = "Basic Attack | Slash (Mana: 5) | Heaven Judgement (Mana: 10)";

	public String getSkillName() {
		return skillName;
	}

	public Knight() {
		super("Knight", 100, 10, 1, 0);
		// TODO Auto-generated constructor stub
	}

	private void basicAttack(Enemies enemy) {
		enemy.attacked(super.getAttackValue());
		System.out.println(super.getPlayerClass() + " using Basic Attack!");
	}
	
	private void slashSkill(Enemies enemy) {
		
		// Increase attackValue
		super.setAttackValue(getAttackValue() * 2);
		System.out.println(super.getPlayerClass() + " using Slash Skill!");
		
		// Attacking
		enemy.attacked(getAttackValue());
		
		// Decrease manaValue
		super.setManaAfterSkill(super.getMana() - 5);
		
		// Decrease attackValue after using skill
		super.setAttackValue(getAttackValue() / 2);
	}
	
	private void heavenJudgementSkill(Enemies enemy) {
		// Increase attackValue
		super.setAttackValue(getAttackValue() * 3);
		System.out.println(super.getPlayerClass() + " using Heaven Judgement!");
		
		// Attacking
		enemy.attacked(getAttackValue());
		
		// Decrease manaValue
		super.setManaAfterSkill(super.getMana() - 10);
		
		// Decrease attackValue after using skill
		super.setAttackValue(getAttackValue() / 3);
	}
	
	public void knightAttack(Enemies enemy, Knight knight) {
		Scanner o = new Scanner(System.in); 
		int attackInput;
		
		boolean check = false;
		
		do {
			
			System.out.println("Skills: ");
			System.out.println("1. Basic Attack");
			System.out.println("2. Slash (Mana : 5)");
			System.out.println("3. Heaven Judgement (Mana : 10)");
			System.out.println("0. Skip Turn");
			System.out.print("Choose your action! "); 
			attackInput = o.nextInt();
			
			if(attackInput == 0 || attackInput == 1 || attackInput == 2 || attackInput == 3)
				check = true;
			else
				check = false;
				
			switch(attackInput) {
				case 1:
					basicAttack(enemy);
					break;
				case 2:
					if(super.getMana() < 5){
						System.out.println("Not enough mana!");
						check = false;
					}
					else{
						slashSkill(enemy);
						check = true;
					}
					break;
				case 3:
					if(super.getMana() < 10){
						System.out.println("Not enough mana!");
					check = false;
					}
					else{
						heavenJudgementSkill(enemy);
						check = true;
					}
					break;
				case 0:
					System.out.println("Skipping the turn!...");
					break;
				default:
					System.out.println("Enter a valid input!");
				
			}
			
			System.out.println();

		} while(check == false);

		// Add mana by 1 for every turn
		super.setMana(1);
	}
	
}
