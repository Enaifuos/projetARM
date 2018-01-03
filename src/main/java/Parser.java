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

    public String jumpToMainLine(){
        String line = inputReader.readFile();
        while (!line.contains("main:")){
            line = inputReader.readFile();
        }
        return line;
    }

    public String[] getNextInstruction(){
        String line = inputReader.readFile();
        //TODO : gérer le stack pointer (sp)
        //Pour l'instant on ignore les lignes étranges
        while(line.contains(".") || line.contains("@") || line.contains("sp")){
            line = inputReader.readFile();
        }
        line = line.replace("\t", " ");
        if(line.charAt(0) == ' ') line = line.substring(1, line.length()); //On retire l'espace du début
        String[] instruction = line.split(" ");
        System.out.println("la ligne : " + line);
        for (int i = 0; i<instruction.length; ++i){
            instruction[i] = instruction[i].replace(",", ""); //On enlève les virgules
        }
        System.out.println("Taille : " + instruction.length);
        return instruction;
    }
    public String parse() {
        jumpToMainLine();
        String binaryString = "";
        String hexaString = "";
        String[] instruction = getNextInstruction();
        binaryString += operationHelper.getCode(instruction[0]);
        int[] parametersSize = operationHelper.getSizeOfParameters(instruction[0]);
        for (int i =1; i<instruction.length; ++i){
            binaryString += Variable.getCode(parametersSize[i-1], instruction[i]);
        }
        Converter converter = new Converter(binaryString);
        return converter.toHexa();
    }
}
