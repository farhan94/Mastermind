
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	List<String> rules;
	char codeA, codeB, codeC, codeD;
	int numGuess;
	String colors;
	List<String> history;
	public Game(){
		numGuess = 12;
		colors = "BGOPRY";
		history = new ArrayList<String>();
	}
	
	public boolean runGame(){
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		while(!userInput.equals("Y") && !userInput.equals("N")){
			System.out.println("Invalid input, try again.");
			userInput = input.next();
		}
		System.out.println("");
		if (userInput.equals("Y")){
		System.out.println("Generating secret code....");
		generateCode();
		while(numGuess != 0){
			System.out.println("");
			System.out.println("You have "+numGuess+" guesses left.");
			System.out.println("What is your next guess?");
			System.out.println("Type in the characters for your guess and press enter.");
			userInput = input.next();
			if(userInput.equals("history")){
				this.displayHistory();
				continue;
			}
			while(!inputCheck(userInput)){
				System.out.println("");
				System.out.println("Invalid input, try again.");
				userInput = input.next();
			}
			StringBuilder inp = new StringBuilder(userInput);
			int[] pegs = codeCheck(inp);
			history.add("Guess: " +userInput+ "   Pegs: " + pegs[0] + " black pegs   " + pegs[1] + " white pegs");
			System.out.println("");
			System.out.println("You got " +pegs[0]+ " black pegs and " + pegs[1] + " white pegs.");
			if (pegs[0] == 4){
				System.out.println("");
				System.out.println("Congratulations you win! The code was " +codeA+""+codeB+""+codeC+""+codeD+"!");
				return true;
			}
			numGuess--;
		}
			System.out.println("");
			System.out.println("Game over! You lose!");
			return true;
		}
		else if (userInput.equals("N")){
			System.out.println("Game over.");
			return false;
		}
		return true;
	}
	
	private void displayHistory() {
		System.out.println("");
		System.out.println("**************************************************************");
		if (history.size() == 0) {
			System.out.println("No previous guesses or results! Make a guess to use the 'history' functionality.");
			return;
		}
		Iterator<String> his = history.iterator();
		while(his.hasNext())
			System.out.println(his.next());
		System.out.println("**************************************************************");
		System.out.println("");
	}

	void generateCode(){
		Random r = new Random();
		codeA = colors.charAt(r.nextInt(colors.length()));
		codeB = colors.charAt(r.nextInt(colors.length()));
		codeC = colors.charAt(r.nextInt(colors.length()));
		codeD = colors.charAt(r.nextInt(colors.length()));
	}
	boolean inputCheck(String inp){
		if (inp.length() != 4){
			return false;
		}
		if(colors.indexOf(inp.charAt(0)) == -1){
			return false;
		}
		if(colors.indexOf(inp.charAt(1)) == -1){
			return false;
		}
		if(colors.indexOf(inp.charAt(2)) == -1){
			return false;
		}
		if(colors.indexOf(inp.charAt(3)) == -1){
			return false;
		}
		return true;
	}
	int[] codeCheck(StringBuilder inp){
		int black = 0;
		int white = 0;
		if (inp.charAt(0) == codeA){
			black++;
			inp.setCharAt(0, 'x');
		}
		if (inp.charAt(1) == codeB){
			black++;
			inp.setCharAt(1, 'x');
		}
		if (inp.charAt(2) == codeC){
			black++;
			inp.setCharAt(2, 'x');
		}
		if (inp.charAt(3) == codeD){
			black++;
			inp.setCharAt(3, 'x');
		}
		int loc1 = inp.indexOf(Character.toString(codeA));
		if(inp.charAt(0) != 'x' && loc1 != -1){
			white++;
			inp.setCharAt(loc1, 'w');
		}
		int loc2 = inp.indexOf(Character.toString(codeB));
		if(inp.charAt(1) != 'x' && loc2 != -1){
			white++;
			inp.setCharAt(loc2, 'w');
		}
		int loc3 = inp.indexOf(Character.toString(codeC));
		if(inp.charAt(2) != 'x' && loc3 != -1){
			white++;
			inp.setCharAt(loc3, 'w');
		}
		int loc4 = inp.indexOf(Character.toString(codeD));
		if(inp.charAt(3) != 'x' && loc4 != -1){
			white++;
			inp.setCharAt(loc4, 'w');
		}
		int[] peg = {black,white};
		return peg;
		
	}
}
