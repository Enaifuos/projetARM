import java.util.ArrayList;
import java.util.List;

/**
 * Class
 *
 * @author Legendary Eagles
 **/
public class OperationHelper {
    private static OperationHelper uniqueInstance = new OperationHelper();

    public enum OperationType {
        //TODO : ajouter les autres Operations + les Operations avec un "s"
        //Shift,add,sub
        LSLI("00", "000", "lsli"),
        LSRI("00", "001", "lsri"),
        ASRI("00", "010", "asri"),
        ADD("00", "01100", "add"),
        SUB("00", "01101", "sub"),
        MOV("00", "100", "mov"),
        //DataProc
        AND("010000", "0000", "and"),
        EOR("010000", "0001", "eor"),
        LSL("010000", "0010", "lsl"),
        LSR("010000", "0011", "lsr"),
        ASR("010000", "0100", "asr"),
        ADC("010000", "0101", "adc"),
        SBC("010000", "0110", "sbc"),
        ROR("010000", "0111", "ror");
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

        OperationType(String categorieCode, String opCode, String Iname) {
            this.categorieCode = categorieCode;
            this.opCode = opCode;
            this.Iname = Iname;
        }
    }

    private static List<OperationType> OperationTypes;

    private OperationHelper() {
        OperationTypes = new ArrayList<OperationType>();
        OperationTypes.add(OperationType.LSLI);
        OperationTypes.add(OperationType.LSRI);
        OperationTypes.add(OperationType.ASRI);
        OperationTypes.add(OperationType.ADD);
        OperationTypes.add(OperationType.SUB);
        OperationTypes.add(OperationType.MOV);
        OperationTypes.add(OperationType.AND);
        OperationTypes.add(OperationType.EOR);
        OperationTypes.add(OperationType.LSL);
        OperationTypes.add(OperationType.LSR);
        OperationTypes.add(OperationType.ASR);
        OperationTypes.add(OperationType.ADC);
        OperationTypes.add(OperationType.ROR);
    }

    public String getCode(String name) {
        for (OperationType OperationT : OperationTypes) {
            if (OperationT.getIname().equals(name)) return OperationT.categorieCode + OperationT.getOpCode();
        }
        return null;
    }

    public static OperationHelper getInstance() {
        return uniqueInstance;
    }
}
