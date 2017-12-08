import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("/Users/sreediss/Experiments/log"));

        sc.nextLine();
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            String algo1 = sc.nextLine();
            String algo2 = sc.nextLine();

            if(algo1.contains("TEAM-B") && !algo2.contains("2")){
                System.out.println(input + " "+ algo1 + " "+ algo2);
            }

            if(algo1.contains("TEAM-A") && !algo2.contains("1")){
                System.out.println(input + " "+ algo1 + " "+ algo2);
            }
            if(algo1.contains("TIE") && !algo2.contains("3")){
                System.out.println(input + " "+ algo1 + " "+ algo2);
            }

        }
    }
}
