package by.grodno.porokhonkoevgeniy.arrays;

public class ArrayTypeC implements IArrayType {
    @Override
    public int[][] generateArray(int pLength, int pHeight) {
        int[][] matrix = new int[pHeight][pLength];
        for (int step = 0, a = 0, size; step < pHeight/2; step++) {
            size = (pHeight - step * 2 - 1);
            for (int i = 0, chunk, chunkIndex, chunkOffset; i < 4 * size; i++) {
                chunk = i / size;
                chunkIndex = i % size;
                chunkOffset = pLength - step - 1;
                switch (chunk) {
                    case 0:
                        matrix[step][chunkIndex + step] = a+1;
                        break;
                    case 1:
                        matrix[chunkIndex + step][chunkOffset] = a+1;
                        break;
                    case 2:
                        matrix[chunkOffset][chunkOffset - chunkIndex] = a+1;
                        break;
                    case 3:
                        matrix[chunkOffset - chunkIndex][step] = a+1;
                        break;
                    default:
                        throw new IndexOutOfBoundsException();
                }
                a++;
            }
            if (pHeight % 2 == 1) {
                matrix[pHeight/2][pLength/2] = pHeight * pLength;
            }
        }
        return matrix;
    }
}
