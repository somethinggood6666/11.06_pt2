package by.epam.shchemelev;

import by.epam.shchemelev.exceptions.EmptyArrayException;
import by.epam.shchemelev.exceptions.UnknownParameterException;

public class JaggedArrayOperations {

    public static void sortBy(int[][] array, String sortType, String order){
        requireNotEmptyArray(array);
        for (int i = array.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (isSortingCondition(order, sortType, array[j], array[j + 1])){
                    swapRows(array, j, j + 1);
                }
            }
        }
    }

    private static boolean isSortingCondition(String order, String sortType, int[] row1, int[] row2) {
        if (order.equalsIgnoreCase("straight")){
            return isConditionForStraightSort(sortType, row1, row2);
        }
       if (order.equalsIgnoreCase("reverse")){
            return isConditionForReverseSort(sortType, row1, row2);
        }

        try {
            throw new UnknownParameterException("Unknown sorting order");
        } catch (UnknownParameterException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }

    private static boolean isConditionForStraightSort(String sortType, int[] row1, int[] row2){
        if (sortType.equalsIgnoreCase("elements_sum")){
            return findSumOfRowElements(row1) > findSumOfRowElements(row2);
        }
        if (sortType.equalsIgnoreCase("maximal_elements")){
            return findSumOfRowElements(row1) > findSumOfRowElements(row2);
        }
        if (sortType.equalsIgnoreCase("minimal_elements")){
            return findMaximalElement(row1) > findMaximalElement(row2);
        }
        unknownSortTypeGiven();
        return false;
    }

    private static void unknownSortTypeGiven() {
        try {
            throw new UnknownParameterException("Unknown sort type parameter");
        } catch (UnknownParameterException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static boolean isConditionForReverseSort(String sortType, int[] row1, int[] row2){
        if (sortType.equalsIgnoreCase("elements_sum")){
            return findSumOfRowElements(row1) < findSumOfRowElements(row2);
        }
        if (sortType.equalsIgnoreCase("maximal_elements")){
            return findSumOfRowElements(row1) < findSumOfRowElements(row2);
        }
        if (sortType.equalsIgnoreCase("minimal_elements")){
            return findMaximalElement(row1) < findMaximalElement(row2);
        }

        unknownSortTypeGiven();
        return false;
    }

    private static int findMinimalElement(int[] array){
        int minimalIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minimalIndex]){
                minimalIndex = i;
            }
        }
        return array[minimalIndex];
    }

    private static int findMaximalElement(int[] array){
        int maximalIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maximalIndex]){
                maximalIndex = i;
            }
        }
        return array[maximalIndex];
    }

    private static int findSumOfRowElements(int[] ints) {
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }
        return sum;
    }

    private static void requireNotEmptyArray(int[][] array) {
        if (array == null || array.length == 0){
            try {
                throw new EmptyArrayException("Array must not be empty");
            } catch (EmptyArrayException e) {
                e.printStackTrace();
            }
        }
    }

    public static void swapRows(int[][] array, int r1, int r2){
        int[] newR1 = array[r2];
        int[] newR2 = array[r1];
        array[r1] = newR1;
        array[r2] = newR2;
    }

}
