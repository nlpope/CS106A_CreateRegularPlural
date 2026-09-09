/**
 * File: CS106A_CreateRegularPlural.java
 * -------------------------------
 * The CS106A_CreateRegularPlural class returns the 
 * plural of a word using standard English rules.
 * 
 */

import acm.program.*;

enum Plurality { 
	s,x,z,
}

public class CS106A_CreateRegularPlural extends ConsoleProgram
{
	private static final String SENTINEL = "ENDPROGRAM";
	
	public void run()
	{
		introduceApp();
		askClientForInput();
	}
	
	
	private void introduceApp()
	{
		println("The CS106A_IsPalindromeSentence class detects " +
				"whether or not a sentence is a palindrome.");
		pause(1000);
		println("Play indefinitely or type '" + SENTINEL + "' to end the program.");
	}
	
	
	private void askClientForInput()
	{
		while(true){
			String clientInput = readLine("Enter a word: ");
			if(clientInput.equals(SENTINEL)){
				println("goodbye.");
				return;
			}
			if (checkClientInputValidityFor(clientInput)){ 
				createRegularPlural(clientInput);
			}
			else { 
				println("Invalid input. Please try again. One word only. No numbers. " +
						"No spaces.");
				askClientForInput();
			}
		}
	}
	
	
	private boolean checkClientInputValidityFor(String word)
	{
		for (int i = 0; i < word.length(); i++){
			boolean firstCase = word.charAt(i) < 65 || word.charAt(i) > 90;
			boolean secondCase = word.charAt(i) < 97 || word.charAt(i) > 122;
			if (firstCase && secondCase){ return false; }
		}
		return true;
	}
	
	
	private String createRegularPlural(String word)
	{
		String pluralStr = "";
		Character ending = word.toLowerCase().charAt(word.length() - 1);
		Character precedingLetter = word.toLowerCase().charAt(word.length() - 2);
		boolean endCase1 = precedingLetter.equals('s');
		boolean endCase2 = precedingLetter.equals('c');
		if(ending.equals('h') && ( endCase1 || endCase2) ){
			
		}
		return "";
	}
}