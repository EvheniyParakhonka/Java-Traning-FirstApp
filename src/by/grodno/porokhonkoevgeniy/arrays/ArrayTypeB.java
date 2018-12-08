package by.grodno.porokhonkoevgeniy.arrays;

public class ArrayTypeB extends ArrayType {
    @Override
    public void sizeOfArray(int pLength, int pHeight) {
        int[][] arr = new int[pHeight * 2][pLength * 2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int ii;
                int ij;

                if (i < pHeight/2) {
                    ii = Math.min(i, j);
                } else {
                    ii = Math.min(pHeight - 1 - i, j);
                }

                if (j < pLength/2) {
                    ij = Math.min(i, j);
                } else {
                    ij = Math.min(i, pLength - 1 - j);
                }

                arr[i][j] = Math.min(ii, ij);
            }
        }
        super.writeArrayToConsole(arr, pLength, pHeight);
    }
}
