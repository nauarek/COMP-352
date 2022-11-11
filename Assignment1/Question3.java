package Assignment1;

public class Question3 {
    public static boolean fiveOccurences(int[] A, int x){
        int len = A.length;
        int start =0;
        int end = len-1;
        int pos =0;

        while(start<=end){
            int middle = start+end/2;
            if(A[middle]<x){
                start=middle-1;
                pos=middle;
            }
            if(A[middle] == x){
                pos=middle;
                break;
            }
            end=middle;
        }
        if (A[pos] ==x){
            int occurences = 0;
            for(int j=pos-5; j<pos+5; j++){
                if(0<=j && j<A.length){
                    if(A[j] == x){
                        occurences++;
                    }
                }
            }
            if(occurences==5){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,3,4,5,5,5,5,6,7,8,9,9,9,9,9,40,582};
        int x = 9;
        boolean yo = fiveOccurences(array,x);
        System.out.println(fiveOccurences(array,x));
    }
}
