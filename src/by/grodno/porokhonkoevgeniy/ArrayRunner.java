package by.grodno.porokhonkoevgeniy;

import by.grodno.porokhonkoevgeniy.arrays.ArrayTypeA;
import by.grodno.porokhonkoevgeniy.arrays.ArrayTypeB;
import by.grodno.porokhonkoevgeniy.arrays.ArrayTypeC;
import by.grodno.porokhonkoevgeniy.arrays.IArrayType;
import by.grodno.porokhonkoevgeniy.utils.StringResources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ArrayRunner {
    private IArrayType mArrayCreator;
    private int mLength;
    private int mHeight;

    ArrayRunner() {
    }

    void run() {
        getSizeAndTypeForArray();
    }

    private void getSizeAndTypeForArray() {
        //        get length
        do {
            mLength = readFromConsoleInteger(StringResources.MATRIX_LENGTH);
            //  in the task we need to get the number 0 to 10
        } while (mLength < 0 || mLength > 10);
//        get height
        do {
            mHeight = readFromConsoleInteger(StringResources.MATRIX_HEIGHT);
        } while (mHeight < 0 || mHeight > 10);
//        get type of array
        do {
            mArrayCreator = readTypeFromConsole();
        } while (mArrayCreator == null);

        writeArrayToConsole(mArrayCreator.generateArray(mLength, mHeight));
    }

    private IArrayType readTypeFromConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(StringResources.MATRIX_TYPE);
        try {
            switch (br.readLine()) {
                case "A":
                    mArrayCreator = new ArrayTypeA();
                    break;
                case "B":
                    mArrayCreator = new ArrayTypeB();
                    break;
                case "C":
                    mArrayCreator = new ArrayTypeC();
                    break;
                default:
                    mArrayCreator = null;
                    break;
            }
        } catch (IOException pE) {
            System.err.println("IOException: " + pE);
            readTypeFromConsole();
        }
        return mArrayCreator;
    }

    private int readFromConsoleInteger(String pMsgForInput) {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(pMsgForInput);
        try {
            i = Integer.parseInt(br.readLine());
        } catch (NumberFormatException pE) {
            System.out.println("Invalid Format! Please, enter number!");
            return -1;
        } catch (IOException pE) {
            System.err.println("IOException: " + pE);
            return -1;
        }
        return i;
    }

    private void writeArrayToConsole(int[][] arr) {
        for (int i = 0; i < mHeight; i++) {
            System.out.println(" ");
            for (int j = 0; j < mLength; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
