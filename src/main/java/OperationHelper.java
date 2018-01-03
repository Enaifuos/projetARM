import java.util.ArrayList;
import java.util.List;

/**
 * Class
 *
 * @author Legendary Eagles
 **/
public class OperationHelper {
    private static OperationHelper uniqueInstance = new OperationHelper();

    public enum Categorie {
        LOADSTORE("1001", new int[]{3, 8}),
        SAS1("00", new int[]{5, 3, 3}),
        SAS2("00", new int[]{3, 3, 3}),
        SAS3("00", new int[]{3, 8}),
        DATAP("010000", new int[]{3, 3});

        private String code;
        private int[] neededBits;

        Categorie(String code, int[] neededBits) {
            this.code = code;
            this.neededBits = neededBits;
        }

        public String getCode() {
            return code;
        }

        public int[] getNeededBits() {
            return neededBits;
        }
    }

    public enum OperationType {
        //TODO : ajouter opérations manquantes dans dataProc + les Operations avec un "s"
        //Shift,add,sub
        LSLI(Categorie.SAS1, "000", "lsli"),
        LSRI(Categorie.SAS1, "001", "lsri"),
        ASRI(Categorie.SAS1, "010", "asri"),
        ADD(Categorie.SAS2, "01100", "add"),
        SUB(Categorie.SAS2, "01101", "sub"),
        ADDI(Categorie.SAS2, "01110", "addi"),
        SUBI(Categorie.SAS2, "01111", "subi"),
        MOV(Categorie.SAS3, "100", "mov"),
        MOVS(Categorie.SAS3, "100", "movs"),
        //DataProc
        AND(Categorie.DATAP, "0000", "and"),
        EOR(Categorie.DATAP, "0001", "eor"),
        LSL(Categorie.DATAP, "0010", "lsl"),
        LSR(Categorie.DATAP, "0011", "lsr"),
        ASR(Categorie.DATAP, "0100", "asr"),
        ADC(Categorie.DATAP, "0101", "adc"),
        SBC(Categorie.DATAP, "0110", "sbc"),
        ROR(Categorie.DATAP, "0111", "ror"),
        //LoadStore
        STR(Categorie.LOADSTORE, "0", "str"),
        LDR(Categorie.LOADSTORE, "1", "ldr");


        private String opCode;
        private Categorie categorie;
        private String Iname;

        public String getCompleteCode() {
            return categorie.getCode() + opCode;
        }

        public String getIname() {
            return Iname;
        }

        public int[] getSizeOfParameters() {
            return categorie.getNeededBits();
        }

        OperationType(Categorie categorie, String opCode, String Iname) {
            this.categorie = categorie;
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
        OperationTypes.add(OperationType.ADDI);
        OperationTypes.add(OperationType.SUBI);
        OperationTypes.add(OperationType.MOV);
        OperationTypes.add(OperationType.MOVS);
        OperationTypes.add(OperationType.AND);
        OperationTypes.add(OperationType.EOR);
        OperationTypes.add(OperationType.LSL);
        OperationTypes.add(OperationType.LSR);
        OperationTypes.add(OperationType.ASR);
        OperationTypes.add(OperationType.ADC);
        OperationTypes.add(OperationType.SBC);
        OperationTypes.add(OperationType.ROR);
        OperationTypes.add(OperationType.STR);
        OperationTypes.add(OperationType.LDR);
    }

    public String getCode(String name) {
        for (OperationType OperationT : OperationTypes) {
            if (OperationT.getIname().equals(name)) return OperationT.getCompleteCode();
        }
        return null;
    }

    public int[] getSizeOfParameters(String name) {
        for (OperationType OperationT : OperationTypes) {
            if (OperationT.getIname().equals(name)) return OperationT.getSizeOfParameters();
        }
        return null;
    }

    public static OperationHelper getInstance() {
        return uniqueInstance;
    }
}
