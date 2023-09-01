package Data;

import Enemies.*;
import Player.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		start();
		
	}
	
	static void start() {
		clearScreen();
		Scanner o = new Scanner(System.in);
		int startInput;
		
		do {
			System.out.println();
			System.out.println("Welcome to SimpleGame!");
			System.out.println("1. Play");
			System.out.println("0. Exit");
			System.out.print("Choose: ");
			startInput = o.nextInt();
			
			switch(startInput) {
				case 1:
					selectionMenu();
					break;
				case 0:
					System.out.println("Goodbye!");
					return;
				default:
					System.out.println("Enter a valid input!");
			
			}
			
		} while(startInput != 0 || startInput != 1);

		System.out.println();

	}

	static void selectionMenu() {
		clearScreen();
		Scanner o = new Scanner(System.in);
		int menuInput;
		do{
			System.out.println();
			System.out.println("Character Selection!");
			System.out.println("1. Knight");
			System.out.println("2. Archer");
			System.out.println("0. Back");
			System.out.print("Select your character: ");
			menuInput = o.nextInt();

			switch(menuInput){
				case 1:
					Player knight = new Knight();
					levelOne(knight);
					break;
				case 2:
					Player archer = new Archer();
					levelOne(archer);
					break;
				case 0:
					return;
				default:
					System.out.println("Enter a valid input!");
				
			}

		} while(menuInput != 0 && menuInput != 1 && menuInput != 2);

		System.out.println();
	}
	
	static void playerDescription(Player player){
		System.out.println();
		System.out.println("Character Details");
		if(player instanceof Knight){
			Knight knight = (Knight) player;
			System.out.println("Class: " + knight.getPlayerClass());
			System.out.println("Health: " + knight.getHealth() + " | Attack: " + knight.getAttackValue() + " | Level: " + knight.getLevel());
			System.out.println(knight.getSkillName());
		}

		if(player instanceof Archer){
			Archer archer = (Archer) player;
			System.out.println("Class: " + archer.getPlayerClass());
			System.out.println("Health: " + archer.getHealth() + " | Attack: " + archer.getAttackValue() + " | Level: " + archer.getLevel());
			System.out.println(archer.getSkillName());
		}
		
		System.out.println();
		System.out.print("Press ENTER to continue...");
		Scanner o = new Scanner(System.in);
		o.nextLine();
		System.out.println();
	}

	static boolean turnStart(Enemies enemy, Player player) {
		int turn = 0;
		
		enemy.setMana(0);
		player.setMana(0);

		while(enemy.getHealth() != 0 & player.getHealth() != 0) {
			turn++;
			
			System.out.println("Turn " + turn);
			System.out.println("------------");

			System.out.println(player.getPlayerClass() + " Status: ");
			System.out.println("Health: " + player.getHealth() + " || Mana: " + player.getMana());
			System.out.println();
			System.out.println(enemy.getEnemiesClass() + " Status: ");
			System.out.println("Health: " + enemy.getHealth() + " || Mana: " + enemy.getMana());
			System.out.println();

			// Player Attack
			if(turn % 2 != 0 && (enemy.getHealth() != 0 || player.getHealth() != 0)) {
				System.out.println(player.getPlayerClass() + " Turn!");
				
				playerTurn(enemy, player);
			}
			
			// Enemy Attack
			else if(turn % 2 == 0 && (enemy.getHealth() != 0 || player.getHealth() != 0)) {
				System.out.println(enemy.getEnemiesClass() + " Turn!");
				
				enemyTurn(enemy, player);
			}

			System.out.println();
			
		}
		
		if(enemy.getHealth() == 0) {
			System.out.println(player.getPlayerClass() + " has won!");
			System.out.println("Next level...");
			
			return true;
		}
		else {
			System.out.println(player.getPlayerClass() + " has lost!");
			System.out.println("Returning to Start Screen!...");
			
			return false;
		}
		
	}
	
	static void playerTurn(Enemies enemy, Player player) {
				
		if(player instanceof Knight) {
			Knight knight = (Knight) player;
			knight.knightAttack(enemy, knight);

		}
		if(player instanceof Archer) {
			Archer archer = (Archer) player;
			archer.archerAttack(enemy, archer);
		}
		
	}
	
	static void enemyTurn(Enemies enemy, Player player) {
		if(enemy instanceof Goblin) {
			Goblin goblin = (Goblin) enemy;
			goblin.goblinAttack(player);
		}
		if(enemy instanceof GoblinKing) {
			GoblinKing goblinKing = (GoblinKing) enemy;
			goblinKing.goblinKingAttack(player);
		}
		if(enemy instanceof Slime) {
			Slime slime = (Slime) enemy;
			slime.slimeAttack(player);
		}
	}

	static void levelOne(Player player){
		clearScreen();
		Scanner o = new Scanner(System.in);
		Enemies goblin = new Goblin();
		
		playerDescription(player);

		System.out.println("Level 1");
		System.out.println("==========");

		if(turnStart(goblin, player) == true) {
			System.out.println("Level Up!");
			System.out.println("Level:" + player.getLevel() + "+1");
			System.out.println("Health: " + player.getDefaultHealth() + "+50");
			System.out.println("Attack: " + player.getAttackValue() + "+10");

			player.setDefaultHealth(50);
			player.setAttackValue(player.getAttackValue() + 10);
			player.setLevel(player.getLevel() + 1);

			player.setManaAfterSkill(0);

			System.out.println();
			System.out.print("Press ENTER to next level!...");
			o.nextLine();

			levelTwo(player);
		}
		else
			return;
		
	}

	static void levelTwo(Player player) {
		clearScreen();
		Scanner o = new Scanner(System.in);
		Enemies slime = new Slime();
		
		playerDescription(player);

		System.out.println("Level 2");
		System.out.println("==========");
		
		if(turnStart(slime, player) == true) {
			System.out.println("Level Up!");
			System.out.println("Level:" + player.getLevel() + "+1");
			System.out.println("Health: " + player.getDefaultHealth() + "+50");
			System.out.println("Attack: " + player.getAttackValue() + "+10");

			player.setDefaultHealth(50);
			player.setAttackValue(player.getAttackValue() + 10);
			player.setLevel(player.getLevel() + 1);

			player.setManaAfterSkill(0);

			System.out.println();
			System.out.print("Press ENTER to next level!...");
			o.nextLine();

			levelThree(player);
		}
		else
			return;

	}

	static void levelThree(Player player) {
		clearScreen();
		Scanner o = new Scanner(System.in);
		Enemies goblinKing = new GoblinKing();
		
		playerDescription(player);

		System.out.println("Final Boss");
		System.out.println("==========");
		
		if(turnStart(goblinKing, player) == true) {
			System.out.println("You have Won the Game!");
			System.out.println("Congrats!");
			System.out.println("Thanks for playing!");
			System.out.println("Press ENTER to return to Start Screen!...");
			o.nextLine();
			clearScreen();
		}
		else
			return;

	}

	static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}  
}
