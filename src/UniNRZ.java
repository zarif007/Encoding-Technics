/*
 -> Unipolar Encoding
 Unipolar encoding is a line code. A positive voltage represents a binary 1,
 and zero volts indicates a binary 0. It is the simplest line code, directly
 encoding the bitstream, and is analogous to on-off keying in modulation.
*/



import java.util.Vector;

public class UniNRZ {
    public static void main(String[] args) {
        int Amplitude[] = {0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1};
        int Amplitude_1[] = {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};

        Vector<Integer> GeneratedInNRZ_L = NRZ_L(Amplitude);
        System.out.println(GeneratedInNRZ_L);

        Vector<Integer> GeneratedInNRZ_I = NRZ_I(Amplitude);
        System.out.println(GeneratedInNRZ_I);
    }

    //Line Coding in Unipolar NRZ-L
    private static Vector<Integer> NRZ_L(int[] amplitude) {
        Vector<Integer> GeneratedInNRZ_L =  new Vector<>();

        for (int i=0; i<amplitude.length; i++){
            if (amplitude[i] == 0)
                GeneratedInNRZ_L.add(1);
            else
                GeneratedInNRZ_L.add(-1);
        }
        return GeneratedInNRZ_L;
    }

    //Line Coding in Unipolar NRZ_I
    private static Vector<Integer> NRZ_I(int[] amplitude) {
        Vector<Integer> GeneratedInNRZ_I =  new Vector<>();
        int inversion = -1;

        for (int i=0; i<amplitude.length; i++){
            if (amplitude[i] == 0){
                if (i>0)
                    GeneratedInNRZ_I.add(GeneratedInNRZ_I.get(i-1));
                else
                    GeneratedInNRZ_I.add(1);
            } else {
                GeneratedInNRZ_I.add(inversion);
                inversion *= -1;
            }
        }
        return GeneratedInNRZ_I;
    }

}
