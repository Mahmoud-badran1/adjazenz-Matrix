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
    int num = 0;


    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.readFile();
        main.potenzMatrix();

        /*
        copy Ex from result
        ein Methode erstellen um das Distance matrix zu erstellen
        if (Ex [i][j] != 0 )
            EX[i][j] = i;

            todo
         */

         /*
        durchmesser :
      if (max = EX[i][j])
        durchmesser =  array[i][j]
        todo
         */



         /*
        radius :
      if (min = Ex[i][j])
        redius =  Ex[i][j]
        todo
         */


         /*
         if i == j:

        ein Methode erstellen um das wegmatrix zu erstellen
        if (array[i][j] != 0 )
            array[i][j] = 1;
            todo
         */

        /*
        wie kann man die Komponenten rechnen
        todo
         */

        /*
        Brücke
        wenn a != Radius && b != Radius

        da gibt es eine Brücke
        todo
         */


    }


    private void readFile() throws FileNotFoundException {
        numArray = new int[ROWS][COLUMNS];


        Scanner sc = new Scanner(new File("/Users/mahmoudbadran/code/APP/AndroidStudioProjects/Adm/src/com/company/tabelle.csv"));

        while (sc.hasNext()) {

            for (int i = 0; i < numArray.length; i++) {
                String[] line = sc.nextLine().trim().split("," + " ");
                for (int j = 0; j < line.length; j++) {

                    numArray[i][j] = Integer.parseInt(line[j]);

                    System.out.print(numArray[i][j] + " ");

                }
                System.out.println();

            }
            for (int i = 0; i < numArray.length; i++) {
                System.out.print("konte " + (i + 1) + " is connected to:");
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

        int[][] result = new int[ROWS][COLUMNS];
        int[][] array = new int[ROWS][COLUMNS];
        int[][] ex = new int[ROWS][COLUMNS];


        System.out.println(" rechnen das Potenzmartrix: AG");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                array[i][j] += numArray[i][j];

                ex[i][j] += numArray[i][j];


            }


        }

        /*
        das gehört nur jz dazu
        es sollte gelöscht werden und mit einer Bedinung z.b if array[i][i] != 0 dann stop
        (innerhalb der 2te for)
        todo 1
         */
        int exProben = 6;

        for (int a = 1; a < exProben; a++) {

            for (int oo = 0; oo < result.length; oo++) {
                for (int p = 0; p < result.length; p++) {
                    //
                    result[oo][p] = 0;

                    for (int k = 0; k < result.length; k++) {

                        result[oo][p] += array[oo][k] * numArray[k][p];


                    }

                }
            }
            System.out.println("*********************");


                /*
                PotenzMatrix
                 */
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {


                    System.out.print(result[i][j] + " ");

                    array[i][j] = result[i][j];


                }
                System.out.println();

            }
            System.out.println("\n----------- EX ------------- \n");

                /*
                Distance Matrix
                 */

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {

                    array[i][j] = result[i][j];


                    //   System.out.print(result[i][j]);
                    if (result[i][j] != 0 && ex[i][j] == 0 && i != j) {
                        ex[i][j] = (a+1);
                        System.out.print( ex[i][j] +"");
                    } else {
                        System.out.print(ex[i][j]);
                    }

                    System.out.print(" ");

                    //System.out.print(ex[i][j]+ " ");
                }
                System.out.println();

            }
        }


        int maxValue = ex[0][0];
        int zeile = 0;
        for (int i = 0; i < ex.length; i++) {
            for (int j = 0; j < ex.length; j++) {
                if (ex[i][j] > maxValue) {
                    zeile = i;
                    maxValue = ex[i][j];
                }
            }
        }

        System.out.println("\nzeile nummer "+ (zeile+1));
        System.out.println("\nThe max value of ex: "+ maxValue);




//        int exZentrität = ex[0][0];


        int exNumber = ex[0][0];

        for (int i = 0; i < ex.length; i++) {
            for (int j = 0; j < ex.length; j++) {

                if (ex[i][j] > exNumber) {
                    exNumber = ex[i][j];
                    System.out.print(" " + exNumber);

                }
            }
            System.out.println();
        }
    }
}