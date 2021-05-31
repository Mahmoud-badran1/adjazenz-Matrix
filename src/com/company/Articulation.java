package com.company;

public class Articulation {

    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    int[][] numArray;
    int[][] wegMatrix = new int[ROWS][COLUMNS];


    int[][] adjMatrix;
    static int[] low_value, dfs; // low
    static int num = 1;
    static int no_Vertices;
    static boolean[] check; //art
    int size = wegMatrix.length;

    public Articulation(int[][] numArray) {
        this.numArray = numArray;
    }
    public void articulation() {
        no_Vertices = size;

        int[][] adjMatrix = new int[ROWS][COLUMNS];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = numArray[i][j];
                if (i == j) {
                    adjMatrix[i][j] = 1; // Haupt diagonal
                }
            }
        }

        low_value = new int[no_Vertices];
        dfs = new int[no_Vertices];
        check = new boolean[no_Vertices];

        schneid_vertices(adjMatrix, 0, -1);

        System.out.println("articulation points sind: ");
        for (int i = 0; i < no_Vertices; i++) {
            if (check[i]) {
                System.out.println(" der Knote : " + (i + 1));
            }
        }
    }

    public void schneid_vertices(int[][] adjMatrix, int vertex, int point) { //cutvertices
        low_value[vertex] = dfs[vertex] = num++;
        int child = 0;
        for (int v = 0; v < no_Vertices; v++) {
            if (adjMatrix[vertex][v] == 1) {
                if (dfs[v] != 0) {
                    low_value[vertex] = Math.min(low_value[vertex], dfs[v]);
                } else {
                    child++;
                    schneid_vertices(adjMatrix, v, vertex);
                    low_value[vertex] = Math.min(low_value[vertex], low_value[v]);
                    if (low_value[v] >= dfs[vertex]) {
                        check[vertex] = true;
                    }
                }
            }
        }


        if (point == -1 && child < 2) {
            check[vertex] = false;
        }
    }



}
