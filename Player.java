/*
 * Activity 2.5
 * Player is a class which sets up the initial state of the players and allows them to choose their names (starting off the game)
 * @author Paige Nothelfer
 * @author Nithila Sadheesh
 * @author Sanjitha Saravanan
 * @version 1.0 
 * @date 10/30/2023
 * Allows users to choose their names with a welcome message and sets up the initial number of points, assigning it to each payer. The method is later used in PhraseSolver to begin the game.
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int points;


  /* your code here - constructor(s) 
  * Precondition: Appropriate variables are instanciated.
  * Postcondition: Based on a user's response to entering the player name, stores the inputted name in variable name and prints welcome message after setting initial points to 0. 
  * @param none
  * @return none
  */ 
  public Player() {
    System.out.println("Enter Player Name: "); 
    Scanner sc = new Scanner(System.in); 
    String newName = sc.nextLine(); 
    name = newName; 
    System.out.println("Hello and welcome to the game, " + name); 
    points = 0;
  }

  /*
  * Precondition: Appropriate variables are instansiated.
  * Postcondition: Name is set based on inputName when creating the object and points are initially set to 0.
  * @param inputName    name which the user wants to assign to the player object being created
  * @return none
  */
  public Player(String inputName) {
    name = inputName;
    points = 0;
    System.out.println("Hello and welcome to the game, " + name);
  }

  /* your code here - accessor(s) */ 

  /*
  * Precondition: Variable name is initialized and properly instantiated
  * Postcondition: The name is returned to the program.
  * @param none 
  * @return name    name which the user sets is acquired
  */
  public String getName() {
    return name; 
  }

  /*
  * Precondition: Variable points is initialized and properly instantiated
  * Postcondition: The number of points currently is returned to the program in an accessible format. 
  * @param none 
  * @return points    points which the user has is acquired
  */
  public int getPoints() {
    return points; 
  }

  /* your code here - mutator(s) */ 

  /*
  * Precondition: name variable is instansiated properly
  * Postcondition: A new String is assigned to name with the new name based on the change. 
  * @param n        name which programmer wants to change to 
  * @return none
  */
  public void setName(String n) {
    name = n; 
  }

  /*
  * Precondition: Points variable is instansiated properly
  * Postcondition: Points is updated with the new amount of points to be added based on the provided argument. 
  * @param addingPoints       the amount of points which the user wants to add 
  * @return none
  */
  public void setPoints(int addingPoints) {
    points += addingPoints;
  }
 
}