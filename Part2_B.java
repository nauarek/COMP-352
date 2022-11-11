import java.io.*;
import java.util.Stack;

public class Part2_B {
    public static void main(String[] args) {
        //create a base stack with the values as given in txt file
        //create a manipulation stack that is initially a copy of the base stack
        //check the top value (A[0]) to go to the right that amount you pop the number of times equivalent to the value obtained
        //if you want to go to the left you push for that amount of value from the base stack to the manipulation stack
        //in order to do this a pointer may be necessary to keep track of from where in the base stack we need to push from (ex. positions 4,3,2,1 in the stack)
        //after accessing a value from the stack, the value should be changed to negative on the base stack
        //because of this change whenever pushing to the manipulation stack the values should always be given in absolute value
        //similarly to the part A code, if a negative value is accessed (accessing a value for a second time) the value in the base stack is changed to zero
        //the "win" condition would be when the stack is empty as we would have reached the zero at the end of the array

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
                int result = stackVersion(strikeZeroArray,initialMarker);
                out.write(result+"\n");
            }
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int stackVersion(int[] array, int marker) {
        int sizeOfArray = array.length;
        Stack<Integer> baseStack = new Stack<>();
        Stack<Integer> manipulationStack = new Stack<>();
        for (int i = array.length - 1; i >= 0; i--) {
            baseStack.push(array[i]);
            if(i>=marker) {
                manipulationStack.push(array[i]);
            }
        }
        do {
            int mSize = manipulationStack.size();
            int topOfStackValue = manipulationStack.elementAt(mSize - 1);
            if (baseStack.elementAt(mSize-1) == 0 && mSize == 1) {
                return 1;
            }
            if (baseStack.elementAt(mSize-1) == 0 && mSize > 1) {
                return 0;
            }
            if (topOfStackValue < 0) {
                baseStack.set(mSize - 1, 0);
            } else {
                baseStack.set(mSize - 1, (-1) * topOfStackValue);
            }
            if (topOfStackValue < mSize && topOfStackValue > 0) {
                for (int i = 0; i < topOfStackValue; i++) {
                    manipulationStack.pop();
                }
            }
            else if (Math.abs(topOfStackValue) + mSize <= sizeOfArray) {
                for (int i = mSize; i < mSize + Math.abs(topOfStackValue); i++) {
                    manipulationStack.push(baseStack.elementAt(i));
                }
            }
        } while (manipulationStack.size() > 0);
        return 0;
    }


}
