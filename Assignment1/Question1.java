package Assignment1;

import java.util.Arrays;

public class Question1 {

    public static int[] algorithm(int[] A){

        int counter = 0;
        int temp = 0;
        int middle = A.length/2;
        if(A.length%2 == 0){
            middle-=1;
        }
        if((A.length/2)%2 != 0){
            middle+=1;
        }
        while(counter<A.length){
            if(counter<middle){
                temp = A[counter];
                A[counter] = A[counter+1];
                A[counter+1] = temp;
                counter++;
            }
            if(counter>middle){
                A[counter+1] += A[counter];
                counter++;
            }
            counter++;
        }
        return A;

    }
    public static int tail(int k, int first, int second, int third){
        if(k==3){
            return third;
        }
        return tail(k-1, second,third, first+second+third);
    }


    public static void main(String[] args) {
//        int [] four = {1,2,3,4};
//        int [] five = {1,2,3,4,5};
//        int [] six = {1,2,3,4,5,6};
//        int [] seven = {1,2,3,4,5,6,7};
//
//        int [] fouralgo = algorithm(four);
//        int [] fivealgo = algorithm(five);
//        int [] sixalgo = algorithm(six);
//        int [] sevenalgo = algorithm(seven);
//
//        System.out.println(Arrays.toString((fouralgo)));
//        System.out.println(Arrays.toString((fivealgo)));
//        System.out.println(Arrays.toString((sixalgo)));
//        System.out.println(Arrays.toString((sevenalgo)));
        System.out.println(tail(10,1,1,1));
    }
}
