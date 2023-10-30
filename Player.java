/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int points;

  /* your code here - constructor(s) */ 
  public Player() {
    System.out.println("Enter Player Name: "); 
    Scanner sc = new Scanner(System.in); 
    String newName = sc.nextLine(); 
    name = newName; 
    System.out.println("Hello and welcome to the game, " + name); 
    points = 0;
  }
  
  public Player(String inputName) {
    name = inputName;
    points = 0;
    System.out.println("Hello and welcome to the game, " + name);
  }

  /* your code here - accessor(s) */ 
  public String getName() {
    return name; 
  }

  public int getPoints() {
    return points; 
  }

  /* your code here - mutator(s) */ 
  public void setName(String n) {
    name = n; 
  }

  public void setPoints(int addingPoints) {
    points += addingPoints;
  }
 
}