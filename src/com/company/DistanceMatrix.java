package com.company;

import java.util.ArrayList;


public class DistanceMatrix {
    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    int[][] numArray;
    int[][] wegMatrix = new int[ROWS][COLUMNS];
    static int[][] maxArray = new int[ROWS][COLUMNS];
    int size = wegMatrix.length;

    public DistanceMatrix(int[][] numArray) {
        this.numArray = numArray;
    }
    public void dis_Matrix(int potenz) {
        int[][] distanceResult = new int[ROWS][COLUMNS];
        int[][] result = new int[ROWS][COLUMNS];
        int[][] distArray = new int[ROWS][COLUMNS];

        System.out.println("\n----------- DistanzMatrix ------------- \n");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                distArray[i][j] += numArray[i][j]; // Kopieren zu array
                result[i][j] += numArray[i][j]; // Kopieren zu array
            }
        }


        for (int count = 1; count < potenz; count++) {   // 4 times TODO
            for (int zeile = 0; zeile < size; zeile++) {
                for (int spalte = 0; spalte < size; spalte++) {
                    distanceResult[zeile][spalte] = 0;
                    for (int k = 0; k < size; k++) {
                        distanceResult[zeile][spalte] += distArray[zeile][k] * numArray[k][spalte]; // erste Zeile mal alle Spalten

                    }
                }
            }


            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    distArray[i][j] = distanceResult[i][j];
                    if (distanceResult[i][j] != 0 && result[i][j] == 0 && i != j) {
                        result[i][j] = (count + 1);
                        System.out.print(result[i][j] + "");
                    } else {
                        System.out.print(result[i][j]);
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println(" ");


            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        if (result[i][k] > 1) {
                            maxArray[i][k] = result[i][k];
                        }
                    }
                }
            }
        }
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


              /* Todo
              Zentrum

        int centerInt = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (maxArray[i][j] == rad)
                    centerInt = (i + 1);
                break;
            }
        }
        System.out.println("\n der Zentrum(Zeile) ist = " + centerInt);
               */

    }
}
