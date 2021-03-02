package se.rlrio;

public class MultiplicationTable {

    public static void main(String[] args) {

        printMultiplicationTable(10,10);

    }

    private static int[][] multiplicationTable(int y, int x) {
        int [][] array = new int[y][x];
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i+1)*(j+1);
            }
        }
        return array;
    }

    public static void printMultiplicationTable(int y, int x) {
        int[][] result = multiplicationTable(y,x);
        for (int i = 0; i < result.length ; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf("%2d ",result[i][j]);
            }
            System.out.println();
        }
    }
}
