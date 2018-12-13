package by.grodno.porokhonkoevgeniy.arrays;

public class ArrayTypeA implements IArrayType {
    @Override
    public int[][] generateArray(int pLength, int pHeight) {
        int[][] arr = new int[pHeight][pLength];

        for (int i = 0; i < pHeight; i++) {
            for (int j = 0; j < pLength; j++) {
               String number = "" + (i + 1) + (j + 1);
                arr[i][j] = Integer.parseInt(number) ;
            }
        }
        return arr;
    }
}
