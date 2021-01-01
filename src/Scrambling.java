import java.util.Vector;

public class Scrambling {
    public static void main(String[] args) {
        int Amplitude[] = {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int Amplitude_1[] = {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

//        Vector<Integer> GeneratedInB8ZS = GenInB8ZS(Amplitude);
//        System.out.println(GeneratedInB8ZS);

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
            int inversions_1[] = {0, 0, 0, inv}, inversions_2[] = {inv, 0, 0, inv};
            if(amplitude[in] == 1) {
                GeneratedInHDB3.add(inversion);
                inversion *= -1;
                in++; hone++;
            }  else if(HDB3.contains(in)) {
                int array[];
                if(hone % 2 == 0) {
                    array = inversions_2;  inversion *= -1;
                } else
                    array = inversions_1;
                inv = inversion;

                for(int i=0; i<4; i++){
                    GeneratedInHDB3.add(array[i]);
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
