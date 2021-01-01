import java.util.Vector;

public class Bipolar {
    public static void main(String[] args) {
        int Amplitude[] = {1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1};

        Vector<Integer> GeneratedInAMI = GenInAMI(Amplitude);
        System.out.println(GeneratedInAMI);

        Vector<Integer> GeneratedInPseudo = GenInPseudo(Amplitude);
        System.out.println(GeneratedInPseudo);
    }

    //Line Coding in Bipolar AMI
    private static Vector<Integer> GenInAMI(int[] amplitude) {
        Vector<Integer> GeneratedInAMI = new Vector<>();
        int inversion = 1;

        for (int i=0; i<amplitude.length; i++){
            if(amplitude[i] == 1){
                GeneratedInAMI.add(inversion);
                inversion *= -1;
            } else {
                GeneratedInAMI.add(0);
            }
        }
        return GeneratedInAMI;
    }

    //Line Coding in Pseudo Ternary
    private static Vector<Integer> GenInPseudo(int[] amplitude){
        Vector<Integer> GeneratedInPseudo = new Vector<>();
        int inversion = 1;

        for (int i=0; i<amplitude.length; i++){
            if(amplitude[i] == 0){
                GeneratedInPseudo.add(inversion);
                inversion *= -1;
            } else {
                GeneratedInPseudo.add(0);
            }
        }
        return GeneratedInPseudo;
    }
}
