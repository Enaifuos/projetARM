import java.util.ArrayList;
import java.util.List;

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
        String hexaString = "";
        inputReader.jumpToMainLine();
        String[] instruction;
        while((instruction = inputReader.readNextInstruction()) != null){
            String binaryString = "";
            String operationName = instruction[0];
            if (instruction[1].equals("sp")) {
                binaryString += operationHelper.getCode(operationName + "sp");
                binaryString += addVariables(instruction, operationName + "sp");
            } else {
                binaryString += operationHelper.getCode(operationName);
                binaryString += addVariables(instruction, operationName);
            }
            System.out.println("Binary : " + binaryString);
            Converter converter = new Converter(binaryString);
            hexaString += " " + converter.toHexa();
            System.out.println("Hexa :" + hexaString);
        }

        return hexaString;
        //1011000010011000
        //   0001101011000
    }

    private String addVariables(String[] instruction, String operationName) {
        String variableString = "";
        int[] parametersSize = operationHelper.getSizeOfParameters(operationName);
        if(parametersSize.length < instruction.length -1){
            List<String> newInstruction = new ArrayList<String>();
            newInstruction.add(instruction[0]);
            for (int i = 1; i<instruction.length; ++i){
                if(!instruction[i].equals("sp")) newInstruction.add(instruction[i]);
            }
            if(newInstruction.get(newInstruction.size()-1).equals(newInstruction.get(1))
                    && newInstruction.size() > 2){
                //Cas spéciaux genre muls ou y'a rd et rm sur un même emplacement
                newInstruction.remove(1);
            }
            instruction = new String[newInstruction.size()];
            newInstruction.toArray(instruction);
        }
        for (int i = 1; i < instruction.length; ++i) {
            variableString += Variable.getCode(parametersSize[i - 1], instruction[i]);
        }
        return variableString;
    }
}
