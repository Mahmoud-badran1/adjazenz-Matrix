package com.company;

public class Bridge {
    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    int[][] numArray;
    int[][] wegMatrix = new int[ROWS][COLUMNS];


    int[][] adjMatrix;
    static int[] low_value, dfs;
    static int num = 1;
    static int no_Vertices;
    static boolean[] check;
    int size = wegMatrix.length;


    public Bridge(int[][] numArray) {
        this.numArray = numArray;
    }
    public void bruecke() {
        no_Vertices = size;
        System.out.println("\n\n Die Brücke \n\n");
        int[][] adjMatrix = new int[ROWS][COLUMNS];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = numArray[i][j];
                if (i == j) {
                    adjMatrix[i][j] = 1;
                }
            }
        }

        low_value = new int[no_Vertices];
        dfs = new int[no_Vertices];

        for (int i = 0; i < no_Vertices; i++) {
            if (dfs[i] == 0) {
                schnitkante(adjMatrix, i, i);
            }
        }
    }

    static void schnitkante(int[][] adjMatrix, int vertex, int pre) { // cutedge
        low_value[vertex] = dfs[vertex] = num++;

        for (int v = 0; v < no_Vertices; v++) {
            if (v == pre) continue;
            if (adjMatrix[vertex][v] == 1) {
                if (dfs[v] != 0) {
                    low_value[vertex] = Math.min(low_value[vertex], dfs[v]);
                } else {
                    schnitkante(adjMatrix, v, vertex);
                    low_value[vertex] = Math.min(low_value[vertex], low_value[v]);
                    if (low_value[v] > dfs[vertex]) {
                        System.out.println((vertex + 1) + " ----- " + (v + 1));
                    }
                }
            }
        }
    }


}
