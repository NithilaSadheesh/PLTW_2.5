
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

public class PhraseSolver {
  // Itializes the private variables
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;

  /**
   * Constructor for the PhraseSolver class. It initializes the players and the
   * board.
   * 
   * @param none
   * @return none
   * @throws none
   *              Precondition: two player objects and a board object must be
   *              initialized (as null values) along with a boolean variable for
   *              whether or not the progrmam is solved
   *              Postcondition: two player objects are assigned values by calling
   *              the Player constructor and the board object is assigned a phrase
   *              by calling the Board constructor
   * 
   */
  public PhraseSolver() {
    // First player constructor is called because no parameter is passed in
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }

  /* your code here - accessor(s) */

  /* your code here - mutator(s) */

  /**
   * Play(): Method to play the game until word guessed, repeatedly gets user
   * input until game ends and uses a boolean variable to check when this happens
   * 
   * @param none
   * @return none
   * @throws none
   *              Precondition - PhraseSolver object must be initialized and
   *              solved boolean variable must be initialized
   *              Postcondition - boolean solved is set to true and game
   *              terminates because the phrase has been guessed
   */

  public void play() {
    boolean solved = false;
    // Change player after every guess is made
    // int currentPlayer = 1;
    Player currentPlayer = player1;

    boolean correct = true;

    // Display welcome message
    System.out.println("Try guessing a secret phrase before your partner! Be careful to read whose turn it is.");

    // Play game until a player guesses the word correct
    while (!solved) {

      /* your code here - game logic */

      // Displaying player and points before each round
      System.out.println("\n" + "-------CURRENT POINTS--------");
      System.out.println(player1.getName() + ": " + player1.getPoints());
      System.out.println(player2.getName() + ": " + player2.getPoints());

      // Displaying phrase with guessed letters
      System.out.println("----------GUESSING-----------");
      // System.out.println("Phrase: " + game.getPhrase()); // for testing
      System.out.println("Solved Phrase: " + game.getSolvedPhrase());
      // Generates random chance of being bankrupted
      int bankrupt = (int) (Math.random() * 15);
      if (bankrupt == 1) {
        System.out.println("-----------------");
        System.out.println("BANKRUPT for " + currentPlayer.getName() + ". You now have 0 points.");
        System.out.println("-----------------");
        // Reduces player points to zero
        currentPlayer.setPoints(currentPlayer.getPoints() * -1);
        // Switch Players
        if (currentPlayer == player1) {
          currentPlayer = player2;
        } else {
          currentPlayer = player1;
        }
        continue;
      }

      // Getting player guess
      // tell which player needs to guess
      System.out.print(currentPlayer.getName() + ": Enter a guess (\"1\" for guessing the whole phrase): ");
      Scanner sc = new Scanner(System.in);
      String input = sc.nextLine();
      Character t = input.charAt(0);
      // Checks to make sure user enters valid response
      while (!Character.isLetter(t) && !input.equals("1")) {
        System.out.print("Invalid, please reenter: ");
        input = sc.nextLine();
        t = input.charAt(0);
      }

      // Checking if user wants to solve phrase
      if (input.equals("1")) {
        System.out.print("Enter your phrase guess: ");
        String input2 = sc.nextLine();
        if (game.guessPhrase(input2)) {
          solved = true;
          System.out.println("\n" + "Solved Phrase: " + game.getSolvedPhrase());
          System.out.println("The phrase is solved!");
          currentPlayer.setPoints(game.getCurrentLetterValue());
        }
      } else {
        // Checking to make sure that the letter hasn't been guessed already
        if (game.getSolvedPhrase().indexOf(input) != -1) {
          System.out.println("\n" + "That has already been guessed.");
        }
        // Checking if guess is correct
        else if (game.guessLetter(input)) {
          currentPlayer.setPoints(game.getCurrentLetterValue());
          System.out.println("\n" + input + " is in the word!");
        } else {
          System.out.println("\n" + input + " is not in the word.");
        }

        /* your code here - determine how game ends */
        if (game.getSolvedPhrase().replace(" ", "").equals(game.getPhrase().replace(" ", ""))) {
          solved = true;
          System.out.println("\n" + "Solved Phrase: " + game.getSolvedPhrase());
          System.out.println("The phrase is solved!");
        }

      }
      // Switch Players
      if (currentPlayer == player1) {
        currentPlayer = player2;
      } else {
        currentPlayer = player1;
      }

    }

    // Display Winner
    if (player1.getPoints() > player2.getPoints()) {
      System.out.println(player1.getName().toUpperCase() + " WINS!");
    } else if (player2.getPoints() > player1.getPoints()) {
      System.out.println(player2.getName().toUpperCase() + " WINS!");
    } else {
      System.out.println("TIE!");
    }

  }
}