/*
 -> Manchester Encoding
 Manchester coding is a special case of binary phase-shift keying (BPSK),
 where the data controls the phase of a square wave carrier whose frequency
 is the data rate. Manchester code ensures frequent line voltage transitions,
 directly proportional to the clock rate; this helps clock recovery.
*/


import java.util.Vector;

public class Manchester {
    public static void main(String[] args) {
        int Amplitude[] = {0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1};

        Vector<Integer> GeneratedInMAN = GenInMan(Amplitude);
        System.out.println(GeneratedInMAN);

        Vector<Integer> GeneratedInDMAN = GenInDMan(Amplitude);
        System.out.println(GeneratedInDMAN);
    }

    //Line Coding in Bipolar Manchester
    private static Vector<Integer> GenInMan(int[] amplitude) {
        Vector<Integer> GeneratedInMAN =  new Vector<>();

        for (int i=0; i<amplitude.length; i++){
            if (amplitude[i] == 0) {
                GeneratedInMAN.add(1);
                GeneratedInMAN.add(-1);
            } else {
                GeneratedInMAN.add(-1);
                GeneratedInMAN.add(1);
            }
        }
        return GeneratedInMAN;
    }

    //Line Coding in Bipolar Differential Manchester
    private static Vector<Integer> GenInDMan(int[] amplitude) {
        Vector<Integer> GeneratedInDMAN =  new Vector<>();
        int inversion = 1;

        for (int i=0; i<amplitude.length; i++) {
            if(amplitude[i] == 1)
                inversion *= -1;

            GeneratedInDMAN.add(inversion);
            GeneratedInDMAN.add(inversion * -1);

        }
        return GeneratedInDMAN;
    }
}
