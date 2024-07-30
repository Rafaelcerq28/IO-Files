import java.util.Scanner;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WritingFile {

    public static void main(String arg[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the output file name (without file extension): ");
        String sFileName = keyboard.nextLine() + ".txt";

        //uncomment method calls from below one line at a time and see the result
        writeUsingFilesWriteStringMethod(sFileName);
        //appendUsingFilesWriteStringMethod(sFileName);

        //writeUsingBufferedWriter8(sFileName);
        //appendUsingBufferedWriter(sFileName);
        //writeUsingPrintWriter(sFileName);           
        //writeUsingFileWriter(sFileName);
        //writeUsingFileOutputStream(sFileName);           
    }

    //Write using Java 11
    public static void writeUsingFilesWriteStringMethod(String inFileName) {
        try {
            Path outputFileName = Path.of(inFileName);
            String sOutputString = "Writing some data to file using Files writeString()\n";
            Files.writeString(outputFileName, sOutputString);
            System.out.println("Data was added to " + outputFileName);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //The writeString() can be modified to allow data to be appended to a file
    public static void appendUsingFilesWriteStringMethod(String inFileName) {
        try {
            Path outputFileName = Path.of(inFileName);
            String sOutputString = "Appending some data to file using Files writeString()\n";
            Files.writeString(outputFileName, sOutputString, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Data was appended to " + outputFileName);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //This method makes use of BufferWriter for efficiency and Java 8 APIs
    public static void writeUsingBufferedWriter8(String inFileName) {

        Path outputFileName = Paths.get(inFileName);
        String sOutputString = "Writing some data to file using BufferedWriter() from Java version 8\n";
        try (BufferedWriter bw = Files.newBufferedWriter(outputFileName)) {
            bw.write(sOutputString);
            System.out.println("Data was added to " + outputFileName);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //This method makes use of BufferWriter and FileWriter to provide append functionality
    public static void appendUsingBufferedWriter(String inFileName) {
        String sOutputString = "Appending some data to file using BufferedWriter() & FilewWriter()\n";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inFileName, true))) {
            bw.append(sOutputString);
            System.out.println("Data was appended to " + inFileName);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //This method uses java.io PrintWriter class to provide formatting functionality
    public static void writeUsingPrintWriter(String inFileName) {
        try (FileWriter fw = new FileWriter(inFileName); PrintWriter pw = new PrintWriter(fw);) {
            pw.println("Writing data using PrintWriter()...");
            pw.printf("%s is %d years old\n", "John Doe", 22);
            System.out.println("Data was added to " + inFileName);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //This method writes using FileWriter from java.io - standard solution before Java 7/8
    public static void writeUsingFileWriter(String inFileName) {
        String sOutputString = "Writing some data to file using FileWriter()\n";

        try (FileWriter fw = new FileWriter(inFileName); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(sOutputString);
            bw.newLine();
            System.out.println("Data was added to " + inFileName);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //Useful for writing raw bytes to a file e.g., an image 
    public static void writeUsingFileOutputStream(String inFileName) {
        try {
            String sOutputString = "Writing some data to a file using FileOutputStream()\n";
            FileOutputStream outputStream = new FileOutputStream(inFileName);
            byte[] strToBytes = sOutputString.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
