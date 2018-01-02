

/**
 * Class
 *
 * @author Legendary Eagles
 **/
public class Main {
    public static void main(String args[]) {
        OperationHelper instructionHelper = OperationHelper.getInstance();
        System.out.println(instructionHelper.getCode("lsl"));
        System.out.println(instructionHelper.getCode("add"));
        System.out.println(instructionHelper.getCode("sub"));
        System.out.println(instructionHelper.getCode("lsr"));

        int[] sizeOfParameters = instructionHelper.getSizeOfParameters("str");
        for (int i = 0; i < sizeOfParameters.length; ++i) System.out.println(sizeOfParameters[i]);
    }
}
