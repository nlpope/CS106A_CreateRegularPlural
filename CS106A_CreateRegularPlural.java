/**
 * File: CS106A_CreateRegularPlural.java
 * -------------------------------
 * The CS106A_CreateRegularPlural class returns the 
 * plural of a word using standard English rules.
 * 
 */

import acm.program.*;
import java.util.*;

public class CS106A_CreateRegularPlural extends ConsoleProgram
{
	private static final String SENTINEL = "ENDPROGRAM";
	private static final Character[] lastLetterCases = {'s','x','z'};
	private static final String[] lastTwoLettersCases = {"ch","sh"};
	private static final Character[] yPrecendentCases = {'a','e','i','o','u'};
	
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
			if(clientInput.equals(SENTINEL)){ println("goodbye."); return; }
			if (checkClientInputValidityFor(clientInput)){ 
				println(createRegularPlural(clientInput));
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
		if (word.length() == 0) { return false; } 
		for (int i = 0; i < word.length(); i++){
			boolean firstCase = word.charAt(i) < 65 || word.charAt(i) > 90;
			boolean secondCase = word.charAt(i) < 97 || word.charAt(i) > 122;
			if (firstCase && secondCase){ return false; }
		}
		return true;
	}
	
	
	private String createRegularPlural(String word)
	{
		String lastTwoLetters = word.substring(word.length()-2).toLowerCase();
		Character lastLetter = Character.toLowerCase(word.charAt(word.length()-1));
		Character secondToLastLetter = Character.toLowerCase(word.charAt(word.length()-2));
		
		for (Character instance : lastLetterCases){
			if (lastLetter.equals(instance)){
				return word + "es";
			}
		}
		
		for (String instance : lastTwoLettersCases){
			if (lastTwoLetters.equals(instance)){
				return word + "es";
			}
		}
		
		for (Character instance : yPrecendentCases){
			if (lastLetter.equals('y') && secondToLastLetter.equals(instance)){
				return word.substring(0, word.length()-2) + "ies";
			}
		}
		
		return word + "s";
	}
}