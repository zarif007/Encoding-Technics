/*
Basic of DM or Δ-modulation
➡️The analog signal is approximated with a series of segments.
➡️Each segment of the approximated signal is compared to the preceding bits and the successive bits are determined by this comparison.
➡️Only the change of information is sent, that is, only an increase or decrease of the signal amplitude from the previous sample is
sent whereas a no-change condition causes the modulated signal to remain at the same 0 or 1 state of the previous sample.
 */


import java.util.Vector;

public class DeltaModulation {
    public static void main(String[] args) {

        //Example Amplitude of Analog signal 📈
        int [] [] Amplitude_of_Analog_signal = {
                {1, 1}, {2, 2}, {3, 3}, {3, 3}, {5, 5}, {4,4}, {2, 2}, {3, 3}, {1, 1}
        };

        Vector<Integer> Generated_Binary_data = encodeIt(Amplitude_of_Analog_signal);
        System.out.println(Generated_Binary_data);
    }

    private static Vector<Integer> encodeIt(int[][] amplitude_of_analog_signal) {

        //Data set for storing Digital Signal 🗃️
        Vector<Integer> Generated_Binary_data = new Vector<Integer>(amplitude_of_analog_signal.length);
        Generated_Binary_data.add(1);

        int [] Delta_StairCase = new int[2];

        for(int i=0; i<amplitude_of_analog_signal.length-1; i++){
            
            Delta_StairCase[0] = amplitude_of_analog_signal[i][0];
            Delta_StairCase[1] = amplitude_of_analog_signal[i][1];

            if(Delta_StairCase[0] < amplitude_of_analog_signal[i + 1][0]){
                Generated_Binary_data.add(1);
            } else if (Delta_StairCase[0] > amplitude_of_analog_signal[i + 1][0]){
                Generated_Binary_data.add(0);
            } else {
                Generated_Binary_data.add(Generated_Binary_data.get(i - 1));
            }
        }

        return Generated_Binary_data;
    }
}
