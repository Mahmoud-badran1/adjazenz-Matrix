package com.company;

import javax.crypto.CipherOutputStream;
import javax.crypto.spec.PSource;
import javax.swing.*;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileVisitResult;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author DevMecha
 */
public class Main {

    /*
    definiton der Anzahl der Knoten
     */
    private static final int ROWS = 11;
    private static final int COLUMNS = 11;
    private int[][] numArray;
    int[][] wegMatrix = new int[ROWS][COLUMNS];
    int[][] maxArray = new int[ROWS][COLUMNS];
    int groeße = maxArray.length;
    int[][] ex = new int[ROWS][COLUMNS];
    int[][] array = new int[ROWS][COLUMNS];
    int[][] result = new int[ROWS][COLUMNS];
    ArrayList<Integer> exzetMatrix = new ArrayList<Integer>();

    int[][] adjMatrix;


    static int[] low, dfsnum;
    static int num = 1;
    static int noOfVertices;
    static boolean[] art;


    // int num = 0;


    public static void main(String[] args) throws FileNotFoundException {

        Main main = new Main();
        main.readFile();
        main.potenzMatrix();
        main.getArticulate();
        main.getBridge();

    }

    private void readFile() throws FileNotFoundException {
        numArray = new int[ROWS][COLUMNS];


        Scanner sc = new Scanner(new File("/Users/mahmoudbadran/code/APP/AndroidStudioProjects/Adm/src/com/company/tabelle.csv"));


        while (sc.hasNext()) { // String

            for (int i = 0; i < numArray.length; i++) {
                String[] line = sc.nextLine().trim().split("," + " "); //
                for (int j = 0; j < line.length; j++) {

                    numArray[i][j] = Integer.parseInt(line[j]);

                    System.out.print(numArray[i][j] + " ");
                }
                System.out.println();
            }


            for (int i = 0; i < numArray.length; i++) {
                System.out.print("konte " + (i + 1) + " is connected to: ");
                for (int j = 0; j < numArray.length; j++) {
                    if (numArray[i][j] == 1) {
                        System.out.print((j + 1) + " ");
                    }
                }
                System.out.println();
            }
        }
    }


    private void potenzMatrix() {

        // int[][] result = new int[ROWS][COLUMNS];
        // int[][] array = new int[ROWS][COLUMNS];


        System.out.println(" rechnen das Potenzmartrix: AG");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] += numArray[i][j]; // Kopieren zu array
                ex[i][j] += numArray[i][j]; // Kopieren zu array
            }
        }


        for (int a = 1; a < 6; a++) { // 6 times TODO

            for (int zeile = 0; zeile < result.length; zeile++) {
                for (int spalte = 0; spalte < result.length; spalte++) {
                    result[zeile][spalte] = 0;

                    for (int k = 0; k < result.length; k++) {

                        result[zeile][spalte] += array[zeile][k] * numArray[k][spalte]; // erste Zeile mal alle Spalten

                    }

                    //    System.out.println(" -- ");
                }
                //    System.out.println();
            }

                /*
                PotenzMatrix TODO
                 */

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    System.out.print(result[i][j] + " ");
                    array[i][j] = result[i][j]; // speicher das Ergebnis im 2. Array
                    if (i == 0) {
                        exzetMatrix.add(array[i][j]);
                    }
                }
                System.out.println();
            }


            //    System.out.println("\n----------- EX ------------- \n");

                /*
                Distance Matrix
                 */

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    array[i][j] = result[i][j];
                    if (result[i][j] != 0 && ex[i][j] == 0 && i != j) {
                        ex[i][j] = (a + 1);
                        System.out.print(ex[i][j] + "");
                    } else {
                        System.out.print(ex[i][j]);
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }

            System.out.println("\n----------- wegMatrix ------------- \n");


            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    array[i][j] = result[i][j];
                    if (result[i][j] != 0 && wegMatrix[i][j] == 0) {
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

        int exNumber = ex[0][0];

        //  int[][] maxArray = new int[ROWS][COLUMNS];

        for (int i = 0; i < ex.length; i++) {
            for (int j = 0; j < ex.length; j++) {
                for (int k = 0; k < ex.length; k++) {
                    if (ex[i][k] > 2) { // Todo
                        maxArray[i][k] = ex[i][k];
                    }
                }
            }
        }

        System.out.println("\n\n-----------The numbers--------\n\n");


        /*
        the Exzentrität
        + max value
         */

        ArrayList<Integer> exzentritätNumbers = new ArrayList<Integer>();

        for (int i = 0; i < maxArray.length; i++) {
            exNumber = 0; // um nur eines Ergebnis
            for (int j = 0; j < maxArray.length; j++) {
                //System.out.print(maxArray[i][j] + " ");
                if (maxArray[i][j] > exNumber) {
                    exNumber = maxArray[i][j];
                    exzentritätNumbers.add(exNumber);
                }

            }

            System.out.println("Knote= " + (i + 1) + " Extzrität : " + exNumber);
        }
        /*
        clalculating the rad
         */


        int rad = groeße;
        int durchMesser = 0;

        /*
        DurchMesser
         */
        for (int i : exzentritätNumbers
        ) {
            durchMesser = MatrixMath.max(i, durchMesser);

        }
        System.out.println("\n Der DuchMesser is: " + durchMesser);

        /*
        Radius
         */

        for (int j : exzentritätNumbers
        ) {
            rad = MatrixMath.min(j, rad);
        }
        System.out.println("\n Das radius is: " + rad);


    /*
    Zentrum
     */

        int centerInt = 0;
        for (int i = 0; i < groeße; i++) {
            for (int j = 0; j < groeße; j++) {
                if (maxArray[i][j] == rad)
                    centerInt = (i + 1);
                break;
            }
        }
        System.out.println("\n der Zentrum(Zeile) ist = " + centerInt);
    }

    public void getArticulate() {

        noOfVertices = groeße;

        System.out.println("\n\n the articulation \n\n");
        int[][] adjMatrix = new int[ROWS][COLUMNS];


        for (int i = 0; i < groeße; i++) {
            for (int j = 0; j < groeße; j++) {
                adjMatrix[i][j] = numArray[i][j];
                if (i == j) {
                    adjMatrix[i][j] = 1;
                }

                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        low = new int[noOfVertices];
        dfsnum = new int[noOfVertices];
        art = new boolean[noOfVertices];

        cutVertices(adjMatrix, 0, -1);

        System.out.println("Cut vertex / articulation points are: ");
        for (int i = 0; i < noOfVertices; i++) {
            if (art[i]) {
                System.out.println(" the node : " + (i + 1));
            }
        }

    }

    public void cutVertices(int[][] adjMatrix, int vertex, int p) {
        low[vertex] = dfsnum[vertex] = num++;

        int child = 0;
        for (int v = 0; v < noOfVertices; v++) {
            if (adjMatrix[vertex][v] == 1) {
                if (dfsnum[v] != 0) {
                    low[vertex] = Math.min(low[vertex], dfsnum[v]);
                } else {
                    child++;
                    cutVertices(adjMatrix, v, vertex);
                    low[vertex] = Math.min(low[vertex], low[v]);
                    if (low[v] >= dfsnum[vertex]) {
                        art[vertex] = true;
                    }
                }
            }
        }

        if (p == -1 && child < 2) {
            art[vertex] = false;
        }
    }


    public void getBridge() {


        noOfVertices = groeße;

        System.out.println("\n\n the Bridge \n\n");
        int[][] adjMatrix = new int[ROWS][COLUMNS];


        for (int i = 0; i < groeße; i++) {
            for (int j = 0; j < groeße; j++) {
                adjMatrix[i][j] = numArray[i][j];
                if (i == j) {
                    adjMatrix[i][j] = 1;
                }

                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }


        low = new int[noOfVertices];
        dfsnum = new int[noOfVertices];

        System.out.println("Cut Edges / Cut Bridges are: ");
        for (int i = 0; i < noOfVertices; i++) {
            if (dfsnum[i] == 0) {
                cutEdges(adjMatrix, i, i);
            }
        }
    }

    static void cutEdges(int[][] adjMatrix, int vertex, int pre) {
        low[vertex] = dfsnum[vertex] = num++;

        for (int v = 0; v < noOfVertices; v++) {
            if (v == pre) continue;
            if (adjMatrix[vertex][v] == 1) {
                if (dfsnum[v] != 0) {
                    low[vertex] = Math.min(low[vertex], dfsnum[v]);
                } else {
                    cutEdges(adjMatrix, v, vertex);
                    low[vertex] = Math.min(low[vertex], low[v]);
                    if (low[v] > dfsnum[vertex]) {
                        System.out.println((vertex+1) + " ----- " + (v+1));
                    }
                }
            }
        }
    }
}

