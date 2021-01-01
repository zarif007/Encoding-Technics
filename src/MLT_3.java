import java.util.Vector;

public class MLT_3 {
    public static void main(String[] args) {
        int Amplitude[] = {0, 1, 0, 1, 1, 0, 1, 1};

        Vector<Integer> GeneratedInMLT_3 = GenInMLT_3(Amplitude);
        System.out.println(GeneratedInMLT_3);
    }

    private static Vector<Integer> GenInMLT_3(int[] amplitude) {
        Vector<Integer> GeneratedInMLT_3 = new Vector<>();
        int inversions[] = {1, 0, -1, 0}, inv = -1;

        for (int i=0; i<amplitude.length; i++){
            if(amplitude[i] == 0){
                GeneratedInMLT_3.add(inversions[Math.max(inv, 0) % 4]);
            } else {
                GeneratedInMLT_3.add(inversions[++inv % 4]);
            }
        }
        return GeneratedInMLT_3;
    }
}
