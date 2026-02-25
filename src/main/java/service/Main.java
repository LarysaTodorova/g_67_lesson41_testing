package service;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayService service = new ArrayService();

        int[] result = service.generateArrayBySize(5);
        System.out.println(Arrays.toString(result));

        result = service.generateArrayBySize(3);
        System.out.println(Arrays.toString(result));

        result = service.generateArrayBySize(14);
        System.out.println(Arrays.toString(result));

        result = service.generateArrayBySize(-1);
        System.out.println(Arrays.toString(result));
    }
}
