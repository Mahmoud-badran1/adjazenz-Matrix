package com.company;

import java.util.ArrayList;

public class Radius_DurchMesser {
    private static final int ROWS = 11;
    private static final int COLUMNS = 11;
    int[][] numArray;
    int[][] wegMatrix = new int[ROWS][COLUMNS];
    int[][] maxArray = new int[ROWS][COLUMNS];



    int[][] adjMatrix;
    static int[] low_value, dfs;
    static int num = 1;
    static int no_Vertices;
    static boolean[] check;
    int size = wegMatrix.length;
    DistanceMatrix distanceMatrix = new DistanceMatrix(numArray);



    public Radius_DurchMesser(int[][] numArray, int maxArray[][]) {
        this.numArray = numArray;
        this.maxArray = maxArray;
    }

    public void caluclate_Rad_diameter() {

        ArrayList<Integer> exzentritätNumbers = new ArrayList<Integer>();

        int exNumber;

        for (int i = 0; i < size; i++) {
            exNumber = 0;
            for (int j = 0; j < size; j++) {
                if (maxArray[i][j] > exNumber) {
                    exNumber = maxArray[i][j];
                    exzentritätNumbers.add(exNumber);
                }
            }
            System.out.println("Knote= " + (i + 1) + " Extzrität : " + exNumber);
        }

        int rad = size;
        int durchMesser = 0;

        /*
        DurchMesser
         */

        for (int i : exzentritätNumbers
        ) {
            durchMesser = compare.maximum(i, durchMesser);

        }
        System.out.println("\n Der DuchMesser is: " + durchMesser);

        /*
        Radius
         */

        for (int j : exzentritätNumbers) {
            rad = compare.minmum(j, rad);
        }
        System.out.println("\n Das radius is: " + rad);

              /*
              Zentrum
              */

        int centerInt = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; true; j++) {
                if (maxArray[i][j] == rad)
                    centerInt = (i + 1);
                break;
            }
        }
        System.out.println("\n der Zentrum(Zeile) ist = " + centerInt);

    }

}
