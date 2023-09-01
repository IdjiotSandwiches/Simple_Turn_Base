package Player;

import java.util.Scanner;

import Enemies.Enemies;

public class Archer extends Player {

	private String skillName = "Basic Attack | Arrow Rain (Mana: 3) | Holy Arrow (Mana: 10)";

	public String getSkillName() {
		return skillName;
	}

	public Archer() {
		super("Archer", 80, 15, 1, 0);
		// TODO Auto-generated constructor stub
	}

	private void basicAttack(Enemies enemy) {
		enemy.attacked(super.getAttackValue());
		System.out.println(super.getPlayerClass() + " using Basic Attack!");
	}
	
	private void arrowRainSkill(Enemies enemy) {
		
		// Increase attackValue
		super.setAttackValue(getAttackValue() * 3);
		System.out.println(super.getPlayerClass() + " using Slash Skill!");
		
		// Attacking
		enemy.attacked(getAttackValue());
		
		// Decrease manaValue
		super.setManaAfterSkill(super.getMana() - 3);
		
		// Decrease attackValue after using skill
		super.setAttackValue(getAttackValue() / 3);
	}
	
	private void holyArrowSkill(Enemies enemy) {
		// Increase attackValue
		super.setAttackValue(getAttackValue() * 5);
		System.out.println(super.getPlayerClass() + " using Heaven Judgement!");
		
		// Attacking
		enemy.attacked(getAttackValue());
		
		// Decrease manaValue
		super.setManaAfterSkill(super.getMana() - 10);
		
		// Decrease attackValue after using skill
		super.setAttackValue(getAttackValue() / 5);
	}
	
	public void archerAttack(Enemies enemy, Archer archer) {
		Scanner o = new Scanner(System.in); 
		int attackInput;
		
		boolean check = false;
		
		do {
			
			System.out.println("Skills: ");
			System.out.println("1. Basic Attack");
			System.out.println("2. Arrow Rain (Mana : 3)");
			System.out.println("3. Holy Arrow (Mana : 10)");
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
					if(super.getMana() < 3){
						System.out.println("Not enough mana!");
						check = false;
					}
					else{
						arrowRainSkill(enemy);
						check = true;
					}
					break;
				case 3:
					if(super.getMana() < 10){
						System.out.println("Not enough mana!");
					check = false;
					}
					else{
						holyArrowSkill(enemy);
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
