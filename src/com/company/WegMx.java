package com.company;

import java.util.ArrayList;

public class WegMx {
    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    int[][] numArray;
    int[][] array = new int[ROWS][COLUMNS];
    ArrayList<Integer> exzetMatrix = new ArrayList<Integer>();
    int[][] wegMatrix = new int[ROWS][COLUMNS];

    public WegMx(int[][] numArray) {
        this.numArray = numArray;
    }

    public void pathMatrix( int potenz) {
        int[][] pathResult = new int[ROWS][COLUMNS];
        int[][] copiedMainMatrix_path = new int[ROWS][COLUMNS];
        int[][] pathArray = new int[ROWS][COLUMNS];


        System.out.println("\n----------- WegMatrix ------------- \n");


        for (int i = 0; i < numArray.length; i++) {
            for (int j = 0; j < numArray.length; j++) {
                pathArray[i][j] += numArray[i][j]; // Kopieren zu array
                copiedMainMatrix_path[i][j] += numArray[i][j]; // Kopieren zu array
            }
        }

        for (int path_count = 1; path_count < 6; path_count++) {   // 6 times TODO
            for (int zeile = 0; zeile < numArray.length; zeile++) {
                for (int spalte = 0; spalte < numArray.length; spalte++) {
                    pathResult[zeile][spalte] = 0;
                    for (int k = 0; k < numArray.length; k++) {
                        pathResult[zeile][spalte] += pathArray[zeile][k] * numArray[k][spalte]; // erste Zeile mal alle Spalten
                    }
                }
            }


            for (int i = 0; i < numArray.length; i++) {
                for (int j = 0; j < numArray.length; j++) {
                    pathArray[i][j] = pathResult[i][j];
                    if (pathResult[i][j] != 0 && wegMatrix[i][j] == 0) {
                        wegMatrix[i][j] = 1;
                        System.out.print(wegMatrix[i][j] + "");
                    } else {
                        System.out.print(wegMatrix[i][j]);
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println(":::::::::::::");
        }
    }


}
