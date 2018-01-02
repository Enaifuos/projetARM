import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that reads the input file
 *
 * @author Legendary eagles
 */
public class InputReader {

    private int lineNumber;
    private String path;
    private BufferedReader reader;


    /**
     * Constructor for the InputReader
     *
     * @param path the path to the file
     */
    public InputReader(String path) {
        this.lineNumber = 0;
        this.path = path;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method which read a line of the input file
     *
     * @return The string which contains informations of the file
     */
    public String readFile() {
        String line = "";
        try {
            line = reader.readLine();
            lineNumber++;
            if (line == null)
                reader.close();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Getter for the number of rhe line studied
     *
     * @return a int representing the line number
     */
    public int getLineNumber() {
        return lineNumber;
    }
    public void close(){
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
