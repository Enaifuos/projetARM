

/**
 * Class
 *
 * @author Legendary Eagles
 **/
public class Main {
 /*   public static void main(String args[]) {
        //Code des opérations
        OperationHelper instructionHelper = OperationHelper.getInstance();
        System.out.println(instructionHelper.getCode("lsl"));
        System.out.println(instructionHelper.getCode("add"));
        System.out.println(instructionHelper.getCode("sub"));
        System.out.println(instructionHelper.getCode("lsr"));

        //Taille des params
        int[] sizeOfParameters = instructionHelper.getSizeOfParameters("str");
        for (int i = 0; i < sizeOfParameters.length; ++i) System.out.println(sizeOfParameters[i]);

        //Lecture d'une instruction
        InputReader inputReader = new InputReader("calculator.s");
        Parser parser = new Parser(inputReader);

        /*
            // Stock la seule donnée lue dans un tableau
        String[] instruction = {parser.parse()};
        OutputWriter outputWriter = new OutputWriter("out.txt",instruction);
        // Ecriture de la donnée dans out.txt
        outputWriter.writeFile(); */

 /*       System.out.println("Instruction parsée :" + parser.parse());

    }*/

     public static void main(String args[]) {
         //OperationHelper instructionHelper = OperationHelper.getInstance();
         InputReader inputReader = new InputReader("calculator.s"); // lecture du fichier d'entrée
         Parser parser = new Parser(inputReader);   // parser le fichier d'entrée
         String[] instructions = parser.parse().split(" "); // récupération des instructions
         OutputWriter outputWriter = new OutputWriter("out.txt",instructions); // écriture du fichier de sortie
         outputWriter.writeFile();
    }
}
