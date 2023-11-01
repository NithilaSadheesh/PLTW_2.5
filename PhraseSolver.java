/**
* Activity 2.5 - PhraseSolver Class
* @author      Nithila Sadheesh
* @author      Sanjitha Saravanan
* @author      Paige Nothelfer
* @version     1.0
* @date        2023-10-30
* The PhraseSolver class puts the elements of the program together by creating instances of the two players and the board in the constructor and running play method. 
 */
import java.util.Scanner;

public class PhraseSolver
{
  // Itializes the private variables
  private Player player1; 
  private Player player2; 
  private Board game; 
  private boolean solved;

  /** Constructor for the PhraseSolver class. It initializes the players and the board.
  * @param none
  * @return none
  * @throws none
  * Precondition: two player objects and a board object must be initialized (as null values) along with a boolean variable for whether or not the progrmam is solved
  * Postcondition: two player objects are assigned values by calling the Player constructor and the board object is assigned a phrase by calling the Board constructor
  
  */ 
  public void PhraseSolver() {
    // First player constructor is called because no parameter is passed in
    player1 = new Player(); 
    player2 = new Player(); 
    game = new Board(); 
    solved = false; 
  }
  
  /* your code here - accessor(s) */

  /* your code here - mutator(s)  */

  /** Play():  Method to play the game until word guessed, repeatedly gets user input until game ends and uses a boolean variable to check when this happens
  * @param none
  * @return none
  * @throws none
  * Precondition - PhraseSolver object must be initialized and solved boolean variable must be initialized
  * Postcondition - boolean solved is set to true and game terminates because the phrase has been guessed
  */

  public void play()
  {
    boolean solved = false;
    // Change player after every guess is made
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);

    boolean correct = true;
    // Play game until a player guesses the word correct
    while (!solved) 
    {

      /* your code here - game logic */


      /* your code here - determine how game ends */
      solved = true; 
    } 

  }

}