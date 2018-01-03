/**
 * Class
 *
 * @author Legendary Eagles
 **/
public class Parser {
    private InputReader inputReader;
    private OperationHelper operationHelper;

    public Parser(InputReader inputReader) {
        this.inputReader = inputReader;
        operationHelper = OperationHelper.getInstance();
    }

    public String parse() {
        inputReader.jumpToMainLine();
        String binaryString = "";
        String[] instruction = inputReader.readNextInstruction();
        binaryString += operationHelper.getCode(instruction[0]);
        int[] parametersSize = operationHelper.getSizeOfParameters(instruction[0]);
        for (int i =1; i<instruction.length; ++i){
            binaryString += Variable.getCode(parametersSize[i-1], instruction[i]);
        }
        Converter converter = new Converter(binaryString);
        return converter.toHexa();
    }
}
