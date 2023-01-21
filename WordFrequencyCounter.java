import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
public class WordFrequencyCounter {

    LinkedList[] lists;

    public WordFrequencyCounter() {
        lists = new LinkedList[26];//seperate linked list for each letter there are 26 letters in the alphabet
        for (int i = 0; i < 26; i++) {
            lists[i] = new LinkedList((char)('a' + i));
        }
    }

    public void readFile(String inputFile) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\emreb\\IdeaProjects\\proje2\\src\\input1.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            String[] words = line.split("\\s+");//separating from blank spaces and putting it into a array
            for (String word : words) {//ilk
                word = word.toLowerCase();
                // check if the word contains only alphabetical characters
                if (word.matches("^[a-z]+$")) {//Check to see whether your input string consists entirely of alphabetic characters
                    System.out.println("inserting:"+word);
                    int index = (int)(word.charAt(0) - 'a');
                    int frequency = lists[index].findFrequency(word);
                    if (frequency == 0) {
                        lists[index].insert(word);
                    } else {
                        lists[index].incrementFrequency(word);
                    }
                }
            }
        }
        reader.close();
    }

    public void printToFile(String outputFile) throws Exception {
        PrintWriter writer = new PrintWriter("output.txt");
        for (int i = 0; i < 26; i++) {
            Node current = lists[i].head;
            while (current != null) {
                writer.println(current.word + " " + current.frequency);
                current = current.next;
            }
        }
        writer.close();
    }
}
