

/**
 * Class
 *
 * @author Legendary Eagles
 **/
public class Main {
    public static void main(String args[]) {
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
        InputReader inputReader = new InputReader("src/main/resources/calculator.s");
        Parser parser = new Parser(inputReader);


        System.out.println("Instruction (ligne 30) parsée :" + parser.parse());

    }
}
