package Assignment1;

import java.io.FileWriter;
import java.io.IOException;

public class OddonacciExponential {
    public static int counterExpo;

    public static int exponentialOdd(int num){
        counterExpo++;
        int oddVal;
        if (num == 1 || num == 2 || num == 3){
            oddVal =1;
        }else{
            oddVal= exponentialOdd(num-1) + exponentialOdd(num-2) + exponentialOdd(num-3);
        }
        return oddVal;
    }

    public static void main(String[] args) {
        try {
            FileWriter outputExponential = new FileWriter("Assignment1/OddOutExponential.txt");
            long start = 0;
            long end = 0;
            long time;
            for (int i = 5; i <= 40; i += 5) {
                start = System.nanoTime();
                int e = exponentialOdd(i);
                end = System.nanoTime();
                time = end - start;
                outputExponential.write("output for " + i + "="+ e + ", the process was completed in: " + time + "ns and in " + counterExpo +" steps. \n");
                counterExpo = 0;
            }
            outputExponential.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
