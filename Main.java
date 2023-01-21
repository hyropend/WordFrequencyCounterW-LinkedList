import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {

        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.readFile("input.txt");
        counter.printToFile("output.txt");
        System.out.println("the process is done");

    }
}
