/**
 * Class
 *
 * @author Legendary Eagles
 **/
public class Variable {

    /**
     * Fonction qui prend une string présentant une variable et la retourne en string la présentant en binaire
     *
     * @param nbBits : nombre de bits sur lesquels écrire la variable en binaire
     * @param name   : string contenant la variable
     * @return String : présentation binaire de la variable en string
     */
    public String getCode(int nbBits, String name) {
        int value = 0;

        value = Integer.parseInt(name.substring(1));

        String binary = Integer.toBinaryString(value);

        int bitsMissing = nbBits - binary.length();

        String res = new String();
        for (int i = 0; i < bitsMissing; i++) {
            res = res.concat("0");
        }

        return res.concat(binary);
    }

    public static void main(String[] args) {
        Variable v = new Variable();
        String s = v.getCode(8, "#11");
        System.out.println(s);
    }
}

