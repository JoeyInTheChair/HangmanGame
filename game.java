package project;
import java.util.*; //import scanner and random library
public class game {
	public static Random rand = new Random(); //open random function 
	//create method to give user a hint
	public static void giveHint (String word, String guess) {
		//create empty LinkedList to store in all possible letter from word
		LinkedList <String> hint = new LinkedList <String>();
		for(int i = 0; i < word.length()-1; i++) {
			hint.add(word.substring(i, i+1));
		} for(int j = 0; j < guess.length(); j++) {
			//using for loop, remove letters in list that has already been guessed so it doesnt give back answer already used
			if(guess.charAt(j) != '*') hint.remove(guess.substring(j, j+1));
		} System.out.println("YOURE HINT IS: " + hint.get(rand.nextInt(hint.size()))); //print out hint
		System.out.println("WORD: " + guess);
	} //create hangman board
    public static void printBoard (int lives) {
		//using switch cases print appropriate board depending on int count
		//and print out how many lives are left
		switch(lives) {
		case 8:
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println("LIVES REMAIN: " + lives);
			break;
		
		case 7:
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
			System.out.println("LIVES REMAIN: " + lives);
			break;
		
		case 6:
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
			System.out.println("LIVES REMAIN: " + lives);
			break;
		
		case 5:
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
			System.out.println("LIVES REMAIN: " + lives);
			break;

		case 4:
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
			System.out.println("LIVES REMAIN: " + lives);
			break;

		case 3:
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          /  ");
			System.out.println("___|___      /   ");
			System.out.println("LIVES REMAIN: " + lives);
			break;

		case 2:
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("LIVES REMAIN: " + lives);
			break;

		case 1:
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|");
			System.out.println("   |         / |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("LIVES REMAIN: " + lives);
			break;

		case 0:
				System.out.println("   ____________");
				System.out.println("   |          _|_");
				System.out.println("   |         /   \\");
				System.out.println("   |        |     |");
				System.out.println("   |         \\_ _/");
				System.out.println("   |          _|_");
				System.out.println("   |         / | \\");
				System.out.println("   |          / \\ ");
				System.out.println("___|___      /   \\");
				System.out.println("LIVES REMAIN: " + lives);
				break;
		}
    } //create String method to reveal to user which letter they input is shown in the String
    public static String reveal (String word, String guess, char letter) {
		//use for loop to go through word (without asterisks)
		for(int i = 0; i < word.length(); i++) {
			//use if statement to check if letter is in the word
			if(word.charAt(i) == letter) {
                guess = guess.substring(0,i) + letter + guess.substring(i+1); //remove '*' at position i and input letter correctly guessed
            }
        } return guess; //update guess String in main method
    } //create boolean method to check if user's guess is correct or not
    public static boolean checkValid (String word, char letter) {
        boolean valid = false; //set boolean variable to false
		//use for loop to go through word
		for(int i = 0; i < word.length(); i++) {
			//use if statement to check if letter guessed is in the word
			if(word.charAt(i) == letter) {
                valid = true; //update boolean variable to true if letter is in word
                break;
            }
        } return valid; //return boolean
    } //create method to turn random word into asterisks to show user what they're guessing
    public static String retrieveGuess (String word) {
        String ast = ""; //create empty string variable for input
		//use for loop to go through entire word
		for(int i = 0; i < word.length()-1; i++) {
			//add appropriate text to empty string
			if(word.charAt(i) == '-') ast += "-";
            else if(word.charAt(i) == '.') ast += ".";
            else if(word.charAt(i) == '/') ast += "/";
            else ast += "*";
        } return ast; //return guessing String
	} //retrieving random word from dictionary array method
	public static String getWord (String [] contents) {
		String temp = contents[rand.nextInt(contents.length)];; //create string variable and place random letter chosen in it
		temp = temp.toLowerCase(); //convert all to lower case to avoid case sensitivity when comparing letters being guessed
		return temp; //return word
	}
    public static void main (String []args) throws Exception { 
		Scanner scan = new Scanner (System.in); //activate scanner for user input
        FileIO reader = new FileIO(); //load dictionary 
		String [] contents = reader.load("C:\\Users\\josep\\Desktop\\Hangman\\project\\Dictionary.txt"); //transfer dictionaty to an array
		String word = getWord(contents); //create method to retrieve random word from dictionary array
		String guess = retrieveGuess(word); //using retrieveGuess method convert random word into asterisks to allow user to guess word
		int lives = 8; //create life point to let user know how many guesses they have left
		LinkedList <String> used = new LinkedList <String>(); //create empty String to input used guesses so user doesnt repeat letter twice
		//create while loop so user is able to input as many guesses they want till their life point reaches 0
		System.out.println("GUESS THE WORD: " + guess); //print out guess word
		while(lives > 0) { 
			String inp = "";
			System.out.println("INPUT LETTER OR WORD: "); 
			//create a do loop to ensure user doesnt repeat same letter or word twice
			do { 
				inp = scan.nextLine(); //scan letter input by user
				inp = inp.toLowerCase(); //set guesses to lowercase to avoid case sensitivity
				if(used.contains(inp)) System.out.println("YOU ALREADY USED " + inp + "\nTRY AGAIN");
			} while(used.contains(inp));
			used.add(inp); //save guess in "used" LinkedList
			//check if user inputted word or char
			if(inp.length() > 1) {
				//check if the guessed word and word given are equal
				if(inp.equalsIgnoreCase(word.substring(0,word.length()-1))) {
					guess = inp; //change guess variable to right answer
					break; //break loop if answer is correct
				} //print appropriate text if guess was invalid
				else {
					System.out.println(inp + " IS INVALID");
					System.out.println("TRY AGAIN");
					lives--; //deduct life point
					printBoard(lives); //print hangman board
					System.out.println("WORD: " + guess);
				}
			}
			else {
				char letter = inp.charAt(0);
				//create boolean method to check if input by user is correct
				if(checkValid(word, letter) == true) {
					guess = reveal(word, guess, letter); //reveal the position where the char input is
					System.out.println(letter + " IS VALID"); 
					System.out.println("LIVES REMAIN: " + lives);
					System.out.println("WORD: " + guess);
            	} //print valid message to inform user if they were correct or incorrect
            	else { 
            		System.out.println(letter + " IS INVALID");
                	System.out.println("TRY AGAIN");
                	lives--; //deduct life point by 1 if input is incorrect 
					printBoard(lives); //print hangman
					System.out.println("WORD: " + guess); 
				}
			} if(used.size()%3 == 0) { //every 3rd input offer user a hint
				//but must sacrifice a life
				System.out.print("GIVE UP A LIFE FOR A HINT \nTYPE yes FOR A HINT OR no\n");
				if(scan.nextLine().equalsIgnoreCase("yes")) {
					lives--; //deduct life point
					printBoard(lives);
					giveHint(word, guess); //then give hint
				}
			} System.out.println("LETTERS USED: " + used); //show user what letters have been used 
			if(guess.equalsIgnoreCase(word.substring(0,word.length()-1))) break; //break loop if user already guessed all the letters correctly
        } scan.close(); //close scanner when loop is broken
		//print appropriate text depending on life point
		if(lives == 0) System.out.println("GAME OVER!!! \nTHE WORD IS " + word);
        else System.out.println("CONGRATULATIONS!!! \nYOU WIN!!! \nTHE WORD IS " + guess);
    }
}