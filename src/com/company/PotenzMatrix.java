package com.company;

public class PotenzMatrix {

    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    int[][] numArray;
    int[][] wegMatrix = new int[ROWS][COLUMNS];
    static int[][] maxArray = new int[ROWS][COLUMNS];
    int[][] copiedMainMatrix = new int[ROWS][COLUMNS];
    int[][] array = new int[ROWS][COLUMNS];
    int[][] result = new int[ROWS][COLUMNS];
    int[][] potenzMatrix = new int[ROWS][COLUMNS];
    int size = wegMatrix.length;

    public PotenzMatrix(int[][] numArray) {
        this.numArray = numArray;
    }

    public int[][] potenzMatrix(int potenz) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] += numArray[i][j]; // Kopieren zu array
                copiedMainMatrix[i][j] += numArray[i][j]; // Kopieren zu array
            }
        }

        for (int count = 1; count < potenz; count++) { // TODO
            for (int zeile = 0; zeile < size; zeile++) {
                for (int spalte = 0; spalte < size; spalte++) {
                    result[zeile][spalte] = 0;
                    for (int k = 0; k < size; k++) {

                        result[zeile][spalte] += array[zeile][k] * numArray[k][spalte]; // erste Zeile mal alle Spalten
                    }
                    if (count == 1) {
                        potenzMatrix[zeile][spalte] = result[zeile][spalte];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(result[i][j] + " ");
                    array[i][j] = result[i][j];
                }
                System.out.println();
            }
            System.out.println(" ===== ");
        }
        return array;
    }
}
