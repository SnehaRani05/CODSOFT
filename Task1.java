import java.util.*;
public class Task1{
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    static int randomNum;
    public static void OriginalNumber(){
        
        
        randomNum = random.nextInt(100);        
        
        System.out.println("Rule: You have only 5 guesses !\n Let's begin !");
        System.out.print("Guess a Number (0 to 100): ");
    }
    public static void GuessTheNumber(){
       
        for (int i = 0; i < 5; i++){ 
            int number = sc.nextInt();
            if(number < randomNum){
                System.out.println("Try Again !\n (Hint: Answer is Greater than your guess)");
            }
            else if(number > randomNum){
                System.out.println("Try Again !\n (Hint: Answer is Less than your guess)");
            }
            else {
                System.out.println("Bravo \nYou guessed it correct!");
                return;
            }
            
        }
        System.out.println("Better luck next time!");
        System.out.println("Original number is : "+ randomNum);
        
    }
    public static void main(String[] args) {
            
        boolean playAgain = true;

        while (playAgain) {
            OriginalNumber();
            GuessTheNumber();

            System.out.println("You played well! Do you want to play again? (yes/no)");
            String response = sc.next();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you! Visit again!");
    }
            
    }
