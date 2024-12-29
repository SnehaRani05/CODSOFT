//Grade Calculator
import java.util.*;
public class Task2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects:");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Invalid number of subjects.");
            return;
        }
        System.out.println("Enter marks obtained in each subject:");
        float marks[] = new float[n];
        float TotalMarks = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextFloat();

            // Validate marks input
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks entered. Marks should be between 0 and 100.");
                return;
            }

            TotalMarks += marks[i];
        }
        System.out.println("Total Marks obtained = "+ TotalMarks+" / "+n*100);
        float Average = TotalMarks/n;
        System.out.println("Average = "+Average);
        float Percentage = (TotalMarks/(n*100))*100;
        System.out.println("Percentage = "+Percentage+"%");
        if(Percentage>=90){
            System.out.println("Grade = O");
        }
        else if (Percentage>=80) {
            System.out.println("Grade = A");

        }
        else if (Percentage>=70) {
            System.out.println("Grade = B");
        } 
        else if (Percentage>=60) {
            System.out.println("Grade = C");
        }
        else if (Percentage>=50) {
            System.out.println("Grade = D");
        }
        else {
            System.out.println("Grade = F");
        }
    }
}