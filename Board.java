/*
*
 */
import java.util.Scanner;
import java.io.File;

/** 
Board class: creates a board with the secret phrase and what the player has solved so far
Contains the current value of the letter that the player has guessed 
Checks to see if the user's guess is valid and found within secret phrase 

@author: Paige Nothelfer, Nithila Sadheesh, Sanjitha Saravanan
@version: 1
@date: 11/5/23

*/
public class Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /** 
  Constructor 
  @param none
  @return void
  @throws none
  Initializes solvedPhrase, phrase, and currentLetterValue
  Pre-condition: loadPhrase() and setLetterValue() are properly declared and written, 
    instance variables are properly declared 
  Post-condition: solvedPhrase, phrase, and currentLetterValue are initialized and 
    solvedPhrase and setLetterValue have fassigned values 
  */ 
  public Board() {
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue(); 
    //Testing
    //System.out.println("Phrase: " + phrase); 
  }

  /** 
  Accessor 
  @param none
  @return String 
  @throws none
  Returns the value of phrase to method call 
  Pre-condition: method call is assigned to variable or printed, phrase is properly declared 
  Post-condition: phrase is returned to method call 
  */
  public String getPhrase() {
    return phrase; 
  }
  
  /* your code here - accessor(s) */
  /** 
  Accessor 
  @param none
  @return String 
  @throws none
  Returns the value of solvedPhrase to method call 
  Pre-condition: method call is assigned to variable or printed, solvedPhrase is properly 
    initialized and declared 
  Post-condition: solvedPhrase is returned to method call 
  */
  public String getSolvedPhrase() {
    return solvedPhrase; 
  }

  /** 
  Accessor 
  @param none
  @return int 
  @throws none
  Returns the value of currentLetterValue to method call 
  Pre-condition: method call is assigned to variable or printed, currentLetterValue is 
    properly initialized and declared 
  Post-condition: currentLetterValue is returned to method call 
  */
  public int getCurrentLetterValue() {
    return currentLetterValue; 
  }

  
  /* your code here - mutator(s)  */

  /* ---------- provided code, do not modify ---------- */
  /** 
  setLetterValue() 
  @param none
  @return void 
  @throws none
  Sets currentLetterValue to a random number from 1-100 
  Pre-condition: currentLetterValue is properly declared 
  Post-condition: currentLetterValue is set to a random value each time method is called 
  */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  /** 
  isSolved() 
  @param String
  @return boolean 
  @throws none
  Checks if the phrase is the same as the guess passed to the method 
  Pre-condition: method call is assigned to variable or printed, phrase and guess are 
    properly declared and intialized
  Post-condition: true or false is returned to the method call  
  */
  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  /** 
  loadPhrase() 
  @param none
  @return String 
  @throws 
  Returns a random phrase to the method call  
  Pre-condition: method call is assigned to variable or printed, solvedPhrase is properly 
    declared, phrase.txt exists
  Post-condition: a random String from the text file is returned to method call  
  */
  private String loadPhrase()
  {
    String tempPhrase = "";

    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    int randomInt = (int) ((Math.random() * numOfLines) + 1);

    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  

    return tempPhrase;
  }  

  /** 
  guessLetter() 
  @param String
  @return boolean 
  Checks if the user's letter is found within the secret phrase   
  Pre-condition: method call is assigned to variable or printed, solvedPhrase and phrase are properly declared 
  Post-condition: true or false is returned to the method call, solvedPhrase is set to a new
    phrase that contains the guessed letters 
  */
  public boolean guessLetter(String guess)
  {
    boolean foundLetter = false; //Creates boolean for if the letter is found
    String newSolvedPhrase = ""; //Initiates String for the solved phrase 

    for (int i = 0; i < phrase.length(); i++) //For loop that goes through each letter of the phrase 
    {
      if (phrase.substring(i, i + 1).equals(guess)) //checks if the letter equals the guess 
      {
        // TESTING
        if (newSolvedPhrase.indexOf(guess) != -1) {
          newSolvedPhrase += guess + " "; //if guessed correctly, adds guess to the solved phrase
          foundLetter = true; //sets boolean to true 
        }
      }
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " "; //Added in spaces where appropriate 
      }
    }
    solvedPhrase = newSolvedPhrase; //sets variable solvedPhrase to the new solved phrase
    return foundLetter; //returns the letter that is found 
  } 

  /** 
  guessPhrase() 
  @param String
  @return boolean 
  Checks if the user's guess matches the secret phrase    
  Pre-condition: method call is assigned to variable or printed, solvedPhrase and phrase are properly declared 
  Post-condition: true or false is returned to the method call, solvedPhrase is set to a new phrase that contains the secret phrase 
  */
  public boolean guessPhrase(String guess)
  {
    boolean solvedPuzzle = false; //Creates boolean for if the guess is correct
    String newSolvedPhrase = ""; //Initiates String for the solved phrase 

    if(guess.equals(phrase)) {
      solvedPuzzle = true; 
      for(int i = 0; i < guess.length(); i++) {
        newSolvedPhrase += phrase.substring(i, i+1) + " ";
      }
    } else {
      newSolvedPhrase = solvedPhrase;
    }
    solvedPhrase = newSolvedPhrase; //sets variable solvedPhrase to the new solved phrase
    return solvedPuzzle; //returns the puzzle is solved or not 
  } 
} 