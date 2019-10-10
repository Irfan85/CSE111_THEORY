package Assignment02;

import javax.management.StandardEmitterMBean;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] x = {{1,1,1},{2,2,2},{3,3,3}};
        int[][] y = {{1,2,3},{4,5,6},{7,8,9}};

        print(x); //{{1,1,1},{2,2,2},{3,3,3}}
        print(y); //{{1,2,3},{4,5,6},{7,8,9}}

        swap(x,y);

        print(x); //{{1,2,3},{4,5,6},{7,8,9}}
        print(y); //{{1,1,1},{2,2,2},{3,3,3}}

        int[][] z = {{1,1,1},{2,2,2},{3,3,3},{4,4,4},{5,5,5},{6,6,6},{7,7,7}};

        int a[][] = reverseRow(z);

        print(z); //{{1,1,1},{2,2,2},{3,3,3},{4,4,4},{5,5,5},{6,6,6},{7,7,7}}
        print(a); //{{7,7,7},{6,6,6},{5,5,5},{4,4,4},{3,3,3},{2,2,2},{1,1,1}};

        int b[][] = join(x,y);

        print(b); //{{1,2,3},{4,5,6},{7,8,9},{1,1,1},{2,2,2},{3,3,3}}
    }

    //You may need to code here

    private static void print(int[][] array){
        System.out.print("{");
        for(int i = 0; i < array.length; i++) {
            System.out.print("{");
            for (int j = 0; j < array[i].length; j++) {
                if (j != array[i].length - 1) {
                    System.out.print(array[i][j] + ",");
                }else {
                    System.out.print(array[i][j]);
                }
            }
            if (i != array.length -1){
                System.out.print("},");
            }else {
                System.out.print("}");
            }

        }
        System.out.print("}\n");
    }

    private static void swap(int[][] x, int[][] y){
        for(int i = 0; i < x.length; i++){
            int[] temp = x[i];
            x[i] = y[i];
            y[i] = temp;
        }
    }

    private static int[][] reverseRow(int[][] array){
        int[][] reversedArray = new int[array.length][array[0].length];

        int k = 0;
        for(int i = array.length -1; i >= 0; i--){
            reversedArray[k++] = array[i];
        }

        return reversedArray;
    }

    private static int[][] join(int[][] array01, int[][] array02){
        int[][] newArray = new int[array01.length + array02.length][array01[0].length];
        int i = 0;
        for(; i < array01.length; i++){
            newArray[i] = array01[i];
        }
        for (int j = 0; j < array02.length; j++){
            newArray[i++] = array02[j];
        }
        return newArray;
    }
}
