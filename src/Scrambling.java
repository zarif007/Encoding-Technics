/*
 -> Bipolar with eight-zero substitution (B8ZS)
 Commonly used in the North American T1 (Digital Signal 1) 1.544 Mbit/s line code, bipolar
 with eight-zero substitution (B8ZS) replaces each string of 8 consecutive zeros with the
 special pattern "000VB0VB". Depending on the polarity of the preceding mark, that could be
 000+−0−+ or 000−+0+−.

 -> High density bipolar of order 3 (HDB3)
 Used in all levels of the European E-carrier system, the high density bipolar of order 3 (HDB3)
 code replaces any instance of 4 consecutive 0 bits with one of the patterns "000V" or "B00V".
 The choice is made to ensure that consecutive violations are of differing polarity; i.e.,
 separated by an odd number of normal + or − marks.

*/


import java.util.Vector;

public class Scrambling {
    public static void main(String[] args) {
        int Amplitude[] = {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int Amplitude_1[] = {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Vector<Integer> GeneratedInB8ZS = GenInB8ZS(Amplitude);
        System.out.println(GeneratedInB8ZS);

        Vector<Integer> GeneratedInHDB3 = GenInHDB3(Amplitude_1);
        System.out.println(GeneratedInHDB3);
    }

    private static Vector<Integer> GenInB8ZS(int[] amplitude) {
        Vector<Integer> GeneratedInB8ZS = new Vector<>(), H8ZS = new Vector<>();
        int inversion = 1, cnt = 0, in = 0;

        for(int i=0; i<amplitude.length; i++) {
            if(amplitude[i] == 0)
                cnt++;
            else
                cnt = 0;
            if(cnt == 8){
                H8ZS.add(i - 7);
                cnt = 0;
            }
        }

        while (in < amplitude.length) {
            int inversions[] = {inversion*-1, inversion, 0, inversion, inversion*-1};
            if(amplitude[in] == 1) {
                GeneratedInB8ZS.add(inversion);
                inversion *= -1;
                in++;
            }  else if(H8ZS.contains(in)) {
                for(int i=0; i<8; i++){
                    if(i < 3)
                        GeneratedInB8ZS.add(0);
                    else{
                        GeneratedInB8ZS.add(inversions[i-3]);
                    }
                }
                in += 8;
            } else {
                GeneratedInB8ZS.add(0);
                in++;
            }
        }
        return GeneratedInB8ZS;
    }

    private static Vector<Integer> GenInHDB3(int[] amplitude){
        Vector<Integer> GeneratedInHDB3 = new Vector<>(), HDB3 = new Vector<>();
        int inversion = 1, cnt = 0, in = 0, hone = 0, inv = 1;

        for(int i=0; i<amplitude.length; i++) {
            if(amplitude[i] == 0)
                cnt++;
            else
                cnt = 0;
            if(cnt == 4){
                HDB3.add(i - 3);
                cnt = 0;
            }
        }

        while (in < amplitude.length) {
            if(amplitude[in] == 1) {
                GeneratedInHDB3.add(inversion);
                inversion *= -1;
                in++; hone++;
            }  else if(HDB3.contains(in)) {
                int inversions[];
                if(hone % 2 == 0) {
                    inversions = new int[]{inv, 0, 0, inv};  inversion *= -1;
                } else
                    inversions = new int[]{0, 0, 0, inv};
                inv = inversion;

                for(int i=0; i<4; i++){
                    GeneratedInHDB3.add(inversions[i]);
                }
                in += 4;
                hone = 0;
            } else {
                GeneratedInHDB3.add(0);
                in++;
            }
        }
        return GeneratedInHDB3;
    }
}
