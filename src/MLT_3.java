/*
  -> Multi-Level Transmit
  MLT-3 cycles sequentially through the voltage levels −1, 0, +1, 0. It moves
  to the next state to transmit a 1 bit, and stays in the same state to transmit a 0 bit.
  Similar to simple NRZ encoding, MLT-3 has a coding efficiency of 1 bit/baud, however it
  requires four transitions (baud) to complete a full cycle (from low-to-middle, middle-to-high,
  high-to-middle, middle-to-low). Thus, the maximum fundamental frequency is reduced to one
  fourth of the baud rate. This makes signal transmission more amenable to copper wires.
*/


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
