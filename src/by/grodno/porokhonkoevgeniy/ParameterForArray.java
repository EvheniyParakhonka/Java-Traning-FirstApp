package by.grodno.porokhonkoevgeniy;

import by.grodno.porokhonkoevgeniy.arrays.ArrayType;
import by.grodno.porokhonkoevgeniy.arrays.ArrayTypeA;
import by.grodno.porokhonkoevgeniy.arrays.ArrayTypeB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class ParameterForArray {
    private Map<String, ArrayType> mTypeArrayMap;
    private ArrayType mArrayCreator;

    ParameterForArray() {
        mTypeArrayMap = new HashMap<>();
        mTypeArrayMap.put("A", new ArrayTypeA());
        mTypeArrayMap.put("B", new ArrayTypeB());
        getSizeAndTypeForArray();
    }

    private void getSizeAndTypeForArray() {
        int length;
        int height;
//        get length
        do {
            length = readFromConsoleInteger("Please, enter length, not more 10: ");
            //  in the task we need to get the number 0 to 10
        } while (length < 0 || length > 10);
//        get height
        do {
            height = readFromConsoleInteger("Please enter height, not more 10: ");
        } while (height < 0 || height > 10);
//        get type of array
        do {
            mArrayCreator = readTypeFromConsole();
        } while (mArrayCreator == null);

        mArrayCreator.sizeOfArray(length, height);
    }

    private ArrayType readTypeFromConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter matrix type, A or B: ");
        try {
            mArrayCreator = mTypeArrayMap.get(br.readLine());
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
}
