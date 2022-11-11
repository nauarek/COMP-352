import java.io.*;

public class Part2_A {
    public static void main(String[] args) {
        //take first argument as input file
        //take second argument as output file
        String inputFileName = args[0];
        //String inputFileName = "in.txt";
        String outputFileName = args[1];
        //String outputFileName = "out.txt";

        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFileName));
            FileWriter out = new FileWriter (outputFileName);

            int noOfDatasets = Integer.parseInt(in.readLine());
            //go through each line
            //split the line by spaces
            //take the first number as the size of the array.
            //take the initial marker
            //input rest of numbers into array
            //input a zero at the end
            //send the array to the method to be tested
            //write to output file the result
            for (int i=0;i<noOfDatasets;i++){
                String input = in.readLine();
                String[] parts = input.split(" ");
                int arraySize = Integer.parseInt(parts[0]);
                int initialMarker = Integer.parseInt(parts[1]);
                int[] strikeZeroArray = new int [arraySize];
                int arrPos = 0;
                for(int j=2;j<parts.length;j++){
                    strikeZeroArray[arrPos] = Integer.parseInt(parts[j]);
                    arrPos++;
                }
                strikeZeroArray[arraySize-1] = 0;
                //call the function
                int result = recursiveGame(strikeZeroArray,initialMarker);
                out.write(result+"\n");
            }
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int recursiveGame(int[] array, int marker) {
        int currentPositionValue = array[marker];
        int valueAbsolute = Math.abs(array[marker]);
        if (marker == array.length-1) {
            return 1;
        }
        if (array[marker] == 0) {
            return 0;
        }
        if(currentPositionValue<0){
            array[marker] = 0;
        }else {
            array[marker] = (currentPositionValue * -1);
        }
        if (marker + currentPositionValue < array.length && currentPositionValue>0) {
            marker = marker+currentPositionValue;
        } else if (marker - valueAbsolute >= 0) {
            marker = marker - valueAbsolute;
        }
        return recursiveGame(array,marker);
    }
}


