package by.grodno.porokhonkoevgeniy.arrays;

public class ArrayTypeA extends ArrayType {
    @Override
    public void sizeOfArray(int pLength, int pHeight) {
        int[][] arr = new int[pHeight][pLength];
        int number = 1;
        for (int i = 0; i < pHeight; i++) {
            for (int j = 0; j < pLength; j++) {
                arr[i][j] = number;
                number++;
            }
        }
        super.writeArrayToConsole(arr, pLength, pHeight);

    }
}
