import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class that writes the output file
 *
 * @author Legendary eagles
 */
public class OutputWriter {
    // Attributs
    private String[] instruction;
    private String fileName;

    // Constructeur
    public OutputWriter(String fileName, String[] toWrite) {
        this.instruction = toWrite;
        this.fileName = fileName;
    }

    // Fonction pour écrire les données dans le fichier
    public void writeFile() {
        File file = new File(this.fileName);

        try {
            FileWriter writer = new FileWriter(file);

            // Ecriture de l'entête
            writer.write("v2.0 raw\n");

            for ( String str : this.instruction ) {
                if ( !str.equals("") ) { // pour éviter d'écrire un espace qui rendra le fichier de sortir inadapté
                    writer.write(str);
                    writer.write(" ");
                }
            }
            writer.close();
        }catch( IOException e) {
            System.out.println("Output's writing has occured a problem");
            System.out.println(e.getMessage());
        }
    }


    // Main pour le test
    public static void main(String[] args) {
        String[] instruction = {"hello","legendary eagles","bye"};
        OutputWriter outputWriter = new OutputWriter("out.txt",instruction);
        outputWriter.writeFile();
        System.out.println("FIN");
    }
}
