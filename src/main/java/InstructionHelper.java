import java.util.ArrayList;
import java.util.List;

/**
 * Class
 *
 * @author Legendary Eagles
 **/
public class InstructionHelper {
    private static InstructionHelper uniqueInstance = new InstructionHelper();

    public enum InstructionType {
        //TODO : ajouter les autres instructions + les instructions avec un "s"
        //Shift,add,sub
        LSLI("00","000","lsli"),
        LSRI("00","001","lsri"),
        ASRI("00","010","asri"),
        ADD("00","01100","add"),
        SUB("00","01101","sub"),
        MOV("00","100", "mov"),
        //DataProc
        AND("010000","0000","and"),
        EOR("010000","0001","eor"),
        LSL("010000","0010","lsl"),
        LSR("010000","0011","lsr"),
        ASR("010000","0100","asr"),
        ADC("010000","0101","adc"),
        SBC("010000","0110","sbc"),
        ROR("010000","0111","ror");
        //LoadStore

        private String opCode;
        private String categorieCode;
        private String Iname;

        public String getOpCode() {
            return opCode;
        }

        public String getIname() {
            return Iname;
        }

        InstructionType(String categorieCode, String opCode, String Iname) {
            this.categorieCode = categorieCode;
            this.opCode = opCode;
            this.Iname = Iname;
        }
    }

    private static List<InstructionType> instructionTypes;

    private InstructionHelper(){
        instructionTypes = new ArrayList<InstructionType>();
        instructionTypes.add(InstructionType.LSLI);
        instructionTypes.add(InstructionType.LSRI);
        instructionTypes.add(InstructionType.ASRI);
        instructionTypes.add(InstructionType.ADD);
        instructionTypes.add(InstructionType.SUB);
        instructionTypes.add(InstructionType.MOV);
        instructionTypes.add(InstructionType.AND);
        instructionTypes.add(InstructionType.EOR);
        instructionTypes.add(InstructionType.LSL);
        instructionTypes.add(InstructionType.LSR);
        instructionTypes.add(InstructionType.ASR);
        instructionTypes.add(InstructionType.ADC);
        instructionTypes.add(InstructionType.ROR);
    }

    public String getCode(String name){
        for (InstructionType instructionT: instructionTypes) {
            if(instructionT.getIname().equals(name)) return instructionT.categorieCode + instructionT.getOpCode();
        }
        return null;
    }

    public static InstructionHelper getInstance(){
        return uniqueInstance;
    }
}
