package Assignment1;

import java.io.FileWriter;
import java.io.IOException;

public class OddonacciLinear {
    public static int counterLinear;


    public static int[] linearOdd(int num){
        counterLinear++;
        int[] A = new int[3];
        int first =0;
        int second =0;
        int third = 0;
        if(num == 3){
            first = 1;
            second = 1;
            third = 1;
            A[0] = first;
            A[1] = second;
            A[2] = third;
            return A;
        } else{
            A = linearOdd(num-1);
            first=A[0];
            second= A[1];
            third = A[2];
            A[0] = first+second+third;
            A[1] = first;
            A[2] = second;
            return A;
        }
    }




    public static void main(String[] args) {
        try {
            FileWriter outputLinear = new FileWriter("Assignment1/OddoOutLinear.txt");


            long start = 0;
            long end = 0;
            long time;
            for (int i = 5; i <= 40; i += 5) {
                start = System.nanoTime();
                int r = linearOdd(i)[0];
                end = System.nanoTime();
                time = end - start;
                outputLinear.write("output for " + i + "="+ r + ", the process was completed in: " + time + "ns and in " + counterLinear +" steps. \n");
                counterLinear = 0;
            }
            outputLinear.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
