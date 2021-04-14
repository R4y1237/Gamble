/**
/**
 * @author Ray, Zach, Harry, Mehrad
 *
 */

import java.util.*;

public class Gamble {
	
	private int [] gamble;
	private int [] finalGamble;
	private double money;
	private double amountLoaned;
	private static Scanner in;
	private static int choice;
	
	public Gamble(){
		gamble = new int[7];
		finalGamble = new int[7];
		money = 200;
		amountLoaned = 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		in = new Scanner(System.in);
		System.out.println("Welcome to the Safe fair gambling program");
		Gamble p1 = new Gamble();
		p1.mainMenu();
		while(choice !=3) {
			p1.getGamble();
			p1.setFinalGamble();
			if(p1.win()) {
				System.out.println("YOU HAVE WON THE GRAND PRIZE OF $1,000,000 !!!");
			}
			else if(!p1.win()) {
				System.out.println("You did not win");
			}
			p1.mainMenu();
		}
		
	}
	
	public void mainMenu() {
		System.out.println("Press 1 to Commit Gamble\nPress 2 to load money\nPress 3 to exit");
		System.out.println("You currently have: $"+money);
		choice = in.nextInt();
		if(choice != 1 && choice !=2&& choice !=3) {
			this.mainMenu();
		}
	}
	
	public void getGamble() {
		money -= 5;
		for(int i = 1; i<=7; i++) {
			System.out.println("Enter your number "+ i +": ");
			gamble[i-1] = in.nextInt();
		}
	}
	
	public void setFinalGamble() {
		System.out.println("drawing final numbers");
		for(int i = 0; i<7; i++) {
			finalGamble[i] = (int)(Math.random()*99 +1);
		}
	}
	
	public boolean win() {
		for(int i = 0; i<7;i++) {
			if(gamble[i] != finalGamble[i]) 
				return false;
		}
		
		return true;
	}
	
	public void loanMoney() {
		System.out.println("Enter amount of money you want loaned: ");
		double input = in.nextDouble();
		amountLoaned += input;
		money += input;
	}
	
		

}
