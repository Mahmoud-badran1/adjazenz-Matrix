package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFile {


    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    int[][] numArray;
    int[][] array = new int[ROWS][COLUMNS];
    int[][] PotenzResult = new int[ROWS][COLUMNS];
    ArrayList<Integer> exzetMatrix = new ArrayList<Integer>();
    int[][] ex = new int[ROWS][COLUMNS];
    int size = array.length;

    public void readFile() throws FileNotFoundException {
        numArray = new int[ROWS][COLUMNS];

        Scanner input = new Scanner(new File("/Users/mahmoudbadran/code/APP/AndroidStudioProjects/Adm/src/com/company/tabelle.csv"));

        while (input.hasNext()) { // String

            for (int i = 0; i < size; i++) {
                String[] line = input.nextLine().trim().split("," + " "); //
                for (int j = 0; j < size; j++) {
                    numArray[i][j] = Integer.parseInt(line[j]); // save the nodes on mainMatrix

                    System.out.print(numArray[i][j] + " ");
                }
                System.out.println();
            }


            for (int i = 0; i < size; i++) {
                System.out.print("konte " + (i + 1) + " is connected to: ");
                for (int j = 0; j < size; j++) {
                    if (numArray[i][j] == 1) {
                        System.out.print((j + 1) + " ");
                    }
                }
                System.out.println();
            }
        }

    }



}
