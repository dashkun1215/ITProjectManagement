package org.example;


public class Main {

    public static void main(String[] args) {
        String message = " MATHEMATICS AND LIMITED DOCUMENTATION SUPPLIED BY CAPTAIN GUSTAVE BERTRAND OF FRENCH " +
                "MILITARY INTELLIGENCE. THIS WAS THE GREATEST BREAKTHROUGH IN CRYPTANALYSIS IN A " +
                "THOUSAND YEARS AND MORE, ACCORDING TO HISTORIAN DAVID KAHN. REJEWSKI AND HIS " +
                "MATHEMATICAL CIPHER BUREAU COLLEAGUES, JERZY REEYCKI AND HENRYK ZYGALSKI, CONTINUED " +
                "READING ENIGMA AND KEEPING PACE WITH THE EVOLUTION OF THE GERMAN ARMY MACHINTHE GERMANS" +
                " MADE HEAVY USE, IN SEVERAL VARIANTS, OF AN ELECTROMECHANICAL ROTOR MACHINE KNOWN AS ENIGMA." +
                " MATHEMATICIAN MARIAN REJEWSKI, AT POLAND'S CIPHER BUREAU, IN DECEMBER DEDUCED THE DETAILED STR" +
                "UCTURE OF THE GERMAN ARMY ENIGMA, USING M";
//        Викликаємо функцію кодування
        String encodedMsg = String.valueOf(Code(message));
        System.out.println(encodedMsg);
//        Викликаємо функцію декодування
        encodedMsg = String.valueOf(Decode(encodedMsg));
        System.out.print(encodedMsg);
    }
    public static int[] toNumbs (char[] text1) {
        char[] latin = {' ', '.', ',', ';', '-', '\'', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int[] codeOfText = new int[text1.length];
        for (int i = 0; i < text1.length; i++) {
            for (int j = 0; j < latin.length; j++) {
                if (text1[i] == latin[j]) {
                    codeOfText[i]=j;
                }
            }
        }
        return codeOfText;
    }
    public static char[] toText (int[] text1) {
        char[] latin = {' ', '.', ',', ';', '-', '\'', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] Text = new char[text1.length];
        for (int i = 0; i < text1.length; i++) {
            Text[i]=latin[text1[i]];
        }
        return Text;
    }
    public static char[] Code (String message) {
        int[] key= {5,6,7,8};
        int[] codeOfText = toNumbs(message.toCharArray());
        int[] encoded = new int[codeOfText.length];
        int F;
        int L, R, newL, newR;
        for(int i=0; i< codeOfText.length-1; i+=2){
            L=codeOfText[i];
            R=codeOfText[i+1];
            for(int j=0; j< (key.length); j++){
                F=(L+key[j])%32;
                newR=L;
                newL=F^R;
                encoded[i+1]=newR;
                encoded[i]=newL;
                R=newR;
                L=newL;

            }
        }
        return toText(encoded);
    }
    public static char[] Decode (String message) {
        int[] key= {8,7,6,5};
        int[] codeOfText = toNumbs(message.toCharArray());
        int[] encoded = new int[codeOfText.length];
        int F;
        int L, R, newL, newR;
        for(int i=0; i< codeOfText.length-1; i+=2){
            R=codeOfText[i];
            L=codeOfText[i+1];
            for(int j=0; j< (key.length); j++){
                F=(L+key[j])%32;
                newR=L;
                newL=F^R;
                encoded[i+1]=newL;
                encoded[i]=newR;
                R=newR;
                L=newL;

            }
        }
        return toText(encoded);
    }

}
