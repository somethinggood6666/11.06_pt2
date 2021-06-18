package by.epam.shchemelev.utils;

public class SortUtils {

    public static int findSumOfRowElements(int[] ints) {
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }
        return sum;
    }

    public static int findMaximalElement(int[] array){
        int maximalIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maximalIndex]){
                maximalIndex = i;
            }
        }
        return array[maximalIndex];
    }

    public static int findMinimalElement(int[] array){
        int minimalIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minimalIndex]){
                minimalIndex = i;
            }
        }
        return array[minimalIndex];
    }



}
