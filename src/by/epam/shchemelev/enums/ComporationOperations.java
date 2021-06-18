package by.epam.shchemelev.enums;

import by.epam.shchemelev.interfaces.Comparable;

public enum ComporationOperations implements Comparable {
    MORE{
        @Override
        public boolean compareTo(int x, int y){
            return x > y;
        }
    },

    LESS{
        @Override
        public boolean compareTo(int x, int y){
            return x < y;
        }
    }
}
