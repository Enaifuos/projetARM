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
        close(); /* Fermer le lecteur   */
        return null;
    }

    /**
     * Permet d'ignorer les lignes inutiles et de partir directement a la ligne "main:"
     * @return
     */
    public String jumpToMainLine(){
        String line = readFile();
        while (!line.contains("main:")){
            line = readFile();
        }
        return line;
    }

    /**
     * Permet de lire une instruction et la retourne sous forme d'un tableau de String
     * Cette fonction ignore (pour l'instant) les lignes contenant certains caractères : @, ., sp
     * @return L'instruction sous forme d'un tableau
     */
    public String[] readNextInstruction(){
        String line = readFile();
        //TODO : gérer le stack pointer (sp) et l'autre bail chelou aussi
        //Pour l'instant on ignore les lignes étranges
        while(line.contains(".") || line.contains("@") || line.contains("sp")){
            line = readFile();
        }
        line = line.replace("\t", " ");
        if(line.charAt(0) == ' ') line = line.substring(1, line.length()); //On retire l'espace du début
        String[] instruction = line.split(" ");
        System.out.println("la ligne lue : " + line);
        //TODO : enlever les crochets
        for (int i = 0; i<instruction.length; ++i){
            instruction[i] = instruction[i].replace(",", ""); //On enlève les virgules
        }
        System.out.println("Taille du String[] : " + instruction.length);
        return instruction;
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

    public static void main(String[] args) {
        InputReader inputReader = new InputReader("src/main/resources/calculator.s");
        System.out.println("Vérification de l'arrivée à la ligne main : " + inputReader.jumpToMainLine());
        String[] instruction1 = inputReader.readNextInstruction();
        for (String s: instruction1) System.out.println(s);
    }
}
