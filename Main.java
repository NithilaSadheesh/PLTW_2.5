/* 
Delete later (Schick's instructions): 
-Display the game - Players, scores, curr player, letter value or ‘bankrupt’, working phrase, already guessed letters.
-Prompt the current player for a valid guess. (The player should be able to type a full phrase or a single letter for a guess; keep prompting until valid)
-Update the game: Check to see if the phrase is solved, update scores.
-Switch players if the guess is incorrect, and repeat the above.

Bugs: 

Paige: 
-For guessPhrase method: 
  ->solvedPhrase would print out wrong; fixed by removing the line that added in extra spaces 
  ->points would be assigned to wrong player when they guess the phrase correct; fixed by moving around the if loop that decided which player's turn it was 
-For input checking: 
  ->entering a word wouldn't repromt the user to enter a guess; fixed by changing the input for guessing the phrase from "solve phrase" to "1"
  ->isLetter() function only works on characters, not strings; fixed by converting string to Character type and then calling isLetter() using Character class 
  ->program was telling user to reenter a guess no matter what; fixed by changing || to && within if statement header 
-For bankruptcy 
  ->points weren't changing for player; fixed by calling setPoints on the current player 
*/

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}