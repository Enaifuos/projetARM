import java.util.ArrayList;
import java.util.List;

/**
 * @Author Legendary Eagles
 */
public class Converter {
    /*  Attributs   */
    private String binary;
    private String hexa;

    /* Constructeur */
    public Converter(String binary) {
        this.binary = binary;
        formatStringBinary(); // Formater la séquence
        this.hexa = new String();
    }

    /*  Une fonction pour adapter le format de la séquence binaire pour avoir une taille multiple de 4
     *    111 devient 0111 et 01 devient 0001 et 1100 reste 1100
     */
    public void formatStringBinary() {
        int nbMissingBits = (4-(this.binary.length()%4))%4;

        String zerosToAdd = new String();
        for ( int i = 0 ; i < nbMissingBits ; i++ ) zerosToAdd = zerosToAdd.concat("0");
        this.binary = zerosToAdd.concat(this.binary);
    }

    /* Fonction pour séparer la séquence binaire en paquets de 4 bits */
    public String[] packetsOfFour() {
        String[] packetsOfFour = new String[this.binary.length()/4];
        String building = new String();

        char[] binaryToCharArray = this.binary.toCharArray();
        int j = 0;
        int k = 0;

        for ( int i = binaryToCharArray.length-1 ; i >= 0 ; i-- ) {
            building = building.concat(binaryToCharArray[i]+"");
            j++;
            if ( j == 4 ) {
                j = 0;
                packetsOfFour[k++] = new StringBuffer(building).reverse().toString();
                building = new String();
            }

        }

        /*  Inverser le tableau */
        String[] result = new String[this.binary.length()/4];
        int jj = 0;
        for ( int i = packetsOfFour.length-1 ; i >= 0 ; i -- ) {
            result[jj++] = packetsOfFour[i];
        }

        return result;
    }


    /*  Fonction qui convertit un paquet de 4 bits en hexa  */
    private String paquetFourToHexa(String paquet) {
        char[] paquetArray = paquet.toCharArray();
        int hexValue = 0;
        String result;
        for ( int i = 3 ; i >= 0 ; i-- ) {
            hexValue += Integer.parseInt(Character.toString(paquetArray[i]))*Math.pow(2,4-i-1);
        }
        if ( hexValue < 10 ) {
            result = String.valueOf(hexValue);
        }
        else {
            hexValue += 55;
            result = (String.valueOf(hexValue));
            int v = Integer.parseInt(result);
            char r = (char)v;
            result = Character.toString(r);
        }

        return result;
    }

    /*  Fonction pour convertir toute la séquence binaire ( déjà écrite en paquets de 4 bits ) en hexa  */
    public String toHexa() {
        String[] paquets = this.packetsOfFour(); // Le tableau des paquets
        for ( String s : paquets ) {
            this.hexa = this.hexa.concat(paquetFourToHexa(s));
        }

        return this.hexa;
    }


    public static void main(String[] args) {
        String binary = "110010111";
        Converter c = new Converter(binary);
        String hexa = c.toHexa();
        System.out.println(binary +" convertit en hexa = "+ hexa);

    }


}

