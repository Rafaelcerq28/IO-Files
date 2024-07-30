import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;

public class ReadingFile {

    public static void main(String[] args) {
        String sInputFileName = "test.txt";

        //uncomment method calls from below one line at a time and see the result
        readUsingBufferedReader(sInputFileName);
        //readUsingFilesReadString(sInputFileName);
        //readUsingScanner(sInputFileName);
        //readAllBytes(sInputFileName);
        //readLines(sInputFileName);
        //readAllLines(sInputFileName);
        //readUsingBufferedReader8(sInputFileName);
    }

    public static void readUsingBufferedReader(String sInputFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(sInputFileName))) {
            String sOutputString;
            System.out.println("Reading from " + sInputFileName + " using BufferedReader()");
            while ((sOutputString = br.readLine()) != null) {
                System.out.println(sOutputString);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readUsingFilesReadString(String sInputFileName) {
        System.out.println("Reading from " + sInputFileName + " using Files readString()");
        try {
            Path inputFileName = Path.of(sInputFileName);
            String sOutputString = Files.readString(inputFileName);
            System.out.println(sOutputString);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readUsingScanner(String sInputFileName) {
        System.out.println("Reading from " + sInputFileName + " using Scanner()");
        try {
            Path inputFileName = Path.of(sInputFileName);
            Scanner keyboard = new Scanner(inputFileName);

            while (keyboard.hasNext()) {
                System.out.println(keyboard.next());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readAllBytes(String sInputFileName) {
        System.out.println("Reading from " + sInputFileName + " using readAllBytes()");
        try {
            String sOutputString;
            sOutputString = new String(Files.readAllBytes(Paths.get(sInputFileName)));
            System.out.println(sOutputString);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void readLines(String sInputFileName) {
        System.out.println("Reading from " + sInputFileName + " using Files lines()");
        StringBuilder sb = new StringBuilder();
        try (Stream<String> inputStream = Files.lines(Paths.get(sInputFileName))) {
            inputStream.forEach(line -> sb.append(line).append("\n"));
            System.out.println(sb.toString());

            //condensed version of the above
            //inputStream.forEach(System.out::println);       
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readAllLines(String sInputFileName) {
        System.out.println("Reading from " + sInputFileName + " using Files readAllLines()");
        try {
            Path inputFileName = Paths.get(sInputFileName);
            List<String> inputLines = Files.readAllLines(inputFileName, StandardCharsets.UTF_8);
            inputLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readUsingBufferedReader8(String sInputFileName) {
        System.out.println("Reading from " + sInputFileName + " using Files newBufferedReader() from Java version 8");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(sInputFileName))) {
            String sInLine;
            while ((sInLine = br.readLine()) != null) {
                sb.append(sInLine).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
