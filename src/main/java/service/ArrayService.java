package service;

public class ArrayService {

    public int[] generateArrayBySize(int size) {
        if (size < 0) {
            throw new IncorrectArraySizeException("Array's size can't be negative");
        }

        int[] result = new int[size];

        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
