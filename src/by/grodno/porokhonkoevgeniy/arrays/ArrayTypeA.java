package by.grodno.porokhonkoevgeniy.arrays;

public class ArrayTypeA extends ArrayType {
    @Override
    public void sizeOfArray(int pLength, int pHeight) {
        int[][] arr = new int[pHeight][pLength];

        for (int i = 0; i < pHeight; i++) {
            for (int j = 0; j < pLength; j++) {
               String number = "" + (i + 1) + (j + 1);
                arr[i][j] = Integer.parseInt(number) ;
            }
        }
        super.writeArrayToConsole(arr, pLength, pHeight);

    }
}
