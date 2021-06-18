package by.epam.shchemelev.arrayops;

import by.epam.shchemelev.enums.ComporationOperations;
import by.epam.shchemelev.enums.SortingFactor;
import by.epam.shchemelev.enums.SortTypes;
import by.epam.shchemelev.exceptions.EmptyArrayException;
import by.epam.shchemelev.interfaces.Comparable;

public class JaggedArrayOperations {

    public static void bubbleSortBy(int[][] array, SortingFactor sortParameter, SortTypes sortType){
        requireNotEmptyArray(array);
        for (int i = array.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (isSortingCondition(sortType, sortParameter, array[j], array[j + 1])){
                    swapRows(array, j, j + 1);
                }
            }
        }
    }

    private static boolean isSortingCondition(SortTypes sortType, SortingFactor sortParameter, int[] row1, int[] row2) {
        if (sortType == SortTypes.STRAIGHT){
            return isConditionForStraightSort(sortParameter, row1, row2);
        }
        return isConditionForReverseSort(sortParameter, row1, row2);
    }

    private static boolean isConditionForStraightSort(SortingFactor sortingFactor, int[] row1, int[] row2){
        Comparable operation = ComporationOperations.MORE;
        return sortingFactor.compare(row1, row2, operation);
    }

    private static boolean isConditionForReverseSort(SortingFactor sortingFactor, int[] row1, int[] row2){
        Comparable operation = ComporationOperations.LESS;
        return sortingFactor.compare(row1, row2, operation);
    }

    private static void swapRows(int[][] array, int r1, int r2){
        int[] newR1 = array[r2];
        int[] newR2 = array[r1];
        array[r1] = newR1;
        array[r2] = newR2;
    }

    private static void requireNotEmptyArray(int[][] array) {
        if (array == null || array.length == 0){
            try {
                throw new EmptyArrayException("Array must not be empty");
            } catch (EmptyArrayException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

}
