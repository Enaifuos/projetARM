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
    }
}
