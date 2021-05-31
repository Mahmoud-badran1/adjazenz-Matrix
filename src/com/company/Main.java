package com.company;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author DevMecha
 */
public class Main {


    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    int[][] numArray = new int[ROWS][COLUMNS];


    public static void main(String[] args) throws FileNotFoundException {

        Main main = new Main();
        ReadFile rf = new ReadFile();
        rf.readFile();
        main.numArray = rf.numArray;
        PotenzMatrix potenzMatrix = new PotenzMatrix(main.numArray);
        DistanceMatrix distanceMatrix = new DistanceMatrix(main.numArray);
        WegMx wegMx = new WegMx(main.numArray);
        Articulation art = new Articulation(main.numArray);
        Bridge bridge = new Bridge(main.numArray);


        System.out.println("\nprint the Potence Matrix\n");
        potenzMatrix.potenzMatrix(4);

        System.out.println("\nprint the Distance Matrix\n");
        distanceMatrix.dis_Matrix(4);

        System.out.println("\nprint the Path Matrix\n");
        wegMx.pathMatrix(4);

        System.out.println("\nprint the Radius, Diameter\n");
        distanceMatrix.caluclate_Rad_diameter();

        System.out.println("\nprint the Articulation\n");
        art.articulation();

        System.out.println("\nprint the Bridge\n");
        bridge.bruecke();

    }

}

