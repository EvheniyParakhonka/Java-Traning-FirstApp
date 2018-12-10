package by.grodno.porokhonkoevgeniy.arrays;

public abstract class ArrayType {
    public abstract void sizeOfArray(int pLength, int pHeight);

    void writeArrayToConsole(int[][] arr, int pLength, int pHeight) {
        for (int i = 0; i < pHeight; i++) {
            System.out.println(" ");
            for (int j = 0; j < pLength; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
