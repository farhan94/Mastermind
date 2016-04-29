
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		char codeA, codeB, codeC, codeD;
		List<String> rules = new ArrayList<String>();
		rules.add("Welcome to Mastermind.  Here are the rules.");
		rules.add("");
		rules.add("This is a text version of the classic board game Mastermind.");
		rules.add("The computer will think of a secret code. The code consists of 4 colored pegs.");
		rules.add("The pegs may be one of six colors: blue, green, orange, purple, red, or yellow. A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in.   After you make a valid guess the result (feedback) will be displayed.");
		rules.add("The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.  For each peg in the guess that is the correct color, but is out of position, you get a white peg.  For each peg, which is fully incorrect, you get no feedback.");
		rules.add("");
		rules.add("Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.");
		rules.add("When entering guesses you only need to enter the first character of each color as a capital letter.");
		rules.add("");
		rules.add("You have 12 guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N): ");
		String colors = "BGOPRY";
		//Random r = new Random();
		Iterator<String> n = rules.iterator();
		while (n.hasNext()){
			String inst = n.next();
			System.out.println(inst);
		}
		while (true){
			Game masterMind = new Game();
			if(!masterMind.runGame()){
				System.out.println("Goodbye!");
				break;
			}
			System.out.println("Do you want to play again? (Y/N)");
			Scanner input = new Scanner(System.in);
			String userInput = input.next();
			while(!userInput.equals("Y") && !userInput.equals("N")){
				System.out.println("Invalid input, try again.");
				userInput = input.next();
			}
			if (userInput.equals("N")){
				System.out.println("Goodbye!");
				break;
			}
			//int numGuess = 12;
			//Scanner input = new Scanner(System.in);
			//String userInput = input.next();
		/*	System.out.println("Generating secret code....");
			codeA = colors.charAt(r.nextInt(colors.length()));
			codeB = colors.charAt(r.nextInt(colors.length()));
			codeC = colors.charAt(r.nextInt(colors.length()));
			codeD = colors.charAt(r.nextInt(colors.length()));
			System.out.println(codeA +""+ codeB+"" + codeC+"" + codeD);
			while(numGuess != 0){
				int black = 0;
				int white = 0;
				System.out.println("You have "+numGuess+" guesses left.");
				System.out.println("What is your next guess?");
				System.out.println("Type in the characters for your guess and press enter.");
				userInput = input.next();
				StringBuilder inp = new StringBuilder(userInput);
				
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
				
				System.out.println("You got " +black+ " black pegs and " + white + " white pegs.");
				numGuess--;
				
			}*/
			
			
		}
	
	
	
	}

}
