package by.epam.shchemelev.enums;

import by.epam.shchemelev.interfaces.Comparable;
import by.epam.shchemelev.interfaces.Comparator;
import by.epam.shchemelev.utils.SortUtils;

public enum SortingFactor implements Comparator {
    ELEMENTS_SUM{
        @Override
        public boolean compare(int[] arr1, int[] arr2, Comparable operation){
            int x = SortUtils.findSumOfRowElements(arr1);
            int y = SortUtils.findSumOfRowElements(arr2);
            return operation.compareTo(x, y);
        }
    },

    MAXIMAL_ELEMENTS {
        @Override
        public boolean compare(int[] arr1, int[] arr2, Comparable operation){
            int x = SortUtils.findMaximalElement(arr1);
            int y = SortUtils.findMaximalElement(arr2);
            return operation.compareTo(x, y);
        }
    },

    MINIMAL_ELEMENTS {
        @Override
        public boolean compare(int[] arr1, int[] arr2, Comparable operation){
            int x = SortUtils.findMinimalElement(arr1);
            int y = SortUtils.findMinimalElement(arr2);
            return operation.compareTo(x, y);
        }
    }
}
