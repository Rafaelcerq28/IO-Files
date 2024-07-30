import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("add five names");

        Scanner keybord = new Scanner(System.in);
        String userList ="";

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("input the name " + (i + 1));
                String userInput = keybord.nextLine();
                userList += (i + 1) + " " + userInput + "\n";
            }
        
            System.out.println(userList);
            writeUsingFilesWriteStringMethod(userList);
        } catch (Exception e) {

        }
    }

    public static void writeUsingFilesWriteStringMethod(String userList) {
        try {
            Path outputFileName = Path.of("names.txt");
            Files.writeString(outputFileName, userList);
            System.out.println("Data was added to " + outputFileName);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
